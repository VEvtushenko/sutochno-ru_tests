package ru.sutochno.pages;


import io.qameta.allure.Step;
import ru.sutochno.base.domain.adverticement.Description;
import ru.sutochno.base.domain.adverticement.general.GeneralInfo;
import ru.sutochno.base.domain.adverticement.general.GuestsVolume;
import ru.sutochno.helpers.NumbersFormatter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ViewingAdvertisement {
    @Step("Проверим имя объявления")
    public ViewingAdvertisement checkTitle(String title) {
        $(".detail-top--name").shouldHave(text(title), Duration.ofSeconds(20));
        return this;
    }
    @Step("Проверим адрес")
    public ViewingAdvertisement checkTitleAddress(String address) {
        $(".detail-top--body").shouldHave(text(address), Duration.ofSeconds(20));
        return this;
    }

    @Step("Проверим основную информацию")
    public ViewingAdvertisement checkMainInfo(GeneralInfo generalInfo, GuestsVolume guestsVolume, Description desk) {
        $(".object-data--type").shouldHave(text(generalInfo.getType().getName() + " " + generalInfo.getSquare().toString()), Duration.ofSeconds(2));
        $(".object-data--params").shouldHave(text(guestsVolume.guestsVolumeDesc() + guestsVolume.getBeds().bedsNumDesc() + guestsVolume.bedroomsDesc() + generalInfo.descFloors()));
        $(".object-data--desk").shouldHave(text(desk.getDescription()));
        $(".object-data--beds").shouldHave(text(guestsVolume.getBeds().singleBedsDesc()));
        $(".object-data--beds").shouldHave(text(guestsVolume.getBeds().doubleBedsDesc()));
        return this;
    }

    @Step("Проверим время въезда, выезда и минимальный срок аренды")
    public ViewingAdvertisement checkIncomingRules(String incoming, String departure, String minimalTime) {
        $(".rules--top").$(".clock").$("div").shouldHave(text(format("Заезд после %s", incoming)), Duration.ofSeconds(2));
        $(".rules--top").$(".clock").$("div").sibling(0).shouldHave(text(format("Отъезд до %s", departure)), Duration.ofSeconds(2));
        $(".rules--top").$(".item").sibling(0).shouldHave(text(format("От %s суток", minimalTime)), Duration.ofSeconds(2));
        return this;
    }

    @Step("Проверим правила аренды")
    public ViewingAdvertisement checkRules(String rules) {
        $(".rules--list").shouldHave(text(rules));
        return this;
    }

    @Step("Проверим информацию о депозите, баг - неверно отображается валюта")
    public ViewingAdvertisement checkDepositRules(Integer depositAmount) {
        $(".rules--deposit").shouldHave(text(format("%s ₽ страховой депозит (возвращается при отъезде)",
                new NumbersFormatter().addDigitSpace(depositAmount))));
        return this;
    }

    @Step("Проверим информацию о удобствах")
    public ViewingAdvertisement checkEquipments(String equipment) {
        $(".detail-panel .button").click();
        $(".detail-panel").sibling(1).shouldHave(text(equipment));
        return this;
    }
}
