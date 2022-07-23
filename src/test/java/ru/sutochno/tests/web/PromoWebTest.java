package ru.sutochno.tests.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.sutochno.pages.Promo;


@Tag("promoTests")
public class PromoWebTest extends TestBase {
    @Disabled
    @Test
    void promoTenYearSectionTest() {
        Promo promoPage = new Promo();
        promoPage.openPromoPage().mainPageButton();
    }
}
