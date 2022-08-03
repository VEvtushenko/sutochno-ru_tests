package ru.sutochno.pages;

import org.junit.jupiter.api.Test;
import ru.sutochno.base.domain.buisnes.equipments.KitchenEquipments;

public class NewPage {
    @Test
    void simpleTest() {
        System.out.println(KitchenEquipments.BAR.getValue());
    }
}
