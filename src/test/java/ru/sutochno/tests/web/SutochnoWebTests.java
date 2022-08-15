package ru.sutochno.tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Cookie;
import ru.sutochno.api.models.AdvertisementChangeResponse;
import ru.sutochno.api.models.NewAdvertisement;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.base.domain.adverticement.equipment.*;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewAdvertisement;

import java.io.File;
import java.io.IOException;

import static io.qameta.allure.Allure.step;

@Owner("Vladimir Evtushenko")
@DisplayName("Тест сайта ")
@Feature("DemoQA")
@Link(value = "Code of tests on GitHub ", url = "https://github.com/VEvtushenko/")

public class SutochnoWebTests extends TestBase {

    public SutochnoWebTests() throws IOException {
    }

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
    void newAdverticementApi() throws InterruptedException, IOException {
        NewAdvertisement newAdvertisement = requests.addAdvertisement(data.AUTH_COOKIE);
        String objectId = newAdvertisement.getData().getObject_id();
        AdvertisementChangeResponse advertisementChangeResponse =
                requests.setProperties(data.AUTH_COOKIE, new TestData().getChangeProperties(Integer.parseInt(objectId)));

        requests.uploadPhotos(data.AUTH_COOKIE, objectId, new File(data.photo1));
        requests.uploadPhotos(data.AUTH_COOKIE, objectId, new File(data.photo2));
        requests.uploadPhotos(data.AUTH_COOKIE, objectId, new File(data.photo3));

        requests.setPrices(data.AUTH_COOKIE, objectId, price.getPrice().toString());

//        requests.setAddress(data.AUTH_COOKIE, "1235961", address.getStreetType(), address.getStreetName(), data.houseNumber.toString(), data.houseExNumber, "55.95685305638317", "36.97412763887026");

        mainPage
                .authorization(new Cookie("_me_", data.AUTH_COOKIE), Project.config.userName());

    }

    @Test
    @Tag("newAdvertisement")
    @DisplayName("Создание объявления о сдаче квартиры/апартаментов/студии от зарегистрированного пользователя")
    void makeAdvertisementUiTest() {
        mainPage
                .authorization(new Cookie("_me_", data.AUTH_COOKIE), Project.config.userName())
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
                .beds(beds.getBedsList())
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
                .equipments("Кухонное оборудование", equipment.getKitchenEquipment())
                .equipments("Оснащение", equipment.getHouseEquipment())
                .equipments("Для отдыха в помещении", equipment.getRestEquipment())
                .equipments("Оснащение двора", equipment.getYardEquipment())
                .equipments("Для детей", equipment.getChildrenEquipment())
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
                .calendarInfoAgreement()
                .toNextStep()
                .currencyPay(price.getCurrency().getName())
                .minimalPeriodOfResidence(2)
                .costPerDay(price.getPrice(), 1)
                .exGuestPrice(price.getExGuestPrice().toString())
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


        mainPage
                .openUsersAdvertisements()
                .openLastAdvertisements()
                .checkTitle(description.getPublicName())
                .checkTitleAddress(address.getAddress())
                .checkMainInfo(generalInfo, guestsVolume, description)
                .checkIncomingRules(bookingTerm.getCheckIn(), bookingTerm.getCheckOut(), "2")
                .checkRules(checkData.getChildrenRules(bookingTerm.getPlacementTerm().getChildren().isSwitchValue(), bookingTerm.getPlacementTerm().getChildrenAge().toString()))
                .checkRules(checkData.getSmokingRules(bookingTerm.getPlacementTerm().getSmoking().isSwitchValue()))
                .checkRules(checkData.getPetsRules(bookingTerm.getPlacementTerm().getPets().isSwitchValue()))
                .checkRules(checkData.getPartyRules(bookingTerm.getPlacementTerm().getParty().isSwitchValue()))
                .checkDepositRules(price.getDeposit())
                .checkEquipments(KitchenEquipment.KITCHEN.getName());

                mainPage
                .openUsersAdvertisements().moveToArchive();
    }

    @Test
    @DisplayName("Проверка переноса объявления в архив, UI")
    void moveAdvertisementToArchive() {
        mainPage
                .authorization(new Cookie("_me_", data.AUTH_COOKIE), Project.config.userName())
                .openUsersAdvertisements()
                .moveToArchive();
    }
}
