package ru.sutochno.tests.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SutochnoWebTests extends TestBase {

    @Test
    void openMainPage() {
        open("/");
        $("[class='main-block-title tmp-font--large']").shouldHave(Condition.text("Главная страница поиска жилья для отдыха")); // todo ветвление проверочной фразы для браузеров
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void authTest() {
    }

    @MethodSource("currencyNameSource")
    @ParameterizedTest(name = "")
    void currencyChangeTest() {

    }

    @Test
    void searchTest() {

    }

    @Test
    void promoTenYearSectionTest() {

    }

    @Test
    void makeAdvertisementUiTest() {

    }
}
