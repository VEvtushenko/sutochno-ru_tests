package ru.sutochno.pages.scenario;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import ru.sutochno.config.Project;
import ru.sutochno.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class General {
    @Step("Авторизация по API")
    public MainPage autorization(Cookie authCookie) {
        MainPage mainPage = new MainPage();
        step("Открываем сайт", () ->
                open("/front/searchapp/favicon.svg"));
        step("Передаём cookie для авторизации", () ->
                WebDriverRunner.getWebDriver().manage().addCookie(authCookie));
        step("Открываем главную страницу и проверяем авторизацию", () ->
                mainPage.openPageWithAuth(Project.config.userName()));
        return mainPage;
    }
}
