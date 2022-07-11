package ru.sutochno.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Открываем главную страницу и проверяем приветственную фразу")
    public MainPage openPage() {
        open("/");
        $(".main-block-note").shouldHave(Condition.text("100 тысяч вариантов для поездок по России и зарубежью"));
        return this;
    }

    @Step("Открываем главную страницу для разных браузеров и проверяем приветственную фразу")
    public MainPage openPageInAnotherBrowsers(String text) {
        open("/");
        $(".main-block-note").shouldHave(Condition.text(text));
        return this;
    }

    @Step("Регистрация средствами пользователя")
    public MainPage registration(String newUserName, String newUserPhone) {
        $("[type='button']").$(withText("Войти")).click();
        $(".auth-header-container").$(byLinkText("Регистрация")).click();
        $(".auth-header-container").$("[placeholder='Введите имя']").setValue(newUserName);
        $(".auth-header-container").$("[placeholder='Введите номер телефона']").setValue(newUserPhone);
        $(".auth-header-container").$(".sc-checkbox--mark").click();
        $(".auth-header-container").$("[type='button']").$(withText("Зарегистрироваться")).click();

        //todo check
        return this;
    }


    @Step("Однократная авторизация средствами пользователя")
    public MainPage oneAuth(String userMail, String userPassword) {
        $("[type='button']").$(withText("Войти")).click();
        $(".auth-header-container").$("[placeholder='Введите e-mail или телефон']").setValue(userMail);
        $(".auth-header-container").$("[placeholder='Введите пароль']").setValue(userPassword);
        $(".auth-header-container").$("[type='button']").$(withText("Войти")).click();

        //todo check
        return this;
    }

}
