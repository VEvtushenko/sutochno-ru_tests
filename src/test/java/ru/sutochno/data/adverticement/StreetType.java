package ru.sutochno.data.adverticement;

public enum StreetType {

    BOULEVARD("бульвар", 1),
    ALLEYWAY("переулок", 2),
    STREET("улица", 3),
    AVENUE("проспект", 4),
    HIGHWAY("шоссе", 5),
    ANOTHER("другое", 10);

    private final String name;
    private final Integer value;

    StreetType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
