package ru.sutochno.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.sutochno.base.domain.adverticement.general.GeneralInfo;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddAdvertisementInfo {

    private SelenideElement chooseItem(String itemName, int numberOfRow) {
        return $("[data='" + itemName + "']").$(".row").sibling(numberOfRow);
    }

    private SelenideElement chooseItemPrice(int numberOfItem) {
        return $("[data='BasePriceSettings']").$(".row").sibling(0)
                .$(".row").sibling(numberOfItem);
    }

    private SelenideElement chooseItemBathroom(int numberOfRow) {
        return $("[data='Bathroom']").$(".row").sibling(numberOfRow);
    }

    @Step("Нажать Продолжить")
    public AddAdvertisementInfo toNextStep() {
        $(byText("Продолжить")).click();
        return this;
    }

//    Screen 1

    @Step("Выберите тип улицы")
    public AddAdvertisementInfo chooseStreetType(String streetType) {
        $(".object-creating-form__form-title").shouldHave(text("Адрес"), Duration.ofSeconds(30));
        chooseItem("Address", 0).$(".sc-select").selectOptionContainingText(streetType);
        return this;
    }

    @Step("Введите название улицы")
    public AddAdvertisementInfo chooseStreetName(String streetName) {
        $("[name='street']").setValue(streetName);
        return this;
    }

    @Step("Ввести номер дома")
    public AddAdvertisementInfo houseNumber(String houseNumber) {
        $("[class='object-creating-form__mobile-row-wrap']")
                .$(".row").$(".object-creating-form__form-input").setValue(houseNumber);
        return this;
    }

    @Step("Ввести номер корпуса")
    public AddAdvertisementInfo houseExNumber(String houseExNumber) {
        if (houseExNumber != null) {
            $("[class='object-creating-form__mobile-row-wrap']")
                    .$(".row").sibling(0).$(".object-creating-form__form-input").setValue(houseExNumber);
        }
        return this;
    }

//    Screen 2

    @Step("Подтвердить карту")
    public AddAdvertisementInfo map() {
        $(".object-creating-form__form-title").shouldHave(text("Карта"), Duration.ofSeconds(30));
        return this;
    }
//  Screen 3

    @Step("Ввести максимум гостей")
    public AddAdvertisementInfo maxGuests(Integer maxGuests) {
        $(".object-creating-form__form-title").shouldHave(text("Сколько гостей вмещает ваше жильё"), Duration.ofSeconds(30));
        chooseItem("Guest", 0).$(".sc-input-quantity__input")
                .setValue(maxGuests.toString());
        return this;
    }

    @Step("Ввести количество  комнат")
    public AddAdvertisementInfo numberOfRooms(Integer numberOfRooms) {
        chooseItem("Guest", 1).$(".sc-input-quantity__input")
                .setValue(numberOfRooms.toString());
        return this;
    }

    @Step("Ввести количество спален")
    public AddAdvertisementInfo numberOfBedrooms(Integer numberOfBedrooms) {
        chooseItem("Guest", 2).$(".sc-select")
                .selectOption(numberOfBedrooms + 1);
        return this;
    }

    @Step("Ввести тип и количество кроватей")
    public AddAdvertisementInfo beds(Map<String, Integer> bedsList) {
        int i = 0;
        for (HashMap.Entry<String, Integer> entry : bedsList.entrySet()) {
            String bedsType = entry.getKey();
            Integer bedsCount = entry.getValue();
            if (bedsType.equals("Односпальных кроватей")) {
                $("[name='single_bed_count']").selectOptionContainingText(bedsCount.toString());
            } else {
                if (bedsCount != 0)  {
                    $("[data='SleepPlaces']").$(".object-creating-form__link").click();
                    $("[data='SleepPlaces']").$(".beds").sibling(i).$(".sc-select").selectOptionByValue(bedsType);
                    $("[data='SleepPlaces']").$(".beds").sibling(i).$(".object-creating-form__form-input--count-beds").selectOptionContainingText(bedsCount.toString());
                    i++;
                }
            }
        }
        return this;
    }

    @Step("Ввести количество совмещённых санузлов")
    public AddAdvertisementInfo bathroomsWithToilet(Integer bathroomsWithToilet) {
        chooseItemBathroom(0).$(".sc-input-quantity__input").setValue(bathroomsWithToilet.toString());
        return this;
    }

    @Step("Ввести количество ванных комнат")
    public AddAdvertisementInfo bathroomsWithoutToilet(Integer bathroomsWithoutToilet) {
        chooseItemBathroom(1).$(".sc-input-quantity__input").setValue(bathroomsWithoutToilet.toString());
        return this;
    }

    @Step("Ввести количество туалетов")
    public AddAdvertisementInfo toilets(Integer toilets) {
        chooseItemBathroom(2).$(".sc-input-quantity__input").setValue(toilets.toString());
        return this;
    }


    @Step("Выбрать удобства в ванных")
    public AddAdvertisementInfo conveniencesInBathroom(String convenience) {
        chooseItemBathroom(4).$(byText(convenience)).click();
        return this;
    }

    @Step("Ввести площадь квартиры")
    public AddAdvertisementInfo squareOfFlat(Integer squareOfFlat) {
        chooseItem("MainInfo", 0).$(".object-creating-form__form-input")
                .setValue(squareOfFlat.toString());
        return this;
    }

//        todo work selector attic

    @Step("Ввести этажность дома, этаж квартиры и в мансарде ли квартира")
    public AddAdvertisementInfo floorAndElevator(GeneralInfo generalInfo) {
        $("[data='MainInfo'").$("[name='floor']").selectOption(generalInfo.getFloorOfFlat() + 1);
        $("[data='MainInfo'").$("[name='max_floor']").setValue(generalInfo.getNumberOfFloors().toString());
//        if (generalInfo.isElevator() & generalInfo.getNumberOfFloors() > 2) {
//            $("[data='MainInfo'").$(byText("лифт")).click();
//        } Лифт укажем в удобствах
        if (generalInfo.isAttic() & generalInfo.getFloorOfFlat() > 1 & generalInfo.getFloorOfFlat().equals(generalInfo.getNumberOfFloors())) {
            $("[data='MainInfo'").$(byText("мансарда")).click();

        }
        return this;
    }


    @Step("Ввести тип кухни")
    public AddAdvertisementInfo typeOfKitchen(Integer typeOfKitchen) {
        chooseItem("MainInfo", 3).$(".sc-select").selectOption(typeOfKitchen);
        return this;
    }

    @Step("Ввести тип ремонта")
    public AddAdvertisementInfo typeOfRepairment(Integer typeOfRepairment) {
        chooseItem("MainInfo", 4).$(".sc-select").selectOption(typeOfRepairment);
        return this;
    }

//    Screen 4

    @Step("Ввести удобства")
    public AddAdvertisementInfo homeFacilities(String facility) {
        $(".object-creating-form__form-title").shouldHave(text("Удобства"), Duration.ofSeconds(30));
        chooseItem("Facilities", 0).$(byText(facility)).click();
        return this;
    }

    @Step("Ввести вид из окон")
    public AddAdvertisementInfo chooseView(String view) {
        $("[data='Facilities']").$(".object-creating-form--main-info").$(byText(view)).click();
        return this;
    }

    @Step("Выберем удобства")
    public AddAdvertisementInfo equipments(String name, Map<String, Boolean> equipment) {
        step("Нажать развернуть список", () ->
                    $(By.xpath("//span[contains(@class, 'toggle-block__btn') and text()='развернуть список']")).click()
        );
            for (HashMap.Entry<String, Boolean> entry : equipment.entrySet()) {
                String equipmentName = entry.getKey();
                Boolean equipmentTrue = entry.getValue();
                if (equipmentTrue) {
                    step("Выбрать " + equipmentName, () ->
                            $("[data='Facilities']").$(byText(equipmentName)).click());
                }
        }
// todo       step("Нажать свернуть список", () ->
//                $(By.xpath("//span[contains(@class, 'toggle-block__btn active') and text()='свернуть список']")).click());
        return this;
    }

//    Screen 5

    @Step("Загрузите фотографии")
    public AddAdvertisementInfo uploadFoto(String pathToImage) {
        $(".object-creating-form__form-title").shouldHave(text("Загрузите фотографии"), Duration.ofSeconds(30));
        $(".load-image").$(".load-image__select-files").$("[type='file']").uploadFile(new File(pathToImage));
        sleep(5000);
        return this;
    }

    //    Screen 6

    @Step("Заголовок объекта")
    public AddAdvertisementInfo inputAdvertisementName(String name) {
        $(".object-creating-form__form-title").shouldHave(text("Заголовок"), Duration.ofSeconds(30));
        $("[data='NameObject']").$(".name__item").$(".sc-input--elem").setValue(name);
        return this;
    }

    @Step("Добавить уникальное имя, которое видит только хозяин объявления")
    public AddAdvertisementInfo addUniqName(String name) {
        $("[data='NameObject']").$(".name__adduniq").$(".adduniq__button").click();
        $("[data='NameObject']").$(".name__item").sibling(0).$(".sc-input--elem").setValue(name);
        return this;
    }

    @Step("Ввести описание объекта")
    public AddAdvertisementInfo inputAdvertisementDesc(String description) {
        $("[data='DescriptionObject']").$(".sc-textarea").setValue(description);
        return this;
    }

//        Screen 7

    @Step("Правила размещения")
    public AddAdvertisementInfo placementTerms(boolean withChildren, int childrenAge, boolean withPets, boolean smoking, boolean party) {
        $(".object-creating-form__form-title").shouldHave(text("Правила размещения"), Duration.ofSeconds(30));
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
    public AddAdvertisementInfo checkInTime(String checkInTime) {
        $(".object-creating-form__form-title").shouldHave(text("Заезд / отъезд"), Duration.ofSeconds(30));
        $("[name='check_in']").selectOptionByValue(checkInTime);
        return this;
    }

    @Step("Время отъезда")
    public AddAdvertisementInfo checkOutTime(String checkOutTime) {
        $("[name='check_out']").selectOptionByValue(checkOutTime);
        return this;
    }

//    Screen 9 (2)

    @Step("Способ бронирования")
    public AddAdvertisementInfo howGuestBook(boolean isBookingImmediate) {
        $(".object-creating-form__form-title").shouldHave(text("Как гости могут бронировать"), Duration.ofSeconds(30));
        if (isBookingImmediate) {
            $("[data='HowGuestBook']").$(".sc-radio__label").click();
        } else {
            $("[data='HowGuestBook']").$(".pt-10").$(".sc-radio__label").click();
        }
        return this;
    }

//    Screen 10 (2)

    @Step("Выбираем промежуток от бронирования до заселения")
    public AddAdvertisementInfo bookingGap(Integer bookingGap) {
        $(".object-creating-form__form-title").shouldHave(text("Настройки мгновенного бронирования"), Duration.ofSeconds(30));
        $("[data='BookingDate']").$(".booking-date__line").$(".sc-select").selectOption(bookingGap);
        return this;
    }

    @Step("Выбираем срок действия бронирования")
    public AddAdvertisementInfo bookingDuration(Integer bookingDuration) {
        $("[data='BookingDate']").$(".booking-date__line").sibling(0).$(".sc-select")
                .selectOption(bookingDuration);
        return this;
    }

    @Step("Выбираем размер предоплаты")
    public AddAdvertisementInfo prepayAmount(Integer prepayAmount) {
        $("[data='BookingDate']").$(".booking-date__line").sibling(1).$(".sc-select")
                .selectOption(prepayAmount);
        return this;
    }

    @Step("Подтверждаем, что будем вести календарь бронирований")
    public AddAdvertisementInfo calendarInfoAgreement() {
        $(".object-creating-form__form-title").shouldHave(text("Ведите календарь занятости — гостям важна каждая дата"), Duration.ofSeconds(30));
        $("[data='CalendarInfo']").$(".sc-checkbox").click();
        return this;
    }

    //  Step 3 Screen 1
    @Step("Выбираем валюту оплаты")
    public AddAdvertisementInfo currencyPay(String currency) {
        $(".object-creating-form__form-title").shouldHave(text("Цены"), Duration.ofSeconds(30));
        chooseItemPrice(0).$(".sc-select").selectOptionContainingText(currency);
        return this;
    }

    @Step("Выбираем минимальный срок проживания")
    public AddAdvertisementInfo minimalPeriodOfResidence(Integer minPeriodOfResidence) {
        chooseItemPrice(1).$(".sc-select").selectOption(minPeriodOfResidence - 1);
        return this;
    }

    @Step("Вводим цену за сутки и количество гостей")
    public AddAdvertisementInfo costPerDay(Integer costPerDay, Integer amountOfGuest) {
        chooseItemPrice(3).$(".object-creating-form__price-w50").$(".object-creating-form__form-input")
                .setValue(costPerDay.toString());
        chooseItemPrice(3).$(".object-creating-form__price-w50").sibling(0)
                .$(".sc-select").selectOption(amountOfGuest.toString());
        return this;
    }

    @Step("Вводим доплату за гостя")
//  todo сделать проверку на максимальное количество гостей
    public AddAdvertisementInfo exGuestPrice(String exGuestPrice) {
        chooseItemPrice(3).$(".object-creating-form__price-w50").sibling(1)
                .$(".object-creating-form__form-input").setValue(exGuestPrice);
        return this;
    }

// Step 3, Screen 2

    @Step("Настраиваем параметры первой скидки")
    public AddAdvertisementInfo chooseDiscountParam(String dayForDiscount, Integer valueOfDiscount, String discountType) {
        $(".object-creating-form__form-title").shouldHave(text("Скидки"), Duration.ofSeconds(30));
        $(".object-creating__loader").$(".sc-select").selectOptionContainingText(dayForDiscount);
        $(".object-creating__loader").$(".sc-input--elem").setValue(valueOfDiscount.toString());
        $(".object-creating__loader").$(".sc-select:not(.sale-price--wrapper__date)")
                .selectOption(discountType);
        return this;
    }

    private Integer numberOfExDiscount = 0;

    @Step("Добавляем и настраиваем скидку")
    public AddAdvertisementInfo addDiscount(String dayForDiscount, Integer valueOfDiscount, String discountType) {
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
    public AddAdvertisementInfo rmDiscount() {
        $(".object-creating-form__form-title").shouldHave(text("Скидки"), Duration.ofSeconds(30));
        $(".sale-price--wrapper__close").click();
        return this;
    }

//    Step 3 Screen 3

    @Step("Выбираем, включена ли уборка в стоимость проживания")
    public AddAdvertisementInfo additionalServices(Integer cleaning) {
        $(".object-creating-form__form-title").shouldHave(text("Плата за уборку"), Duration.ofSeconds(30));
        $("[data='FeeAdditionalServices']").$(".sc-select").selectOption(cleaning);
        return this;
    }

    @Step("Вводим стоимость уборки")
    public AddAdvertisementInfo cleaningCost(Integer cleaningCost) {
        $("[data='FeeAdditionalServices']").$(".object-creating-form__area-input-sign").preceding(0)
                .setValue(cleaningCost.toString());
        return this;
    }

    @Step("Водим размер депозита")
    public AddAdvertisementInfo depositAmount(Integer cleaningCost) {
        $("[data='SecurityDeposit']").$(".object-creating-form__form-input").clear();
        $("[data='SecurityDeposit']").$(".object-creating-form__form-input").setValue(cleaningCost.toString());
        return this;
    }

    @Step("Указываем, есть ли трансфер")
    public AddAdvertisementInfo isTransfer() {
        $("[data='Transfer']").$(".sc-switcher").click();
        return this;
    }

    @Step("Вводим условия трансфера")
    public AddAdvertisementInfo transferTerm(String transferTerm) {
        $(".description__textarea").$(".sc-textarea").setValue(transferTerm);
        return this;
    }

//    Step 3 Screen 4
    @Step("Проверяем введённые данные")
    public AddAdvertisementInfo checkMainData(Integer price, String currencySign) {
        $(".object-creating-form__form-title").shouldHave(text("Ваше объявление почти готово! Проверьте главное:"), Duration.ofSeconds(30));
        $$(".step-booking--text").findBy(text(price + " " + currencySign)).shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    @Step("Проверяем введённые данные")
    @Description("Результат выполнения этого шага, судя по всему, является багом - согласно общей логике здесь должен быть редирект на объявление")
    public AddAdvertisementInfo finalPage() {
        $$(".desktop").findBy(text("К сожалению, такой страницы нет.")).shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }
}