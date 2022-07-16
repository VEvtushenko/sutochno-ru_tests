package ru.sutochno.tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.helpers.DriverSettings;

public class TestBase {

    Requests requests = new Requests();
//
//    @BeforeAll
//    static void setUp() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        DriverSettings.configure();
//        Configuration.holdBrowserOpen = true;
//    }
}
