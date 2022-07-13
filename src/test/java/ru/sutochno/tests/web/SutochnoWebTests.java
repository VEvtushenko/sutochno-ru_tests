package ru.sutochno.tests.web;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.sutochno.config.Project;
import ru.sutochno.pages.UserPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

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
    @DisplayName("Создание объявления от зарегистрированного пользователя")
    @Owner("admin")
    void makeAdvertisementUiTest() {
        UserPage userPage = new UserPage();
        step("Авторизоваться (по API)", () -> {
            open("/front/searchapp/favicon.svg");
            WebDriverRunner.getWebDriver().manage().addCookie(
                    requests.getAuth(
                            Project.config.userPhone(),
                            Project.config.userPassword()));
            mainPage.openPageWithAuth(Project.config.userName()); // todo Облагородить, возможно перенести в пэйджобджект
        });

        userPage.open();
        step("Кликнуть на Разместите свое жилье");
        step("Кликнуть на Квартиры, апартаменты");
        step("Выбрать тип Апартамент");
        step("Выбрать страну Беларусь");
        step("Выбрать регион Брестская область");
        step("Выбрать город Брест");
        step("Нажать Продолжить");
        step("Нажать на юзернейм", () -> {
            step("Проверить, что счётчик в разделе Мои объекты равен 1");
        });
        step("Нажать на Перейти в раздел в разделе Мои объекты");
        step("Нажать Продолжить");
        step("Ввести адрес", () -> {
            step("Выбрать тип улицы");
            step("Ввести название улицы");
            step("Ввести номер дома");
            step("Ввести номер корпуса");
            step("Нажать Продолжить");
        });
        step("Нажать Продолжить (подтвердить карту)");
        step("Ввести параметры жилья", () -> {
            step("Ввести максимум гостей");
            step("Ввести количество  комнат");
            step("Ввести количество спален");
            step("Ввести тип и количество кроватей");
            step("Добавить кровать");
            step("Ввести количество ванных комнат и туалетов и их параметры");
            step("Ввести площадь квартиры");
            step("Ввести этаж квартиры");
            step("Ввести этажность дома");
            step("Ввести тип кухни");
            step("Ввести тип ремонта");
            step("Нажать Продолжить");
        });
        step("Ввести удобства");
        step("Ввести вид из окон");
        step("Выбрать кухонное оборудвание", () -> {
            step("Нажать Развернуть список");
            step("Выбрать оборудование");
        });
        step("Выбрать оснащение", () -> {
            step("Нажать Развернуть список");
            step("Выбрать оснащение");
        });
        step("Выбрать для отдыха в помещении", () -> {
            step("Нажать Развернуть список");
            step("Выбрать для отдыха в помещении");
        });
        step("Выбрать оснащение двора", () -> {
            step("Нажать Развернуть список");
            step("Выбрать оснащение двора");
        });
        step("Выбрать для детей", () -> {
            step("Нажать Развернуть список");
            step("Выбрать для детей");
        });
        step("Нажать Продолжить");
        step("Загрузить фото", () -> {
            step("Нажать Выберите на устройстве");
            step("Загрузить фото");
            step("Повторить трижды");
            step("Нажать Продолжить");
        });
        step("Ввести имя объекта", () -> {
            step("Ввести описание объекта", () -> {
                step("Нажать Продолжить");
            });
        });
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
