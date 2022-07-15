package ru.sutochno.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class AddRentedSpaceInfo {

    private SelenideElement chooseItem(String itemName, int numberOfRow) {
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

    @Step("Выберите тип улицы")
    public AddRentedSpaceInfo chooseStreetType(Integer streetType) {
        chooseItem("Address", 0).$(".sc-select").selectOption(streetType);
        return this;
    }

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
        sleep(1500);
        $(".object-creating__btn-wrap").$(byText("Продолжить")).click();
// todo       $(".object-creating__status-text").shouldHave(text("Шаг 1/3: об объекте №"));
        return this;
    }


//  Screen 3

    @Step("Ввести максимум гостей")
    public AddRentedSpaceInfo maxGuests(Integer maxGuests) {
        chooseItem("Guest",0).$(".sc-input-quantity__input")
                .setValue(maxGuests.toString());
        return this;
    }

    @Step("Ввести количество  комнат")
    public AddRentedSpaceInfo numberOfRooms(Integer numberOfRooms) {
        chooseItem("Guest", 1).$(".sc-input-quantity__input")
                .setValue(numberOfRooms.toString());
        return this;
    }

    @Step("Ввести количество спален")
    public AddRentedSpaceInfo numberOfBedrooms(Integer numberOfBedrooms) {
        chooseItem("Guest", 2).$(".sc-select")
                .selectOption(numberOfBedrooms + 1);
        return this;
    }

    @Step("Ввести тип и количество кроватей")
    public AddRentedSpaceInfo numberOfBeds(Integer typeOfBed, Integer numberOfBed) {
        chooseItem("SleepPlaces", 1).$(".col-sm-6").$(".sc-select")
                .selectOption(typeOfBed);
        chooseItem("SleepPlaces", 1).$(".col-sm-5").$(".sc-select")
                .selectOption(numberOfBed);
        return this;
    }

    private Integer numberOfBedsTypes = 0;
    @Step("Добавить кровать")
    public AddRentedSpaceInfo addNewBed(Integer typeOfBed, Integer numberOfBed) {
        chooseItem("SleepPlaces", 1).$(".object-creating-form__link").click();
        chooseItem("SleepPlaces", 1).$(".object-creating-form__row")
                .sibling(numberOfBedsTypes).$(".col-sm-6").$(".sc-select").selectOption(typeOfBed);
        chooseItem("SleepPlaces", 1).$(".object-creating-form__row")
                .sibling(numberOfBedsTypes).$(".col-sm-5").$(".sc-select").selectOption(numberOfBed);
        numberOfBedsTypes = numberOfBedsTypes + 1;
        return this;
    }

    @Step("Ввести количество совмещённых санузлов")
    public AddRentedSpaceInfo bathroomsWithToilet(Integer bathroomsWithToilet) {
        chooseItemBathroom(0).$(".sc-input-quantity__input").setValue(bathroomsWithToilet.toString());
        return this;
    }

    @Step("Ввести количество ванных комнат")
    public AddRentedSpaceInfo bathroomsWithoutToilet(Integer bathroomsWithoutToilet) {
        chooseItemBathroom(1).$(".sc-input-quantity__input").setValue(bathroomsWithoutToilet.toString());
        return this;
    }

    @Step("Ввести количество туалетов")
    public AddRentedSpaceInfo toilets(Integer toilets) {
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
        chooseItem("MainInfo", 0).$(".object-creating-form__form-input")
                .setValue(squareOfFlat.toString());
        return this;
    }
    @Step("Ввести этаж квартиры и в мансарде ли она")
    public AddRentedSpaceInfo floorOfFlat(Integer floorOfFlat, boolean isAttic) {
        chooseItem("MainInfo", 1).$(".sc-select").selectOption(floorOfFlat + 1);
//        todo work selector attic
        if (isAttic & floorOfFlat > 1) {
            chooseItem("MainInfo", 2).$(".object-creating-form__attic")
                    .$(".sc-checkbox").click();
        }
        return this;
    }

    @Step("Ввести этажность дома и есть ли лифт")
    public AddRentedSpaceInfo numberOfFloors(Integer numberOfFloors, boolean isElevator) {
        chooseItem("MainInfo", 1).$(".inline-flex-w50__cell").sibling(0)
                .$(".object-creating-form__form-input").setValue(numberOfFloors.toString());
        if (isElevator & numberOfFloors > 2) {
            chooseItem("MainInfo", 2).$(".col-sm-12").sibling(0)
                    .$(".sc-checkbox").click();
        }
        return this;
    }


    @Step("Ввести тип кухни")
    public AddRentedSpaceInfo typeOfKitchen(Integer typeOfKitchen) {
        chooseItem("MainInfo", 3).$(".sc-select").selectOption(typeOfKitchen);
        return this;
    }
    @Step("Ввести тип ремонта")
    public AddRentedSpaceInfo typeOfRepairment(Integer typeOfRepairment) {
        chooseItem("MainInfo", 4).$(".sc-select").selectOption(typeOfRepairment);
        return this;
    }

//    Screen 4

    @Step("Ввести удобства")
    public AddRentedSpaceInfo homeFacilities(String facility) {
        chooseItem("Facilities", 0).$(byText(facility)).click();
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

//    Screen 5

    @Step("Загружаем фото")
    public AddRentedSpaceInfo uploadFoto(String pathToImage) {
        $(".load-image").$(".load-image__select-files").$("[type='file']").uploadFile(new File(pathToImage));
        return this;
    }

//    Screen 6
    @Step("Ввести имя объекта")
    public AddRentedSpaceInfo inputAdvertisementName(String name) {
        $("[data='NameObject']").$(".name__item").$(".sc-input--elem").setValue(name);
        return this;
    }

    @Step("Добавить уникальное имя, которое видит только хозяин объявления")
    public AddRentedSpaceInfo addUniqName(String name) {
        $("[data='NameObject']").$(".name__adduniq").$(".adduniq__button").click();
        $("[data='NameObject']").$(".name__item").sibling(0).$(".sc-input--elem").setValue(name);
        return this;
    }

    @Step("Ввести описание объекта")
        public AddRentedSpaceInfo inputAdvertisementDesc(String description) {
            $("[data='DescriptionObject']").$(".sc-textarea").setValue(description);
            return this;
        }
}
