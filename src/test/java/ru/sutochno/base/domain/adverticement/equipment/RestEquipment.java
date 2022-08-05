package ru.sutochno.base.domain.adverticement.equipment;

public enum RestEquipment {

    BLU_RAY("blu_ray_pl", "blu-ray плеер"),
    DVD("dvd", "DVD-проигрыватель"),
    CONSOL("consol", "игровая консоль"),
    BOOKS("books", "книги"),
    TGAMES("tgames", "настольные игры"),
    LAPTOP("laptop", "ноутбук"),
    TV_SATTELITE("tv_sattelite", "спутниковое ТВ"),
    TV_FREE("tv_free", "эфирное ТВ"),
    DISKS("disks", "CD/DVD диски"),
    BILLIARDS("billiards1", "бильярд"),
    TV_CABLE("tv_cable", "кабельное ТВ"),
    MUSIC_CENTER("music_center", "музыкальный центр"),
    TABLE_TENNIS("tabletennis", "настольный теннис"),
    RADIO("radio", "радио");

    private final String jsonValue;
    private final String name;

    RestEquipment(String jsonValue, String name) {
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
