package ru.sutochno.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class UsersAdvertisements {
    public AddNewAdvertisement createNewAdvertisement() {
        $(".object-head__button-create").click();
        switchTo().window(1);
                /*.window("Российский сервис бронирования жилья: более 100 тысяч квартир посуточно, комнаты, гостевые дома — Суточно.ру"
                );*/
        $("[class='object-create__heading object-create__text-center']").shouldHave(text("Сдавайте своё жильё на Суточно.ру"));
        return new AddNewAdvertisement();
    }

    @Step("Открываем последнее созданное объявление")
    public ViewingAdvertisement openLastAdvertisements() {
        $("div.object-element:last-child").$(".table-object__left").click();
        switchTo().window(2);
        return new ViewingAdvertisement();
    }

    @Step("Убираем верхнее объявление в архив")
    public UsersAdvertisements moveToArchive() {
        step("Открываем свойства объявления", () ->
                $(".setting-icon").click());
        step("Нажимаем \"Убрать в архив\"", () ->
                $("[class='sidebar-action__title sidebar-action__archive']").click());
        step("Выбираем причину", () ->
                $(".input-radio").click());
        step("Подтверждаем удаление", () ->
                $(".btn-save").click());
        return this;
    }
}