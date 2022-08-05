package ru.sutochno.base.domain.adverticement.equipment;

public enum HomeFacilities {

    BALCONY("balcony", "балкон"),
    CONDITION("condition", "кондиционер"),
    BEDCLOTHES("bedclothes", "постельное бельё"),
    MICROWAVE("microwave", "СВЧ-печь"),
    WIFI("wifi", "беспроводной интернет Wi-Fi"),
    ISOLATION("isolation", "самоизоляция разрешена"),
    TV("tv", "телевизор"),
    KETTLE("kettle", "электрический чайник");

    private final String jsonValue;
    private final String name;

    HomeFacilities(String jsonValue, String name) {
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
