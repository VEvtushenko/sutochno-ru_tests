package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.api.models.AdvertisementChangeResponse;
import ru.sutochno.api.models.NewAdvertisement;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewAdvertisement;

import java.io.File;

import static io.qameta.allure.Allure.step;
import static ru.sutochno.data.Data.AUTH_COOKIE;

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
        mainPage
                .authorization(new Cookie("_me_", AUTH_COOKIE), Project.config.userName());
        NewAdvertisement newAdvertisement = requests.addAdvertisement(AUTH_COOKIE);
        String objectId = newAdvertisement.getData().getObject_id();
        AdvertisementChangeResponse advertisementChangeResponse =
                requests.setProperties(AUTH_COOKIE, changeObjectData.getChangeProperties(Integer.parseInt(objectId)));

        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo1));
        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo2));
        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo3));

//        requests.addDiscount("uqRMKVsX9cJNN7sGVuDgIAaxB0evDCXfgn3R3Qsjok1Q", "1234091", "10", "20", "relative", "5");
//        requests.setPrices(AUTH_COOKIE, "1234111", data.setStringPrices("100000", "5", "1000", "15000", "1050", "1", data.checkIn, data.checkOut));

    }

    @Test
    @Tag("newAdvertisement")
    @AllureId("2")
    @DisplayName("Создание объявления о сдаче квартиры/апартаментов/студии от зарегистрированного пользователя")
    @Owner("admin")
    void makeAdvertisementUiTest() {
        mainPage
                .authorization(new Cookie("_me_", AUTH_COOKIE), Project.config.userName())
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
                .chooseStreetType(data.streetType)
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
                .bathroomsWithToilet(data.cntBathroomsToilet)
                .bathroomsWithoutToilet(data.cntBathrooms)
                .toilets(data.cntToilets)
                .conveniencesInBathroom(data.bathroomEquipmentsSource[1])
                .squareOfFlat(data.squareOfFlat)
                .floorOfFlat(data.floor, data.isAttic)
                .numberOfFloors(data.maxFloor, data.isElevator)
                .typeOfKitchen(2)
                .typeOfRepairment(2)
                .toNextStep()
                .homeFacilities(data.homeFacilitiesSource[4])
                .chooseView(data.viewSource[1])
                .equipments("кухни", 1, data.kitchenEquipmentsSource[2])
                .equipments("дома", 2, data.houseEquipmentsSource[0])
                .equipments("отдыха дома", 3, data.restEquipmentsSource[2])
                .equipments("двора", 4, data.yardEquipmentsSource[3])
                .equipments("детей", 5, data.childrenEquipmentsSource[0])
                .toNextStep()
                .uploadFoto(data.photo1)
                .uploadFoto(data.photo2)
                .uploadFoto(data.photo3)
                .toNextStep()
                .inputAdvertisementName(data.nameObject)
                .addUniqName(data.selfNumberObject)
                .inputAdvertisementDesc(data.description)
                .toNextStep()
                .hostingRules(data.withChildren, data.childrenAgeArray[0], data.withPets, data.smokingBoolean, data.partyBoolean)
                .toNextStep()
                .checkInTime(data.checkTime[10])
                .checkOutTime(data.checkTime[12])
                .toNextStep()
                .howGuestBook(data.quickBooking)
                .toNextStep()
                .bookingGap(2)
                .bookingDuration(1)
                .toNextStep()
                .сalendarInfoAgreement()
                .toNextStep()
                .currencyPay(1)
                .minimalPeriodOfResidence(data.minNights[2])
                .costPerDay(data.costPerDay.toString(), data.amountOfGuestsForCost.toString())
                .exGuestPrice(data.exGuestPrice.toString())
                .toNextStep()
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost(data.cleaningCost.toString())
                .depositAmount(data.deposit.toString())
                .isTransfer()
                .transferTerm(data.transferTerm)
                .toNextStep()
                .checkMainData(data.checkMainData.toString())
                .toNextStep()
                .finalPage());

        mainPage
                .openUsersAdvertisements()
                .openLastAdvertisements()
                .checkTitle(data.nameObject)
                .checkTitleAddress(checkData.getAddress(data.streetName, data.streetType, data.houseNumber.toString(), data.houseExNumber))
                .checkMainInfo(data.typeOfSpace[0], data.squareOfFlat.toString(),
                        checkData.getParams(data.maxGuests.toString(), data.numberOfBedrooms.toString(), data.numberOfBeds.toString(), data.floor.toString(), data.maxFloor.toString(), true),
                        data.description)
                .checkIncomingRules(data.checkTime[10], data.checkTime[12], data.minNights[2].toString())
                .checkRules(checkData.getChildrenRules(data.withChildren, data.childrenAgeArray[0].toString()))
                .checkRules(checkData.getSmokingRules(data.smokingBoolean))
                .checkRules(checkData.getPetsRules(data.withPets))
                .checkRules(checkData.getPartyRules(data.partyBoolean))
//todo  30 000 ₽ from 30000 ₽               .checkDepositRules(data.depositAmount.toString())
                .checkEquipments(data.kitchenEquipmentsSource[2]);

                mainPage
                .openUsersAdvertisements().moveToArchive();
    }

    @Test
    @AllureId("5")
    @DisplayName("Проверка переноса объявления в архив, UI")
    @Owner("admin")
    void moveAdvertisementToArchive() {
        mainPage
                .authorization(new Cookie("_me_", AUTH_COOKIE), Project.config.userName())
                .openUsersAdvertisements()
                .moveToArchive();
    }
}
