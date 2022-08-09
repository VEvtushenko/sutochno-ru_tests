package ru.sutochno.base.domain.booking.placementTerm;

public enum ChildrenTerm {

    REQUEST(2, "можно с детьми по согласованию с хозяином жилья", false),
    ALLOWED(1, "можно с детьми", true),
    FORBIDDEN(0, "нельзя с детьми", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;

    ChildrenTerm(Integer value, String name, boolean switchValue) {
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
