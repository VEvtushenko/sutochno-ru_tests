package ru.sutochno.pages;

import org.junit.jupiter.api.Test;
import ru.sutochno.base.domain.buisnes.Currencies;

public class NewPage {
    @Test
    void simpleTest() {
        System.out.println(Currencies.RUB.getName());
    }
}
