package ru.sutochno.base.domain.adverticement.equipment;

public enum YardEquipment {

    SWIMPOOL("swimpool1", "бассейн"),
    BATH1("bath1", "баня (на территории)"),
    VERANDA("veranda", "веранда"),
    GARAGE("garage", "гараж"),
    PLAYGROUND("playground", "игровая площадка"),
    OUTDOOR_FURNITURE("outdoor_furniture", "мебель на улице"),
    SECURITI("security", "охраняемая территория"),
    PATIO("patio", "патио"),
    GYM("gym", "спортивный зал"),
    BARBECUE_FACILITIES("barbecue_facilities", "принадлежности для барбекю"),
    GRIDIRON("gridiron", "футбольное поле"),
    BARBECUE("barbecue", "барбекю/мангал"),
    HAMOK("hammok", "гамак"),
    ARBOR("arbor", "беседка"),
    SWING("swing", "детские качели"),
    BOAT("boat", "лодка"),
    OUTDOOR_DINING("outdoor_dining_area", "обеденная зона на улице"),
    PARKING("parking", "парковка"),
    GARDEN_FURNITURE("gfurniture", "садовая мебель"),
    PARASOL("parasol", "пляжный зонтик"),
    TERRACE("terrace", "терраса"),
    DECKCHAIR("deckchair", "шезлонги");

    private final String jsonValue;
    private final String name;

    YardEquipment(String jsonValue, String name) {
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
