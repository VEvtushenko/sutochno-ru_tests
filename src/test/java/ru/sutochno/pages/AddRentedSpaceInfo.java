package ru.sutochno.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddRentedSpaceInfo {

    private SelenideElement chooseItem(String itemName, int numberOfRow) {
        return $("[data='" + itemName + "']").$(".row").sibling(numberOfRow);
    }

    private SelenideElement chooseItemForthScreen(int numberOfItem) {
        return $("[data='Facilities']").$(".object-creating-form")
                .sibling(numberOfItem).$(".row").sibling(0);
    }

    private SelenideElement chooseItemPrice(int numberOfItem) {
        return $("[data='BasePriceSettings']").$(".row").sibling(0)
                .$(".row").sibling(numberOfItem);
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
        sleep(200);
        $(".object-creating__btn-wrap").$(byText("Продолжить")).click();
// todo       $(".object-creating__status-text").shouldHave(text("Шаг 1/3: об объекте №"));
        return this;
    }


//  Screen 3

    @Step("Ввести максимум гостей")
    public AddRentedSpaceInfo maxGuests(Integer maxGuests) {
        chooseItem("Guest", 0).$(".sc-input-quantity__input")
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
                            .$(byText(equipments)).click());
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
        sleep(2000);
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

//        Screen 7

    @Step("Правила размещения")
    public AddRentedSpaceInfo hostingRules(boolean withChildren, int childrenAge, boolean withPets, boolean smoking, boolean party) {
        AtomicReference<Integer> numberOfRow = new AtomicReference<>(1);
        if (withChildren) {
            step("Выберите разрешённый возраст детей", () ->
                    $("[data='Rule']").$(".align-items-center").$(".sc-select").selectOption(childrenAge)
            );
        } else {
            step("Запретить гостей с детьми", () -> {
                $("[data='Rule']").$(".sc-switcher").click();
                numberOfRow.set(0);
            });
        }
        if (withPets) {
            step("Разрешить гостей с животными", () ->
                    chooseItem("Rule", numberOfRow.get()).$(".sc-switcher").click()
            );
        }
        if (!smoking) {
            step("Запретить курение", () ->
                    chooseItem("Rule", numberOfRow.get() + 1).$(".sc-switcher").click()
            );
        }
        if (party) {
            step("Разрешить проведение вечеринок", () ->
                    chooseItem("Rule", numberOfRow.get() + 2).$(".sc-switcher").click()
            );
        }
        return this;
    }

//    Screen 8 (2)

    @Step("Время заезда")
    public AddRentedSpaceInfo checkInTime(String checkInTime) {
        chooseItem("CheckInCheckOut", 1).$(".sc-select").selectOption(checkInTime);
        return this;
    }

    @Step("Время отъезда")
    public AddRentedSpaceInfo checkOutTime(String checkOutTime) {
        chooseItem("CheckInCheckOut", 2).$(".sc-select").selectOption(checkOutTime);
        return this;
    }

//    Screen 9 (2)

    @Step("Способ бронирования")
    public AddRentedSpaceInfo howGuestBook(boolean isBookingImmediate) {
        if (isBookingImmediate) {
            $("[data='HowGuestBook']").$(".sc-radio__label").click();
        } else {
//            todo check chema
            $("[data='HowGuestBook']").$(".pt-10").$(".sc-radio__label").click();
        }
        return this;
    }

//    Screen 10 (2)

    @Step("Выбираем промежуток от бронирования до заселения")
    public AddRentedSpaceInfo bookingGap(Integer bookingGap) {
        $("[data='BookingDate']").$(".booking-date__line").$(".sc-select").selectOption(bookingGap);
        return this;
    }

    @Step("Выбираем срок действия бронирования")
    public AddRentedSpaceInfo bookingDuration(Integer bookingDuration) {
        $("[data='BookingDate']").$(".booking-date__line").sibling(0).$(".sc-select")
                .selectOption(bookingDuration);
        return this;
    }

    @Step("Выбираем размер предоплаты")
    public AddRentedSpaceInfo prepayAmount(Integer prepayAmount) {
        $("[data='BookingDate']").$(".booking-date__line").sibling(1).$(".sc-select")
                .selectOption(prepayAmount);
        return this;
    }

    @Step("Подтверждаем, что будем вести календарь бронирований")
    public AddRentedSpaceInfo сalendarInfoAgreement() {
        $("[data='CalendarInfo']").$(".sc-checkbox").click();
        return this;
    }

    //  Step 3 Screen 1
    @Step("Выбираем валюту оплаты")
    public AddRentedSpaceInfo currencyPay(Integer currency) {
        chooseItemPrice(0).$(".sc-select").selectOption(currency);
        return this;
    }

    @Step("Выбираем минимальный срок проживания")
    public AddRentedSpaceInfo minimalPeriodOfResidence(Integer minPeriodOfResidence) {
        chooseItemPrice(1).$(".sc-select").selectOption(minPeriodOfResidence);
        return this;
    }

    @Step("Вводим цену за сутки и количество гостей")
    public AddRentedSpaceInfo costPerDay(String costPerDay, String amountOfGuest) {
        chooseItemPrice(3).$(".object-creating-form__price-w50").$(".object-creating-form__form-input")
                        .clear();
        chooseItemPrice(3).$(".object-creating-form__price-w50").$(".object-creating-form__form-input")
                .setValue(costPerDay);
        chooseItemPrice(3).$(".object-creating-form__price-w50").sibling(0)
                .$(".sc-select").selectOption(amountOfGuest);
        return this;
    }

    @Step("Вводим доплату за гостя")
//  todo сделать проверку на максимальное количество гостей
    public AddRentedSpaceInfo exGuestPrice(String exGuestPrice) {
        chooseItemPrice(3).$(".object-creating-form__price-w50").sibling(1)
                .$(".object-creating-form__form-input").setValue(exGuestPrice);
        return this;
    }

// Step 3, Screen 2
    @Step("Настраиваем параметры первой скидки")
    public AddRentedSpaceInfo сhooseDiscountParam(String dayForDiscount, Integer valueOfDiscount, String discountType) {
        $(".object-creating__loader").$(".sc-select").selectOptionContainingText(dayForDiscount);
        $(".object-creating__loader").$(".sc-input--elem").setValue(valueOfDiscount.toString());
        $(".object-creating__loader").$(".sc-select:not(.sale-price--wrapper__date)")
                .selectOption(discountType);
        return this;
    }

    private Integer numberOfExDiscount = 0;

    @Step("Добавляем и настраиваем скидку")
    public AddRentedSpaceInfo addDiscount(String dayForDiscount, Integer valueOfDiscount, String discountType) {
        $(".object-creating__loader").$(".sale-price--wrapper").sibling(numberOfExDiscount)
                .$(".sc-select").selectOptionContainingText(dayForDiscount);
        $(".object-creating__loader").$(".sale-price--wrapper").sibling(numberOfExDiscount)
                .$(".sc-select:not(.sale-price--wrapper__date)").selectOptionContainingText(discountType);
        $(".object-creating__loader").$(".sale-price--wrapper").sibling(numberOfExDiscount)
                .$(".sc-input--elem").append(valueOfDiscount.toString());
        numberOfExDiscount = numberOfExDiscount + 1;
        return this;
    }

    @Step("Удаляем скидку")
    public AddRentedSpaceInfo rmDiscount() {
        sleep(2000);
        $(".sale-price--wrapper__close").click();
        return this;
    }

//    Step 3 Screen 3

    @Step("Выбираем, включена ли уборка в стоимость проживания")
    public AddRentedSpaceInfo additionalServices(Integer cleaning) {
        $("[data='FeeAdditionalServices']").$(".sc-select").selectOption(cleaning);
        return this;
    }

    @Step("Вводим стоимость уборки")
    public AddRentedSpaceInfo cleaningCost(String cleaningCost) {
        $("[data='FeeAdditionalServices']").$(".object-creating-form__area-input-sign").preceding(0)
                .setValue(cleaningCost);
        return this;
    }

    @Step("Водим размер депозита")
    public AddRentedSpaceInfo depositAmount(String cleaningCost) {
        $("[data='SecurityDeposit']").$(".object-creating-form__form-input").clear();
        $("[data='SecurityDeposit']").$(".object-creating-form__form-input").setValue(cleaningCost);
        return this;
    }

    @Step("Указываем, есть ли трансфер")
    public AddRentedSpaceInfo isTransfer() {
        $("[data='Transfer']").$(".sc-switcher").click();
        return this;
    }

    @Step("Вводим условия трансфера")
    public AddRentedSpaceInfo transferTerm(String transferTerm) {
        $(".description__textarea").$(".sc-textarea").setValue(transferTerm);
        return this;
    }

//    Step 3 Screen 4
    @Step("Проверяем введённые данные")
    public AddRentedSpaceInfo checkMainData(String checkMainData) {
        $$(".step-booking--text").findBy(text(checkMainData + " $")).shouldBe(visible);
        return this;
    }

    @Step("Проверяем введённые данные")
    public AddRentedSpaceInfo finalPage() {
        $$(".desktop").findBy(text("К сожалению, такой страницы нет.")).shouldBe(visible);
        return this;
    }

}