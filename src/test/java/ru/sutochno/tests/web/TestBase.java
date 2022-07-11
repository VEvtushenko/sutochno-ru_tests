package ru.sutochno.tests.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import ru.sutochno.config.Project;
import ru.sutochno.helpers.AllureAttachments;
import ru.sutochno.helpers.DriverSettings;
import ru.sutochno.helpers.DriverUtils;
import ru.sutochno.pages.MainPage;

import java.util.stream.Stream;


@Tag("mainTests")
@ExtendWith({AllureJunit5.class})
public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterAll
    static void addAttachments() {
        String sessionId = DriverUtils.getSessionId();
        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();
        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
        Selenide.closeWebDriver();
    }

    static Stream<Arguments> currencyNameSource() {
        return Stream.of(
                Arguments.of( )
        );
    }

}