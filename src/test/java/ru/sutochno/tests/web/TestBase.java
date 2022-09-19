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
import ru.sutochno.data.ModelsData;
import ru.sutochno.helpers.AllureAttachments;
import ru.sutochno.helpers.DriverSettings;
import ru.sutochno.helpers.DriverUtils;
import ru.sutochno.pages.MainPage;

import java.io.IOException;
import java.util.Locale;
import java.util.stream.Stream;


@Tag("mainTests")
@ExtendWith({AllureJunit5.class})
public class TestBase {
    public Data data = new Data();
    public CheckData checkData = new CheckData();
    public MainPage mainPage = new MainPage();
    public Requests requests = new Requests();
//    public ModelsData changeObjectData = new ModelsData();
    public Faker faker = new Faker(new Locale("RU", "RUS"));
    public GeneralInfo generalInfo = new GeneralInfo(faker, Type.APART);
    public Beds beds = new Beds(faker);
    public GuestsVolume guestsVolume = new GuestsVolume(faker, beds);
    public KitchenType kitchenType = KitchenType.SEPARATE;
    public RepairmentQuality repairmentQuality = RepairmentQuality.DISINER;
    public Sanitation sanitation = new Sanitation(faker);
    //todo - показать, что свойство "линолеум" в коде сайта "Линолеум" и естли оно тру как есть то не работает
    public Equipment equipment = new Equipment(faker, generalInfo);
    public Address address = new Address(faker);
    public Description description = new Description(faker);
    public Transfer transfer = new Transfer(faker);
    public View view = View.SEA;
    public BookingTerm bookingTerm = new BookingTerm(faker);
    public Price price = new Price(faker, Currencies.RUB);

    public TestBase() throws IOException {
    }


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