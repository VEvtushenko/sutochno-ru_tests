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
import ru.sutochno.base.domain.adverticement.Description;
import ru.sutochno.base.domain.adverticement.Transfer;
import ru.sutochno.base.domain.adverticement.View;
import ru.sutochno.base.domain.adverticement.address.Address;
import ru.sutochno.base.domain.adverticement.equipment.Equipment;
import ru.sutochno.base.domain.adverticement.general.*;
import ru.sutochno.base.domain.booking.BookingTerm;
import ru.sutochno.base.domain.prices.Currencies;
import ru.sutochno.base.domain.prices.Price;
import ru.sutochno.config.Project;
import ru.sutochno.data.CheckData;
import ru.sutochno.data.Data;
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
//    Requests requests = new Requests();
//    ModelsData changeObjectData = new ModelsData();
    Random random = new Random();
    Faker faker = new Faker(new Locale("RU", "RUS"));
    GeneralInfo generalInfo = new GeneralInfo(faker, Type.APART);
    Beds beds = new Beds(new Random());
    GuestsVolume guestsVolume = new GuestsVolume(faker, beds.getMaxGuests());
    KitchenType kitchenType = KitchenType.SEPARATE;
    RepairmentQuality repairmentQuality = RepairmentQuality.DISINER;
    Sanitation sanitation = new Sanitation(random);
    Equipment equipment = new Equipment(random);
    Address address = new Address(faker);
    Description description = new Description(faker);
    Transfer transfer = new Transfer(random, faker);
    View view = View.SEA;
    BookingTerm bookingTerm = new BookingTerm(random);
    Price price = new Price("30000", Currencies.RUB, "300", "30000");


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