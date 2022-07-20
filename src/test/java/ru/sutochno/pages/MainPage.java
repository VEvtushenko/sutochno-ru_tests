package ru.sutochno.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    @Step("Открываем главную страницу и проверяем приветственную фразу")
    public MainPage openPage() {
        open("/");
        $(".about__title").shouldHave(text("Суточно.ру — сервис бронирования жилья для поездок"));
        return this;
    }

    @Step("Открываем главную страницу и проверяем авторизацию")
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

    @Step("Авторизация по API")
    public MainPage authorization(Cookie authCookie, String userName) {
        step("Открываем сайт", () -> open("/front/searchapp/favicon.svg"));
        step("Передаём cookie для авторизации", () -> {
            sleep(2000);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });
        openPageWithAuth(userName);
        return this;
    }

    @Step("Открываем личный кабинет пользователя и проверяем это")
    public UserPage openUserPage() {
        $("[aria-label='Личный кабинет']").click();
        $(".user-params-list").shouldHave(text("ID пользователя: 6809367"));
        return new UserPage();
    }

    @Step("Открываем список объявлений и проверяем это")
    public UsersAdvertisements openUsersAdvertisements() {
        $("[aria-label='Сдавайся']").click();
        $(".object-head__title-wrap").shouldHave(text("Создать новое объявление"));
        return new UsersAdvertisements();
    }

}
