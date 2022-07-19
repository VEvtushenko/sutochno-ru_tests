package ru.sutochno.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class AddNewAdvertisement {
    @Step("Выбираем тип сдаваемого помещения: квартира/апартаменты/студия")
    public AddNewAdvertisement chooseFlat() {
        $("[class='icon-wp icon-wp-apartment']").click();
        $(".animation-active").shouldHave(text("Квартира"));
        return this;
    }

    @Step("Выберите заголовок объявления")
    public AddNewAdvertisement chooseTitle(String title) {
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
        $("[class='col-12 col']").$(".row").$(".row:not(.mb-4)").$(".select-search--btn").click();
        $("[class='col-12 col']").$(".row").$(".row:not(.mb-4)").$(".select-search--list").$(byText(regionName)).click();
        return this;
    }

    @Step("Выбрать город")
    public AddNewAdvertisement chooseCity(String cityName) {
        $("[class='col-12 col']").$(".row").$("[class='row object-create__select-row']").$(".select-search--btn").click();
        $("[class='col-12 col']").$(".row").$("[class='row object-create__select-row']").$(".select-search--list").$(byText(cityName)).click();
        return this;
    }

    @Step("Перейти на следующую страницу")
    public AddAdvertisementInfo toNextPage() {
        $("[class='btn object-create__btn-submit btn btn-primary btn-secondary']").click();
        $(".object-creating__status-text").shouldHave(text("Шаг 1/3: об объекте №"));
        $(".object-creating__loader").shouldHave(text("Адрес"));
        return new AddAdvertisementInfo();
    }

}
