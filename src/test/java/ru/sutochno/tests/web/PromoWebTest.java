package ru.sutochno.tests.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static ru.sutochno.data.Data.promoUrl;

@Tag("promoTests")
public class PromoWebTest extends TestBase {
    @Test
    void promoTenYearSectionTest() {
        Configuration.baseUrl = promoUrl;
    }
}
