package ru.sutochno.base.domain.booking.placementTerm;

public enum SmokingTerm {

    IN_PLACES(3, "курение разрешено в специально отведенных местах", false),
    ALLOWED(1, "курение разрешено", true),
    FORBIDDEN(0, "курение запрещено", false);

    private final String name;
    private final Integer value;
    private final boolean switchValue;

    SmokingTerm(Integer value, String name, boolean switchValue) {
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
