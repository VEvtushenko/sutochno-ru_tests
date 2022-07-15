package ru.sutochno.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class AddRentedSpaceInfo {

    private SelenideElement chooseItemTherdScreen(String itemName, int numberOfRow) {
        return $("[data='" + itemName + "']").$(".row").sibling(numberOfRow);
    }

    private SelenideElement chooseItemBathroom(int numberOfRow) {
        return $("[data='Bathroom']").$(".container").$(".row").sibling(numberOfRow);
    }

//    Screen 1

//todo
//    @Step("Выберите тип улицы")
//    public AddRentedSpaceInfo chooseStreetType(String streetType) {
//        $("[class='row object-creating-form__row object-creating-form__row-cell visible']")
//                .$("[class='col col-sm-12 col-md-5 col-lg-8']").click();
//        $("[class='row object-creating-form__row object-creating-form__row-cell visible']")
//                .$("[class='col col-sm-12 col-md-5 col-lg-8']").setValue(streetType);
//        return this;
//    }
//    class="sc-select object-creating-form__form-input form-control untouched pristine required"

    @Step("Введите название улицы")
    public AddRentedSpaceInfo chooseStreetName(String streetName) {
        $("[class='row object-creating-form__row object-creating-form__row-cell visible']").sibling(0)
                .$("[class='object-creating-form__form-input form-control untouched pristine required']")
                .setValue(streetName);
    return this;
    }

    @Step("Ввести номер дома")
    public AddRentedSpaceInfo houseNumber(String houseNumber) {
        $("[class='object-creating-form__mobile-row-wrap']")
                .$(".row").$(".object-creating-form__form-input").setValue(houseNumber);
        return this;
    }

    @Step("Ввести номер корпуса")
    public AddRentedSpaceInfo houseExNumber(String houseExNumber) {
        if (houseExNumber != null) {
            $("[class='object-creating-form__mobile-row-wrap']")
                    .$(".row").sibling(0).$(".object-creating-form__form-input").setValue(houseExNumber);
        }
        return this;
    }

    @Step("Нажать Продолжить")
    public AddRentedSpaceInfo toNextStep() {
        $(".object-creating__btn-wrap").$(byText("Продолжить")).click();
// todo       $(".object-creating__status-text").shouldHave(text("Шаг 1/3: об объекте №"));
        return this;
    }


//  Screen 3

    @Step("Ввести максимум гостей")
    public AddRentedSpaceInfo maxGuests(Integer maxGuests) {
        chooseItemTherdScreen("Guest",0).$(".sc-input-quantity__input").setValue(maxGuests.toString());
        return this;
    }

    @Step("Ввести количество  комнат")
    public AddRentedSpaceInfo numberOfRooms(Integer numberOfRooms) {
        chooseItemTherdScreen("Guest", 1).$(".sc-input-quantity__input").setValue(numberOfRooms.toString());
        return this;
    }

    @Step("Ввести количество спален")
    public AddRentedSpaceInfo numberOfBedrooms(Integer numberOfBedrooms) {
        chooseItemTherdScreen("Guest", 2).$(".sc-select").selectOption(numberOfBedrooms + 1);
        return this;
    }

    @Step("Ввести тип и количество кроватей")
    public AddRentedSpaceInfo numberOfBeds(Integer typeOfBed, Integer numberOfBed) {
        chooseItemTherdScreen("SleepPlaces", 1).$(".col-sm-6").$(".sc-select").selectOption(typeOfBed);
        chooseItemTherdScreen("SleepPlaces", 1).$(".col-sm-5").$(".sc-select").selectOption(numberOfBed);
        return this;
    }

    private Integer numberOfBedsTypes = 0;
    @Step("Добавить кровать")
    public AddRentedSpaceInfo addNewBed(Integer typeOfBed, Integer numberOfBed) {
        chooseItemTherdScreen("SleepPlaces", 1).$(".object-creating-form__link").click();
        chooseItemTherdScreen("SleepPlaces", 1).$(".object-creating-form__row").sibling(numberOfBedsTypes)
                .$(".col-sm-6").$(".sc-select").selectOption(typeOfBed);
        chooseItemTherdScreen("SleepPlaces", 1).$(".object-creating-form__row").sibling(numberOfBedsTypes)
                .$(".col-sm-5").$(".sc-select").selectOption(numberOfBed);
        numberOfBedsTypes = numberOfBedsTypes + 1;
        return this;
    }

    @Step("Ввести количество ванных комнат и туалетов и их параметры")
    public AddRentedSpaceInfo numberOfBathrooms(Integer bathroomsWithToilet, Integer bathroomsWithoutToilet, Integer toilets) {
        chooseItemBathroom(0).$(".sc-input-quantity__input").setValue(bathroomsWithToilet.toString());
        chooseItemBathroom(1).$(".sc-input-quantity__input").setValue(bathroomsWithoutToilet.toString());
        chooseItemBathroom(2).$(".sc-input-quantity__input").setValue(toilets.toString());
        return this;
    }

    @Step("Выбрать удобства в ванных")
    public AddRentedSpaceInfo conveniencesInBathroom(String convenience) {
        chooseItemBathroom(5).$(byText(convenience)).click();
        return this;
    }

    @Step("Ввести площадь квартиры")
    public AddRentedSpaceInfo squareOfFlat(Integer squareOfFlat) {
        chooseItemTherdScreen("MainInfo", 0).$(".object-creating-form__form-input")
                .setValue(squareOfFlat.toString());
        return this;
    }
    @Step("Ввести этаж квартиры и в мансарде ли она")
    public AddRentedSpaceInfo floorOfFlat(Integer floorOfFlat, boolean isAttic) {
        chooseItemTherdScreen("MainInfo", 1).$(".sc-select").selectOption(floorOfFlat + 1);
//        todo work selector attic
        if (isAttic & floorOfFlat > 1) {
            chooseItemTherdScreen("MainInfo", 2).$(".object-creating-form__attic")
                    .$(".sc-checkbox").click();
        }
        return this;
    }

    @Step("Ввести этажность дома и есть ли лифт")
    public AddRentedSpaceInfo numberOfFloors(Integer numberOfFloors, boolean isElevator) {
        chooseItemTherdScreen("MainInfo", 1).$(".inline-flex-w50__cell").sibling(0)
                .$(".object-creating-form__form-input").setValue(numberOfFloors.toString());
        if (isElevator & numberOfFloors > 2) {
            chooseItemTherdScreen("MainInfo", 2).$(".col-sm-12").sibling(0)
                    .$(".sc-checkbox").click();
        }
        return this;
    }


    @Step("Ввести тип кухни")
    public AddRentedSpaceInfo typeOfKitchen(Integer typeOfKitchen) {
        chooseItemTherdScreen("MainInfo", 3).$(".sc-select").selectOption(typeOfKitchen);
        return this;
    }
    @Step("Ввести тип ремонта")
    public AddRentedSpaceInfo typeOfRepairment(Integer typeOfRepairment) {
        chooseItemTherdScreen("MainInfo", 4).$(".sc-select").selectOption(typeOfRepairment);
        return this;
    }

//    Screen 4


}
