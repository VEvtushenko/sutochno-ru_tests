package ru.sutochno.base.domain.booking;

import java.util.HashMap;
import java.util.Map;

public enum PetsTerm {

    REQUEST(2, "можно с питомцами по согласованию с хозяином жилья"),
    ALLOWED(1, "можно с питомцами"),
    FORBIDDEN(0, "запрещено");

    private final String name;
    private final Integer value;
    private static final Map<Integer, PetsTerm> petsTermMap = new HashMap<Integer, PetsTerm>();

    PetsTerm(Integer value, String name) {
        this.value = value;
        this.name = name;
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

    public static Map<Integer, PetsTerm> getPetsTermMap() {
        return petsTermMap;
    }
}
