package ru.sutochno.base.domain.booking.placementTerm;

public enum PetsTerm {

    REQUEST(2, "можно с питомцами по согласованию с хозяином жилья", false),
    ALLOWED(1, "можно с питомцами", true),
    FORBIDDEN(0, "нельзя с питомцами", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;

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

    public boolean isSwitchValue() {
        return switchValue;
    }

}
