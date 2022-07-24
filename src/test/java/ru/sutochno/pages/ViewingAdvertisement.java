package ru.sutochno.pages;


import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ViewingAdvertisement {
    @Step("Проверим имя объявления")
    public ViewingAdvertisement checkTitle(String title) {
        $(".detail-top--name").shouldHave(text(title), Duration.ofSeconds(2));
        return this;
    }
    @Step("Проверим адрес")
    public ViewingAdvertisement checkTitleAddress(String address) {
        $(".detail-top--body").shouldHave(text(address), Duration.ofSeconds(2));
        return this;
    }

    @Step("Проверим основную информацию")
    public ViewingAdvertisement checkMainInfo(String type, String square, String params, String desk/*, String beds*/) {
        $(".object-data--type").shouldHave(text(type + " " + square), Duration.ofSeconds(2));
        $(".object-data--params").shouldHave(text(params));
        $(".object-data--desk").shouldHave(text(desk));
//todo        $(".object-data--beds").shouldHave(text(beds));
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

    @Step("Проверим информацию о депозите")
    @Description("баг - неверно отображается валюта")
    public ViewingAdvertisement checkDepositRules(String depositAmount) {
        $(".rules--deposit").shouldHave(text(format("%s ₽ страховой депозит (возвращается при отъезде)", depositAmount)));
        return this;
    }

    @Step("Проверим информацию о удобствах")
    public ViewingAdvertisement checkEquipments(String equipment) {
        $(".detail-panel .button").click();
        $(".detail-panel").sibling(1).shouldHave(text(equipment));
        return this;
    }
}
