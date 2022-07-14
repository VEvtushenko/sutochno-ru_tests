package ru.sutochno.pages;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class UserPage {

    @Step("Создаём новое объявление")
    public AddNewRentedSpace createNewAdvertisement() {
        $(byLinkText("Разместите свое жилье")).click();
        return new AddNewRentedSpace();
    }


}
