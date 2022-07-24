package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewAdvertisement;

import static io.qameta.allure.Allure.step;
import static ru.sutochno.data.Data.authCookie;

@Owner("Vladimir Evtushenko")
@DisplayName("Тест сайта ")
@Feature("DemoQA")
@Link(value = "Code of tests on GitHub ", url = "https://github.com/VEvtushenko/")

public class SutochnoWebTests extends TestBase {

    @Tag("openMain")
    @Description("Open main page test")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void openMainPage() {
        mainPage.openPage()
                .judgmentTextCheck(data.judgmentText);
    }

    @Tag("authUI")
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
    @Tag("newAdvertisement")
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
                .chooseTitle(data.typeOfSpace[0])
                .chooseCountry(data.country[0])
                .chooseRegion(data.region[0])
                .chooseCity(data.city[0])
                .toNextPage()
                .chooseStreetType(data.streetType[1])
                .chooseStreetName(data.streetName)
                .houseNumber(data.houseNumber)
                .houseExNumber(data.houseExNumber)
                .toNextStep()
                .map()
                .toNextStep()
                .maxGuests(data.maxGuests)
                .numberOfRooms(data.numberOfRooms)
                .numberOfBedrooms(data.numberOfBedrooms)
                .numberOfBeds(2, 1)
                .addNewBed(1, 1)
                .addNewBed(1, 1)
                .bathroomsWithToilet(data.bathroomsWithToilet)
                .bathroomsWithoutToilet(data.bathroomsWithoutToilet)
                .toilets(data.toilets)
                .conveniencesInBathroom(data.conveniencesInBathroom[1])
                .squareOfFlat(data.squareOfFlat)
                .floorOfFlat(data.floorOfFlat, data.isAttic)
                .numberOfFloors(data.numberOfFloors, data.isElevator)
                .typeOfKitchen(2)
                .typeOfRepairment(2)
                .toNextStep()
                .homeFacilities(data.homeFacilities[4])
                .chooseView(data.chooseView[1])
                .equipments("кухни", 1, data.kitchenEquipments[2])
                .equipments("дома", 2, data.houseEquipments[0])
                .equipments("отдыха дома", 3, data.restEquipments[2])
                .equipments("двора", 4, data.yardEquipments[3])
                .equipments("детей", 5, data.childrenEquipments[0])
                .toNextStep()
                .uploadFoto(data.photo1)
                .uploadFoto(data.photo2)
                .uploadFoto(data.photo3)
                .toNextStep()
                .inputAdvertisementName(data.advertisementName)
                .addUniqName(data.advertisementUniqName)
                .inputAdvertisementDesc(data.advertisementDesc)
                .toNextStep()
                .hostingRules(data.withChildren, data.childrenAge[0], data.withPets, data.smoking, data.party)
                .toNextStep()
                .checkInTime(data.checkInTime[0])
                .checkOutTime(data.checkOutTime[0])
                .toNextStep()
                .howGuestBook(data.quickBooking)
                .toNextStep()
                .bookingGap(2)
                .bookingDuration(1)
                .toNextStep()
                .сalendarInfoAgreement()
                .toNextStep()
                .currencyPay(1)
                .minimalPeriodOfResidence(data.minimalPeriodOfResidence[2])
                .costPerDay(data.costPerDay.toString(), data.amountOfGuestsForCost.toString())
                .exGuestPrice(data.exGuestPrice.toString())
                .toNextStep()
//                .chooseDiscountParam("при проживании от 2 дней", 300, "USD")
//                .addDiscount("10", 15, "проценты")
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost(data.cleaningCost.toString())
                .depositAmount(data.depositAmount.toString())
                .isTransfer()
                .transferTerm(data.transferTerm)
                .toNextStep()
                .checkMainData(data.checkMainData.toString())
                .toNextStep()
                .finalPage());

        mainPage
                .openUsersAdvertisements()
                .openLastAdvertisements()
                .checkTitle(data.advertisementName)
                .checkTitleAddress(checkData.getAddress(data.streetName, data.streetType[1], data.houseNumber, data.houseExNumber))
                .checkMainInfo(data.typeOfSpace[0], data.squareOfFlat.toString(),
                        checkData.getParams(data.maxGuests.toString(), data.numberOfBedrooms.toString(), data.numberOfBeds.toString(), data.floorOfFlat.toString(), data.numberOfFloors.toString(), true),
                        data.advertisementDesc)
                .checkIncomingRules(data.checkInTime[0], data.checkOutTime[0], data.minimalPeriodOfResidence[2].toString())
                .checkRules(checkData.getChildrenRules(data.withChildren, data.childrenAge[0].toString()))
                .checkRules(checkData.getSmokingRules(data.smoking))
                .checkRules(checkData.getPetsRules(data.withPets))
                .checkRules(checkData.getPartyRules(data.party))
//todo  30 000 ₽ from 30000 ₽               .checkDepositRules(data.depositAmount.toString())
                .checkEquipments(data.kitchenEquipments[2]);

                mainPage
                .openUsersAdvertisements().moveToArchive();
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
