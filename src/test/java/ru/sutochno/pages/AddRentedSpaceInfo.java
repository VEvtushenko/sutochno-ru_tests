package ru.sutochno.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AddRentedSpaceInfo {

//todo
//    @Step("Выберите тип улицы")
//    public AddRentedSpaceInfo chooseStreetType(String streetType) {
//        $("[class='row object-creating-form__row object-creating-form__row-cell visible']")
//                .$("[class='col col-sm-12 col-md-5 col-lg-8']").click();
//        $("[class='row object-creating-form__row object-creating-form__row-cell visible']")
//                .$("[class='col col-sm-12 col-md-5 col-lg-8']").setValue(streetType);
//        return this;
//    }

    @Step("Введите название улицы")
    public AddRentedSpaceInfo chooseStreetName(String streetName) {
        $("[class='row object-creating-form__row object-creating-form__row-cell visible']").sibling(0)
                .$("[class='object-creating-form__form-input form-control untouched pristine required']")
                .setValue(streetName);
    return this;
    }
}
