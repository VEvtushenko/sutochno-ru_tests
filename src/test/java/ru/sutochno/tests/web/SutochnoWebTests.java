package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewAdvertisement;
import ru.sutochno.pages.AddAdvertisementInfo;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.sutochno.data.Data.*;

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

        AddNewAdvertisement addNewAdvertisement = new AddNewAdvertisement();

        step("Создаём новое объявление", () -> addNewAdvertisement
                .chooseFlat()
                .chooseTitle("Апартамент")
                .chooseCountry("Беларусь")
                .chooseRegion("Брестская область")
                .chooseCity("Брест")
                .toNextPage());

        AddAdvertisementInfo addAdvertisementInfo = new AddAdvertisementInfo();
        step("Ввести адрес", () ->  addAdvertisementInfo
                .chooseStreetType(streetType[1])
                .chooseStreetName(streetName)
                .houseNumber(houseNumber)
                .houseExNumber(houseExNumber)
                .toNextStep());

        step("Подтвердить карту", () -> {
            sleep(1500);
            addAdvertisementInfo.toNextStep();});

        step("Ввести параметры жилья", () -> addAdvertisementInfo
                .maxGuests(maxGuests)
                .numberOfRooms(numberOfRooms)
                .numberOfBedrooms(numberOfBedrooms)
                .numberOfBeds(2, 1)
                .addNewBed(1, 1)
                .addNewBed(1, 1)
                .bathroomsWithToilet(bathroomsWithToilet)
                .bathroomsWithoutToilet(bathroomsWithoutToilet)
                .toilets(toilets)
                .conveniencesInBathroom(conveniencesInBathroom[0])
                .squareOfFlat(squareOfFlat)
                .floorOfFlat(floorOfFlat, isAttic)
                .numberOfFloors(numberOfFloors, isElevator)
                .typeOfKitchen(2)
                .typeOfRepairment(2)
                .toNextStep());

        step("Ввести удобства и оснащение", () -> addAdvertisementInfo
                .homeFacilities("телевизор")
                .chooseView("на горы")
                .equipments("кухни", 1, "кофеварка")
                .equipments("дома", 2, "вентилятор")
                .equipments("отдыха дома", 3, "книги")
                .equipments("двора", 4, "гараж")
                .equipments("детей", 5, "детский горшок")
                .toNextStep());

        addAdvertisementInfo
                .uploadFoto(photo1)
                .uploadFoto(photo2)
                .uploadFoto(photo3)
                .toNextStep()
                .inputAdvertisementName(inputAdvertisementName)
                .addUniqName(addUniqName)
                .inputAdvertisementDesc(inputAdvertisementDesc)
                .toNextStep()
                .hostingRules(withChildren, 1, withPets, smoking, party)
                .toNextStep()
                .checkInTime(checkInTime[0])
                .checkOutTime(checkOutTime[0])
                .toNextStep()
                .howGuestBook(quickBooking)
                .toNextStep()
                .bookingGap(2)
                .bookingDuration(1)
                .toNextStep()
                .сalendarInfoAgreement()
                .toNextStep()
                .currencyPay(1)
                .minimalPeriodOfResidence(2)
                .costPerDay(costPerDay.toString(), amountOfGuestsForCost.toString())
                .exGuestPrice(exGuestPrice.toString())
                .toNextStep()
//                .сhooseDiscountParam("при проживании от 2 дней", 300, "USD")
//                .addDiscount("10", "15", "relative")
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost(cleaningCost.toString())
                .depositAmount(depositAmount.toString())
                .isTransfer()
                .transferTerm("Transfer term")
                .toNextStep()
                .checkMainData(checkMainData.toString())
                .toNextStep()
                .finalPage();

//        mainPage
//                .openUsersAdvertisements();

        mainPage
                .openUsersAdvertisements();
//                .moveToArchive();
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
