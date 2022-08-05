package ru.sutochno.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;
import ru.sutochno.base.domain.adverticement.Beds;
import ru.sutochno.data.CheckData;
import ru.sutochno.data.Data;
import ru.sutochno.data.ModelsData;
import ru.sutochno.base.domain.adverticement.MainInfo;
import ru.sutochno.helpers.AllureAttachments;
import ru.sutochno.helpers.DriverSettings;
import ru.sutochno.helpers.DriverUtils;
import ru.sutochno.pages.MainPage;

import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;


@Tag("mainTests")
@ExtendWith({AllureJunit5.class})
public class TestBase {
    public Data data = new Data();
    CheckData checkData = new CheckData();
    MainPage mainPage = new MainPage();
    Requests requests = new Requests();
    ModelsData changeObjectData = new ModelsData();
    Random random = new Random();
    Faker faker = new Faker(new Locale("RU", "RUS"));
    Beds beds = new Beds(new Random());
    MainInfo mainInfo = new MainInfo(beds.getMaxGuests(), beds.getNumberOfBeds(), new Random());


    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
        Configuration.holdBrowserOpen = true;
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