package ru.sutochno.base.domain.booking;

public enum SmokingTerm {

    IN_PLACES("разрешено в специально отведённых местах", 3),
    ALLOWED("разрешено", 1),
    FORBIDDEN("запрещёно", 0);

    private final String name;
    private final Integer value;

    SmokingTerm(String name, Integer value) {
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
