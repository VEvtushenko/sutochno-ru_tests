package ru.sutochno.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class UserPage {

    @Step("Открываем личный кабинет пользователя и проверяем это")
    public UserPage open() {
        $("[aria-label='Личный кабинет']").click();
        $(".user-params-list").shouldHave(text("ID пользователя: 6809367"));
        return this;
    }
}
