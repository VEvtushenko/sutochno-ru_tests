package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.base.domain.adverticement.equipment.*;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewAdvertisement;

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
    void newAdverticementApi() throws InterruptedException {
//        NewAdvertisement newAdvertisement = requests.addAdvertisement(AUTH_COOKIE);
//        String objectId = newAdvertisement.getData().getObject_id();
//        AdvertisementChangeResponse advertisementChangeResponse =
//                requests.setProperties(AUTH_COOKIE, changeObjectData.getChangeProperties(Integer.parseInt(objectId)));
//
//        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo1));
//        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo2));
//        requests.uploadPhotos(AUTH_COOKIE, objectId, new File(data.photo3));
//
//        requests.setPrices(AUTH_COOKIE, objectId, data.prices);
//
//        requests.setAddress(AUTH_COOKIE, "1235961", data.streetType, data.streetName, data.houseNumber.toString(), data.houseExNumber, "55.95685305638317", "36.97412763887026");

//        mainPage
//                .authorization(new Cookie("_me_", AUTH_COOKIE), Project.config.userName());

    }

    @Test
    @Tag("newAdvertisement")
    @DisplayName("Создание объявления о сдаче квартиры/апартаментов/студии от зарегистрированного пользователя")
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
                .maxGuests(mainInfo.getMaxGuests())
                .numberOfRooms(mainInfo.getNumberOfRooms())
                .numberOfBedrooms(mainInfo.getNumberOfBedrooms())
//todo                .numberOfBeds(2, 1)
//                .addNewBed(1, 1)
//                .addNewBed(1, 1)
                .bathroomsWithToilet(data.cntBathroomsToilet)
                .bathroomsWithoutToilet(data.cntBathrooms)
                .toilets(data.cntToilets)
                .conveniencesInBathroom(BathroomEquipment.BATHROBE.getName())
                .squareOfFlat(data.squareOfFlat)
                .floorOfFlat(mainInfo.getFloorOfFlat(), mainInfo.isAttic())
                .numberOfFloors(mainInfo.getNumberOfFloors(), mainInfo.isElevator())
                .typeOfKitchen(2)
                .typeOfRepairment(2)
                .toNextStep()
                .homeFacilities(data.homeFacilitiesSource[2])
                .chooseView(data.viewSource[1])
                .equipments("кухни", 1, KitchenEquipment.KITCHEN.getName())
                .equipments("дома", 2, HouseEquipment.FAN.getName())
                .equipments("отдыха дома", 3, RestEquipment.BOOKS.getName())
                .equipments("двора", 4, YardEquipment.BARBECUE.getName())
                .equipments("детей", 5, ChildrenEquipment.BABY_POTTY.getName())
                .toNextStep()
                .uploadFoto(data.photo1)
                .uploadFoto(data.photo2)
                .uploadFoto(data.photo3)
                .toNextStep()
                .inputAdvertisementName(data.nameObject)
                .addUniqName(data.selfNumberObject)
                .inputAdvertisementDesc(data.description)
                .toNextStep()
                .placementTerms(data.withChildren, data.childrenAgeArray[0], data.withPets, data.smokingBoolean, data.partyBoolean)
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
//                .costPerDay(data.costPerDay.toString(), data.amountOfGuestsForCost.toString())
                .exGuestPrice(data.exGuestPrice.toString())
                .toNextStep()
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost(data.gethering.toString())
                .depositAmount(data.deposit.toString())
                .isTransfer()
                .transferTerm(data.transferTerm)
                .toNextStep()
                .checkMainData(data.costPerDay.toString())
                .toNextStep()
                .finalPage());

//        String mainParams = checkData.getParams(data.maxGuests.toString(), data.numberOfBedrooms.toString(), data.numberOfBeds.toString(), data.floor.toString(), data.maxFloor.toString(), true);

        mainPage
                .openUsersAdvertisements()
                .openLastAdvertisements()
                .checkTitle(data.nameObject)
//                .checkTitleAddress(checkData.getAddress(data.streetName, data.streetType, data.houseNumber.toString(), data.houseExNumber))
//                .checkMainInfo(data.typeOfSpace[0], data.squareOfFlat.toString(), mainParams, data.description)
                .checkIncomingRules(data.checkTime[10], data.checkTime[12], data.minNights[2].toString())
                .checkRules(checkData.getChildrenRules(data.withChildren, data.childrenAgeArray[0].toString()))
                .checkRules(checkData.getSmokingRules(data.smokingBoolean))
                .checkRules(checkData.getPetsRules(data.withPets))
                .checkRules(checkData.getPartyRules(data.partyBoolean))
//                .checkDepositRules(checkData.addDigitSpace(data.deposit))
                .checkEquipments(KitchenEquipment.KITCHEN.getName());

                mainPage
                .openUsersAdvertisements().moveToArchive();
    }

    @Test
    @DisplayName("Проверка переноса объявления в архив, UI")
    void moveAdvertisementToArchive() {
        mainPage
                .authorization(new Cookie("_me_", AUTH_COOKIE), Project.config.userName())
                .openUsersAdvertisements()
                .moveToArchive();
    }
}
