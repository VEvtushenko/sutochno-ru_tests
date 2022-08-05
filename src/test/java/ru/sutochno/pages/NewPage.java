package ru.sutochno.pages;

import org.junit.jupiter.api.Test;
import ru.sutochno.base.domain.adverticement.address.StreetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NewPage {
    @Test
    void simpleTest() {
        List<String> streetTypes = new ArrayList<>();
        for (StreetType i: StreetType.values()) {
            streetTypes.add(i.getName());
        }
        streetTypes.get(new Random().nextInt(streetTypes.size()));
    }
}
