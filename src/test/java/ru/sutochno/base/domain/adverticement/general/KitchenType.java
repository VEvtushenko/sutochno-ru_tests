package ru.sutochno.base.domain.adverticement.general;

public enum KitchenType {

    NO_CHOOSE("выберите", 0),
    SEPARATE("отдельная кухня", 1),
    WHITH_DINING_ROOM("кухня-столовая", 2),
    KITCHEN_AREA("кухонная зона", 3),
    WITHOUT_KITCHEN("без кухни", -1);

    private final String name;
    private final Integer value;

    KitchenType(String name, Integer value) {
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
