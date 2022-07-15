package ru.sutochno.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AddRentedSpaceInfo {

    private SelenideElement chooseItemTherdScreen(String itemName, int numberOfRow) {
        return $("[data='" + itemName + "']").$(".row").sibling(numberOfRow);
    }

    private SelenideElement chooseItemForthScreen(int numberOfItem) {
        return $("[data='Facilities']").$(".object-creating-form")
                .sibling(numberOfItem).$(".row").sibling(0);
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



    @Step("Ввести удобства")
    public AddRentedSpaceInfo homeFacilities(String facility) {
        chooseItemTherdScreen("Facilities", 0).$(byText(facility)).click();
        return this;
    }

    @Step("Ввести вид из окон")
    public AddRentedSpaceInfo chooseView(String view) {
        chooseItemForthScreen(0).$(byText(view)).click();
        return this;
    }

    public AddRentedSpaceInfo equipments(String stepName, int numberOfItem, String equipments) {
        step("Оснащение для " + stepName, () -> {
                step("Нажать развернуть список", () -> {
                    chooseItemForthScreen(numberOfItem).$(".toggle-block__btn").click();
                    chooseItemForthScreen(numberOfItem).$(byText(equipments)).shouldBe(visible);
                });
                step("Выбрать оснащение", () ->
                    chooseItemForthScreen(numberOfItem).$("[class='row list']")
                            .$(byText(equipments)).click()
                );
                step("Нажать свернуть список", () -> {
                    chooseItemForthScreen(numberOfItem).$(".toggle-block__btn").click();
                    chooseItemForthScreen(numberOfItem).$(byText(equipments)).shouldBe(hidden);
                });
        });
        return this;
    }


//    @Step("Выбрать кухонное оборудование")
//    public AddRentedSpaceInfo kitchenFacilities(String kitchenFacilities) {
//        step("Нажать развернуть список", () -> {
//            chooseItemForthScreen(1).$(".toggle-block__btn").click();
//            chooseItemForthScreen(1).$(byText(kitchenFacilities)).shouldBe(visible);
//        });
//        step("Выбрать оборудование", () ->
//                chooseItemForthScreen(1).$("[class='row list']")
//                        .$(byText(kitchenFacilities)).click()
//        );
//        step("Нажать свернуть список", () -> {
//            chooseItemForthScreen(1).$(".toggle-block__btn").click();
//            chooseItemForthScreen(1).$(byText(kitchenFacilities)).shouldBe(hidden);
//        });
//        return this;
//    }
//
//    @Step("Выбрать оснащение")
//    public AddRentedSpaceInfo homeEquipment(String homeEquipment) {
//        step("Нажать развернуть список", () -> {
//            chooseItemForthScreen(2).$(".toggle-block__btn").click();
//            chooseItemForthScreen(2).$(byText(homeEquipment)).shouldBe(visible);
//        });
//        step("Выбрать оснащение", () ->
//                chooseItemForthScreen(2).$("[class='row list']")
//                        .$(byText(homeEquipment)).click()
//        );
//        step("Нажать свернуть список", () -> {
//            chooseItemForthScreen(2).$(".toggle-block__btn").click();
//            chooseItemForthScreen(2).$(byText(homeEquipment)).shouldBe(hidden);
//        });
//        return this;
//    }
//
//    @Step("Выбрать возможности для отдыха в помещении")
//    public AddRentedSpaceInfo indoorRest(String indoorRest) {
//        step("Нажать развернуть список", () -> {
//            chooseItemForthScreen(3).$(".toggle-block__btn").click();
//            chooseItemForthScreen(3).$(byText(indoorRest)).shouldBe(visible);
//        });
//        step("Выбрать оснащение", () ->
//                chooseItemForthScreen(3).$("[class='row list']")
//                        .$(byText(indoorRest)).click()
//        );
//        step("Нажать свернуть список", () -> {
//            chooseItemForthScreen(3).$(".toggle-block__btn").click();
//            chooseItemForthScreen(3).$(byText(indoorRest)).shouldBe(hidden);
//        });
//        return this;
//    }
//
//    @Step("Выбрать оснащение двора")
//    public AddRentedSpaceInfo yardEquipment(String yardEquipment) {
//        step("Нажать развернуть список", () -> {
//            chooseItemForthScreen(4).$(".toggle-block__btn").click();
//            chooseItemForthScreen(4).$(byText(yardEquipment)).shouldBe(visible);
//        });
//        step("Выбрать оснащение", () ->
//                chooseItemForthScreen(4).$("[class='row list']")
//                        .$(byText(yardEquipment)).click()
//        );
//        step("Нажать свернуть список", () -> {
//            chooseItemForthScreen(4).$(".toggle-block__btn").click();
//            chooseItemForthScreen(4).$(byText(yardEquipment)).shouldBe(hidden);
//        });
//        return this;
//    }
//
//    @Step("Для детей")
//    public AddRentedSpaceInfo forChildren(String forChildren) {
//        step("Нажать развернуть список", () -> {
//            chooseItemForthScreen(5).$(".toggle-block__btn").click();
//            chooseItemForthScreen(5).$(byText(forChildren)).shouldBe(visible);
//        });
//        step("Выбрать оснащение", () ->
//                chooseItemForthScreen(5).$("[class='row list']")
//                        .$(byText(forChildren)).click()
//        );
//        step("Нажать свернуть список", () -> {
//            chooseItemForthScreen(5).$(".toggle-block__btn").click();
//            chooseItemForthScreen(5).$(byText(forChildren)).shouldBe(hidden);
//        });
//        return this;
//    }

}
