package ru.sutochno.base.domain.adverticement.equipment;

public enum ChildrenEquipment {

    HIGH_CHAIR("high_chair_for_child", "высокий стул для ребенка"),
    GAMES("games", "игры/игрушки для детей"),
    BABY_POTTY("baby_potty", "детский горшок"),
    CHANG_TABLE("baby_chang_table", "пеленальный стол"),
    BABY_BED("baby_bed", "детская кроватка"),
    SAFE_WINDOW("safe_window", "защита на окнах"),
    BABY_BED_M("baby_bed_m", "кровать-манеж"),
    BABYCHAIR("babychair", "стульчик для кормления");

    private final String jsonValue;
    private final String name;

    ChildrenEquipment(String jsonValue, String name) {
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
