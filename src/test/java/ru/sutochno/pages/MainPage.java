package ru.sutochno.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Открываем главную страницу и проверяем приветственную фразу")
    public MainPage openPage() {
        open("/");
        $(".about__title").shouldHave(text("Суточно.ру — сервис бронирования жилья для поездок"));
        return this;
    }

    @Step("Открываем главную страницу и проверяем вторизацию")
    public MainPage openPageWithAuth(String userName) {
        open("/");
        $(".about__title").shouldHave(text("Суточно.ру — сервис бронирования жилья для поездок"));
        $(".header-right").$(".account").shouldHave(text(userName));
        return this;
    }

    @Step("Открываем главную страницу для разных браузеров и проверяем приветственную фразу")
    public MainPage openPageInAnotherBrowsers(String text) {
        open("/");
        $(".main-block-note").shouldHave(text(text));
        return this;
    }

    @Step("Регистрация средствами пользователя")
    public MainPage registration(String newUserName, String newUserPhone) {
        $(".login-btn").$(withText("Войти")).click();
        $(".auth-header-container").$(byLinkText("Регистрация")).click();
        $(".auth-header-container").$("[placeholder='Введите имя']").setValue(newUserName);
        $(".auth-header-container").$("[placeholder='Введите номер телефона']").setValue(newUserPhone);
        $(".auth-header-container").$(".sc-checkbox--mark").click();
        $(".auth-header-container").$(withText("Зарегистрироваться")).click();

        //todo check
        return this;
    }


    @Step("Однократная авторизация средствами пользователя")
    public MainPage oneAuth(String userPhone, String userPassword, String userName) {
        $(".login-btn").$(withText("Войти")).click();
        $(".auth-header-container").$("[placeholder='Введите e-mail или телефон']").setValue(userPhone);
        $(".auth-header-container").$("[placeholder='Введите пароль']").setValue(userPassword);
        $(".auth-header-container").$(withText("Войти")).click();
        $(".header-right").$(".account").shouldHave(text(userName));
        return this;
    }


}
