package ru.sutochno.base.domain.adverticement.equipment;

public enum Accessibility {
    SELF_CHECK_IN("is_self_in", "возможно бесконтактное заселение"),
    DIS_ACCESS("is_dis", "доступ для инвалидов"),
    LIFT("lift", "лифт"),
    FIRST_FLOOR("room_first_floor", "находится на первом этаже"),
    TOILET_HANDRAILS("toilet_handrails", "туалет с поручнями");

    private final String jsonValue;
    private final String name;

    Accessibility(String jsonValue, String name) {
        this.jsonValue = jsonValue;
        this.name = name;
    }

    public String getJsonValue() {
        return jsonValue;
    }

    public String getName() {
        return name;
    }
}
