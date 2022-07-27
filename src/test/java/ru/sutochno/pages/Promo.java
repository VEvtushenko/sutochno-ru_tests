package ru.sutochno.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import ru.sutochno.tests.web.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.sutochno.data.Data.promoUrl;

public class Promo extends TestBase {
    public Promo openPromoPage() {
        Configuration.baseUrl = promoUrl;
        open("/bonus-za-prozhivanie");
        $(".t941__textwrapper").shouldHave(Condition.text("Кэшбэк 30% на Суточно.ру"));
        return this;
    }

    public void mainPageButton() {
        $(".t821__btn-wrapper").click();
//        $(".about__title").shouldHave(text("Суточно.ру — сервис бронирования жилья для поездок")); todo Проверка, что отурылась нужная вкладка
        Configuration.holdBrowserOpen = true;
    }
}
