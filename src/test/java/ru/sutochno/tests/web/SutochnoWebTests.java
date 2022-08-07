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
                .chooseTitle(generalInfo.getType().getName())
                .chooseCountry("Беларусь")
                .chooseRegion("Брестская область")
                .chooseCity("Брест")
                .toNextPage()
                .chooseStreetType(address.getStreetType())
                .chooseStreetName(address.getStreetName())
                .houseNumber(address.getHouseNumber())
                .houseExNumber(address.getHouseExNumber())
                .toNextStep()
                .map()
                .toNextStep()
                .maxGuests(guestsVolume.getMaxGuests()))
                .numberOfRooms(guestsVolume.getNumberOfRooms())
                .numberOfBedrooms(guestsVolume.getNumberOfBedrooms())
                .numberOfBeds("Односпальных кроватей", beds.getSingleBed())
                .addNewBed("Двуспальных кроватей", beds.getDoubleBed())
                .addNewBed("Кроватей king-size", beds.getKingBed())
                .addNewBed("Особо широких двуспальных", beds.getSuperKingBed())
                .addNewBed("Двухъярусных кроватей", beds.getYarusBed())
                .addNewBed("Диван-кроватей", beds.getSofaBed())
                .bathroomsWithToilet(sanitation.getCntBathroomsToilet())
                .bathroomsWithoutToilet(sanitation.getCntBathrooms())
                .toilets(sanitation.getCntToilets())
                .conveniencesInBathroom(BathroomEquipment.BATHROBE.getName())
                .squareOfFlat(generalInfo.getSquare())
                .floorOfFlat(generalInfo.getFloorOfFlat(), generalInfo.isAttic())
                .numberOfFloors(generalInfo.getNumberOfFloors(), generalInfo.isElevator())
                .typeOfKitchen(kitchenType.getValue())
                .typeOfRepairment(repairmentQuality.getValue())
                .toNextStep()
                .homeFacilities(HomeFacilities.ISOLATION.getName())
                .chooseView(view.getName())
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
                .inputAdvertisementName(description.getPublicName())
                .addUniqName(description.getPrivateName())
                .inputAdvertisementDesc(description.getDescription())
                .toNextStep()
                .placementTerms(bookingTerm.getPlacementTerm().getChildren().isSwitchValue(),
                                bookingTerm.getPlacementTerm().getChildrenAge(),
                                bookingTerm.getPlacementTerm().getPets().isSwitchValue(),
                                bookingTerm.getPlacementTerm().getSmoking().isSwitchValue(),
                                bookingTerm.getPlacementTerm().getParty().isSwitchValue())
                .toNextStep()
                .checkInTime(bookingTerm.getCheckIn())
                .checkOutTime(bookingTerm.getCheckOut())
                .toNextStep()
                .howGuestBook(true)
                .toNextStep()
                .bookingGap(2)
                .bookingDuration(1)
                .toNextStep()
                .сalendarInfoAgreement()
                .toNextStep()
                .currencyPay(price.getCurrency().getName())
                .minimalPeriodOfResidence(2)
                .costPerDay(price.getPrice(), "1")
                .exGuestPrice(data.exGuestPrice.toString())
                .toNextStep()
                .rmDiscount()
                .toNextStep()
                .additionalServices(0)
                .cleaningCost(price.getGethering())
                .depositAmount(price.getDeposit())
                .isTransfer()
                .transferTerm(transfer.getTransferTerm())
                .toNextStep()
                .checkMainData(price.getPrice(), price.getCurrency().getSymbol())
                .toNextStep()
                .finalPage();

        String mainParams = guestsVolume.guestsVolumeDesc() + beds.bedsNumDesc() + guestsVolume.bedroomsDesc() + generalInfo.descFloors();

        mainPage
                .openUsersAdvertisements()
                .openLastAdvertisements()
                .checkTitle(description.getPublicName())
                .checkTitleAddress(address.getAddress())
                .checkMainInfo(generalInfo.getType().getName(), generalInfo.getSquare().toString(), mainParams, description.getDescription())
                .checkIncomingRules(bookingTerm.getCheckIn(), bookingTerm.getCheckOut(), "2")
                .checkRules(checkData.getChildrenRules(bookingTerm.getPlacementTerm().getChildren().isSwitchValue(), bookingTerm.getPlacementTerm().getChildrenAge().toString()))
                .checkRules(checkData.getSmokingRules(bookingTerm.getPlacementTerm().getSmoking().isSwitchValue()))
                .checkRules(checkData.getPetsRules(bookingTerm.getPlacementTerm().getPets().isSwitchValue()))
                .checkRules(checkData.getPartyRules(bookingTerm.getPlacementTerm().getParty().isSwitchValue()))
//                .checkDepositRules(price.getDeposit().)
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
