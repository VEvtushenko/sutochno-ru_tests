package ru.sutochno.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.sutochno.data.Data.promoUrl;

public class Promo {
    public Promo openPromoPage() {
        Configuration.baseUrl = promoUrl;
        open("/");
        $(".t941__textwrapper").shouldHave(Condition.text("Кэшбэк 30% на Суточно.ру"));
        return this;
    }
}
