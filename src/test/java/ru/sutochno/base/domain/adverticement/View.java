package ru.sutochno.base.domain.adverticement;

public enum View {

    CITY("v_city", "на город"),
    FOREST("v_fore", "на лес"),
    LAKE("v_lake", "на озеро"),
    MOUNTAINS("v_moun", "на горы"),
    RIVER("v_rive", "на реку"),
    SEA("v_seas", "на море"),
    STREET("v_strt", "на улицу"),
    YARD("v_yard", "во двор");

    private final String jsonValue;
    private final String name;

    View(String jsonValue, String name) {
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
