package ru.sutochno.tests.web;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.sutochno.config.Project;
import ru.sutochno.pages.AddNewRentedSpace;
import ru.sutochno.pages.AddRentedSpaceInfo;

import static com.codeborne.selenide.Selenide.open;
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
                .authorization(authCookie, Project.config.userName())
                .openUsersAdvertisements()
                .createNewAdvertisement();

        AddNewRentedSpace addNewRentedSpace = new AddNewRentedSpace();

        step("Создаём новое объявление", () -> addNewRentedSpace
                .chooseFlat()
                .chooseTitle("Апартамент")
                .chooseCountry("Беларусь")
                .chooseRegion("Брестская область")
                .chooseCity("Брест")
                .toNextPage()
        );

        AddRentedSpaceInfo addRentedSpaceInfo = new AddRentedSpaceInfo();

        step("Ввести адрес", () ->  addRentedSpaceInfo
                .chooseStreetType(0)
                .chooseStreetName("Ленина")
                .houseNumber("12")
                .houseExNumber("В")
                .toNextStep()
        );

        step("Подтвердить карту", () -> addRentedSpaceInfo.
                toNextStep()
        );

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
                .toNextStep()
        );

        step("Ввести удобства и оснащение", () -> addRentedSpaceInfo
                .homeFacilities("телевизор")
                .chooseView("на горы")
                .equipments("кухни", 1, "кофеварка")
                .equipments("дома", 2, "вентилятор")
                .equipments("отдыха дома", 3, "книги")
                .equipments("двора", 4, "гараж")
                .equipments("детей", 5, "детский горшок")
                .toNextStep()
        );

        addRentedSpaceInfo
                .uploadFoto("src/test/resources/images/1.jpeg")
                .uploadFoto("src/test/resources/images/2.jpeg")
                .uploadFoto("src/test/resources/images/3.jpg")
                .toNextStep()
                .inputAdvertisementName("В Бресте на бульваре")
                .addUniqName("Квартира в Бресте")
                .inputAdvertisementDesc("Брест, квартира, бульвар Ленина")
                .toNextStep();

        step("Ввести правила размещения", () -> {
            step("Нажать Продолжить");
        });
        step("Ввести время заезда и отъезда", () -> {
            step("Ввести время заезда");
            step("Ввести время отъезда");
            step("Нажать Продолжитть");
        });
        step("Ввести тип бронирования", () -> {
            step("Нажать Продолжить");
        });
        step("Ввести сроки бронирования", () -> {
            step("Нажать Продолжить");
        });
        step("Дать согласие вести календарь занятости", () -> {
            step("Нажать Продолжить");
        });
        step("Ввести цены бронирования", () -> {
            step("Нажать Продолжить");
        });
        step("Ввести скидки", () -> {
            step("Нажать Продолжить");
        });
        step("Ввести плату за уборку", () -> {
            step("Ввести страховой депозит");
            step("Ввести трансфер");
            step("Нажать Продолжить");
        });
        step("Проверить данные", () -> {
            step("Нажать Продолжить");
        });
        step("Проверить сообщение К сожалению такой страницы нет");
        step("Перейти в свой профиль");
        step("Перейти в свои объявления");
        step("Проверить наличие объявления");
        step("Отправить объявление в архив");
    }
}
