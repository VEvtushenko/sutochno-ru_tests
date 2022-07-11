package ru.sutochno.tests.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SutochnoWebTests extends TestBase {

    @Test
    void authTest() {

    }

    @MethodSource("currencyNameSource")
    @ParameterizedTest(name = "")
    void currencyChangeTest() {

    }

    @Test
    void searchTest() {

    }

    @Test
    void promoTenYearSectionTest() {

    }

    @Test
    void makeAdvertisementUiTest() {

    }
}
