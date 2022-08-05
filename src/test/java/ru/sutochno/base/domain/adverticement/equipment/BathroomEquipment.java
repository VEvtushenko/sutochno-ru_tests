package ru.sutochno.base.domain.adverticement.equipment;

public enum BathroomEquipment {

    BIDET("bidet", "биде"),
    BATHROOMS("bathrooms", "ванна"),
    ADD_BATHROOM("add_bathroom", "дополнительная ванная"),
    ADD_TOILET("add_toilet", "дополнительный туалет"),
    BATHROBE("bathrobe", "халат"),
    CSSHOWER("cshower", "общий душ/душевая"),
    HAIRDRYER("hairdryer", "фен"),
    HYGIENIC_SHOWER("hygienic_shower", "гигиенический душ"),
    SAUNA("sauna", "сауна"),
    SHARED_BATHROOM("shared_bathroom", "общая ванная комната"),
    SHARED_TOILET("shared_toilet", "общий туалет"),
    SHOWER("shower", "душ"),
    SLIPPERS("slippers", "тапочки"),
    TOILETRIES("toiletries", "туалетные принадлежности"),
    TOWELS("towels", "полотенца");

    private final String jsonValue;
    private final String name;

    BathroomEquipment(String jsonValue, String name) {
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
