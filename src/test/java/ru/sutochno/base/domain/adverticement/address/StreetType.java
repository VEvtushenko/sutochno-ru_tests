package ru.sutochno.base.domain.adverticement.address;

public enum StreetType {

    BOULEVARD(1, "бульвар"),
    ALLEYWAY(2, "переулок"),
    STREET(3, "улица"),
    AVENUE(4, "проспект"),
    HIGHWAY(5, "шоссе"),
    ANOTHER(10, "другое");

    private final String name;
    private final Integer value;

    StreetType(Integer value, String name) {
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
