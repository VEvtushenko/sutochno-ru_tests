package ru.sutochno.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AddNewAdvertisement {
    @Step("Выбираем тип сдаваемого помещения: квартира/апартаменты/студия")
    public AddNewAdvertisement chooseFlat() {
        $("[class='icon-wp icon-wp-apartment']").click();
        $(".animation-active").shouldHave(text("Квартира"));
        return this;
    }

    @Step("Выберите заголовок объявления")
    public AddNewAdvertisement chooseTitle(String title) {
//        sleep(10000);
        $(".animation-active").shouldHave(text(title), Duration.ofSeconds(30));
        $(".animation-active").$(byText(title)).click();
        return this;
    }

    @Step("Выберите страну")
    public AddNewAdvertisement chooseCountry(String countryName) {
        $("[class='row mb-4']").$(".select-search--btn").click();
        $("[class='row mb-4']").$(".select-search--list").$(byText(countryName)).click();
        return this;
    }

    @Step("Выбрать регион")
    public AddNewAdvertisement chooseRegion(String regionName) {
        $(".js-animate").$(".col-12").$(".row:not(.mb-4)").$(".select-search--btn").click();
        $(".js-animate").$(".col-12").$(".row:not(.mb-4)").$(".select-search--list").$(byText(regionName)).click();
        return this;
    }

    @Step("Выбрать город")
    public AddNewAdvertisement chooseCity(String cityName) {
        $(".js-animate").$(".col-12").$("[class='row object-create__select-row']").$(".select-search--btn").click();
        $(".js-animate").$(".col-12").$("[class='row object-create__select-row']").$(".select-search--list").$(byText(cityName)).click();
        return this;
    }

    @Step("Перейти на следующую страницу")
    public AddAdvertisementInfo toNextPage() {
        /*$("[class='object-create__btn-submit btn btn-primary']").click();*/
        $(byText("Продолжить")).click();
        $(".object-creating__status-text").shouldHave(text("Шаг 1/3: об объекте №"), Duration.ofSeconds(60));
        $("[data='Address']").shouldHave(text("Адрес"), Duration.ofSeconds(60));
        return new AddAdvertisementInfo();
    }

}
