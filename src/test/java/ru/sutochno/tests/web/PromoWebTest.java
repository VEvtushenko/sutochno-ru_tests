package ru.sutochno.tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



@Tag("promoTests")
public class PromoWebTest extends TestBase {
    @Test
    void promoTenYearSectionTest() {
        promoPage.openPromoPage().mainPageButton();
    }
}
