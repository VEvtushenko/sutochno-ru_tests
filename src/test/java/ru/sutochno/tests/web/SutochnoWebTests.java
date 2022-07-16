package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewRentedSpace;
import ru.sutochno.pages.AddRentedSpaceInfo;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.sutochno.data.Data.authCookie;
import static ru.sutochno.data.Data.mainPage;

@Owner("Vladimir Evtushenko")
@DisplayName("Тест сайта ")
@Feature("DemoQA")
@Link(value = "Code of tests on GitHub ", url = "https://github.com/VEvtushenko/")

public class SutochnoWebTests extends TestBase {

    @Description("Open main page test")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void openMainPage() {
        mainPage.openPage();
    }

    @Test
    @Description("Проверка авторизации с помощью логина и пароля через интерфейс пользователя")
    @Severity(SeverityLevel.BLOCKER)
    void authUiTest() {
        mainPage.openPage();
        mainPage.oneAuth(Project.config.userPhone(),
                         Project.config.userPassword(),
                         Project.config.userName());
    }

    @MethodSource("currencyNameSource")
    @ParameterizedTest(name = "")
    void currencyChangeTest() {

    }

    @Test
    void searchTest() {

    }

    @Test
    @AllureId("2")
    @DisplayName("Создание объявления о сдаче квартиры/апартаментов/студии от зарегистрированного пользователя")
    @Owner("admin")
    void makeAdvertisementUiTest() {

        mainPage
                .authorization(new Cookie("_me_", authCookie), Project.config.userName())
                .openUsersAdvertisements()
                .createNewAdvertisement();

        AddNewRentedSpace addNewRentedSpace = new AddNewRentedSpace();

        step("Создаём новое объявление", () -> addNewRentedSpace
                .chooseFlat()
                .chooseTitle("Апартамент")
                .chooseCountry("Беларусь")
                .chooseRegion("Брестская область")
                .chooseCity("Брест")
                .toNextPage());

        AddRentedSpaceInfo addRentedSpaceInfo = new AddRentedSpaceInfo();

        step("Ввести адрес", () ->  addRentedSpaceInfo
                .chooseStreetType(0)
                .chooseStreetName("Ленина")
                .houseNumber("12")
                .houseExNumber("В")
                .toNextStep());

        step("Подтвердить карту", () -> {
            sleep(1500);
            addRentedSpaceInfo.toNextStep();});

        step("Ввести параметры жилья", () -> addRentedSpaceInfo
                .maxGuests(2)
                .numberOfRooms(3)
                .numberOfBedrooms(1)
                .maxGuests(3)
                .numberOfRooms(3)
                .numberOfBedrooms(2)
                .numberOfBeds(2, 1)
                .addNewBed(1, 1)
                .addNewBed(1, 1)
                .bathroomsWithToilet(1)
                .bathroomsWithoutToilet(0)
                .toilets(1)
                .conveniencesInBathroom("фен")
                .squareOfFlat(90)
                .floorOfFlat(3, true)
                .numberOfFloors(5, true)
                .typeOfKitchen(2)
                .typeOfRepairment(2)
                .toNextStep());

        step("Ввести удобства и оснащение", () -> addRentedSpaceInfo
                .homeFacilities("телевизор")
                .chooseView("на горы")
                .equipments("кухни", 1, "кофеварка")
                .equipments("дома", 2, "вентилятор")
                .equipments("отдыха дома", 3, "книги")
                .equipments("двора", 4, "гараж")
                .equipments("детей", 5, "детский горшок")
                .toNextStep());

        addRentedSpaceInfo
                .uploadFoto("src/test/resources/images/1.jpeg")
                .uploadFoto("src/test/resources/images/2.jpeg")
                .uploadFoto("src/test/resources/images/3.jpg")
                .toNextStep()
                .inputAdvertisementName("В Бресте на бульваре")
                .addUniqName("Квартира в Бресте")
                .inputAdvertisementDesc("Брест, квартира, бульвар Ленина")
                .toNextStep()
                .hostingRules(true, 1, true, false, true)
                .toNextStep()
                .checkInTime("12:00")
                .checkOutTime("16:00")
                .toNextStep()
                .howGuestBook(true)
                .toNextStep()
                .bookingGap(2)
                .bookingDuration(1)
                .toNextStep()
                .сalendarInfoAgreement()
                .toNextStep()
                .currencyPay(1)
                .minimalPeriodOfResidence(2)
                .costPerDay("3000", "2")
                .exGuestPrice("1000")
                .toNextStep()
//                .сhooseDiscountParam("при проживании от 2 дней", 300, "USD")
//                .addDiscount("10", "15", "relative")
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost("10")
                .depositAmount("10000")
                .isTransfer()
                .transferTerm("Transfer term")
                .toNextStep()
                .checkMainData("3000")
                .toNextStep()
                .finalPage();

        mainPage
                .openUsersAdvertisements()
                .moveToArchive();


        step("Проверить наличие объявления");
    }

    @Test
    @AllureId("5")
    @DisplayName("Проверка переноса объявления в архив, UI")
    @Owner("admin")
    void moveAdvertisementToArchive() {
        mainPage
                .authorization(new Cookie("_me_", authCookie), Project.config.userName())
                .openUsersAdvertisements()
                .moveToArchive();
    }
}
