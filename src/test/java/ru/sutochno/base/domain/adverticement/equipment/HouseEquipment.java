package ru.sutochno.base.domain.adverticement.equipment;

public enum HouseEquipment {

    FAN("fan", "вентилятор"),
    GEYSER("geyser", "газовый водонагреватель"),
    SEATING_AREA("seating_area", "гостиный уголок"),
    SOFA_BED("sofa_bed", "диван-кровать"),
    JACUZZI("jacuzzi", "джакузи (гидромассажная ванна)"),
    CTABLE("ctable", "журнальный столик"),
    FIREPLACE("fireplace", "камин"),
    MOSQUITO_NET("mosquito_net", "москитная сетка"),
    LINOLEUM("linoleum", "линолеум"),
    ELECTRIC_BLANKETS("electric_blankets", "одеяла с электроподогревом"),
    TILED_MARIABLE_FLOOR("tiled_marble_floor", "плиточный/мраморный пол"),
    DESKTOP("desktop", "рабочий стол"),
    SAFE("safe", "сейф"),
    CLOTHESDRYER("clothesdryer", "сушилка для белья"),
    TELEPHONE("telephone", "телефон"),
    HEATING("heating", "центральное отопление"),
    CUPBOARD("cupboard", "шкаф"),
    WHEATHER("wheater", "водонагреватель"),
    WARDROBE("wardrobe", "гардеробная"),
    WOODEN_PARQUET_FLOOR("wooden_parquet_floor", "деревянный/паркетный пол"),
    INTERCOM("intercom", "домофон"),
    SOFA("sofa", "диван"),
    SOUNDPROOFING("soundproofing", "звукоизоляция"),
    CARPET_COVERING("carpet_covering", "ковровое покрытие"),
    LAMINATE("laminate", "ламинат"),
    STEEL_DOOR("steel_door", "металлическая дверь"),
    HEATER("heater", "обогреватель"),
    INTERNET("internet", "проводной интернет"),
    PC("pc", "персональный компьютер"),
    FOLDING_BED("folding_bed", "раскладная кровать"),
    WASHMACHINE("washmachine", "стиральная машина"),
    DRYING_MACHINE("drying_machine", "сушильная машина"),
    IRON("iron", "утюг с гладильной доской"),
    CLEANING_PRODUCTS("cleaning_products", "чистящие средства");

    private final String jsonValue;
    private final String name;

    HouseEquipment(String jsonValue, String name) {
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
