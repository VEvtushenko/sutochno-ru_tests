package ru.sutochno.base.domain.booking.placementTerm;

import java.util.HashMap;
import java.util.Map;

public enum PetsTerm {

    REQUEST(2, "можно с питомцами по согласованию с хозяином жилья", false),
    ALLOWED(1, "можно с питомцами", true),
    FORBIDDEN(0, "нельзя с питомцами", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;
    private static final Map<Integer, PetsTerm> petsTermMap = new HashMap<Integer, PetsTerm>();

    PetsTerm(Integer value, String name, boolean switchValue) {
        this.value = value;
        this.name = name;
        this.switchValue = switchValue;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

     static {
        int i = 0;
        for (PetsTerm petsTerm : PetsTerm.values()) {
            petsTermMap.put(i, petsTerm);
            i++;
        }
    }

    public boolean isSwitchValue() {
        return switchValue;
    }

    public static Map<Integer, PetsTerm> getPetsTermMap() {
        return petsTermMap;
    }
}
