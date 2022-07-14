package ru.sutochno.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class UsersAdvertisements {
    public AddNewRentedSpace createNewAdvertisement() {
        $(".object-head__button-create").click();
        switchTo().window("Российский сервис бронирования жилья: более 100 тысяч квартир посуточно, комнаты, гостевые дома — Суточно.ру");
        $("[class='object-create__heading object-create__text-center']").shouldHave(text("Сдайте свое жильё"));
        return new AddNewRentedSpace();
    }
}


//    нужно туда переключиться
//// by index
//switchTo().window(1);
//// by name or title or handle
//        switchTo().window("Title of the window");
//// for switching to default window
//        switchTo().defaultContent();