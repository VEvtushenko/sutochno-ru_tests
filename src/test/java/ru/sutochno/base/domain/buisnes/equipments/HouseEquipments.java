package ru.sutochno.base.domain.buisnes.equipments;

import java.util.Random;

public enum HouseEquipments {
    FAN("fan", "вентилятор", new Random().nextBoolean()),
    GEYSER("geyser", "газовый водонагреватель", new Random().nextBoolean()),
    SEATING_AREA("seating_area", "гостиный уголок", new Random().nextBoolean()),
    SOFA_BED("sofa_bed", "диван-кровать", new Random().nextBoolean()),
    JACUZZI("jacuzzi", "джакузи (гидромассажная ванна)", new Random().nextBoolean()),
    CTABLE("ctable", "журнальный столик", new Random().nextBoolean()),
    FIREPLACE("fireplace", "камин", new Random().nextBoolean()),
    MOSQUITO_NET("mosquito_net", "москитная сетка", new Random().nextBoolean()),
    LINOLEUM("linoleum", "линолеум", new Random().nextBoolean()),
    ELECTRIC_BLANKETS("electric_blankets", "одеяла с электроподогревом", new Random().nextBoolean()),
    TILED_MARIABLE_FLOOR("tiled_marble_floor", "плиточный/мраморный пол", new Random().nextBoolean()),
    DESKTOP("desktop", "рабочий стол", new Random().nextBoolean()),
    SAFE("safe", "сейф", new Random().nextBoolean()),
    CLOTHESDRYER("clothesdryer", "сушилка для белья", new Random().nextBoolean()),
    TELEPHONE("telephone", "телефон", new Random().nextBoolean()),
    HEATING("heating", "центральное отопление", new Random().nextBoolean()),
    CUPBOARD("cupboard", "шкаф", new Random().nextBoolean()),
    WHEATHER("wheater", "водонагреватель", new Random().nextBoolean()),
    WARDROBE("wardrobe", "гардеробная", new Random().nextBoolean()),
    WOODEN_PARQUET_FLOOR("wooden_parquet_floor", "деревянный/паркетный пол", new Random().nextBoolean()),
    INTERCOM("intercom", "домофон", new Random().nextBoolean()),
    SOFA("sofa", "диван", new Random().nextBoolean()),
    SOUNDPROOFING("soundproofing", "звукоизоляция", new Random().nextBoolean()),
    CARPET_COVERING("carpet_covering", "ковровое покрытие", new Random().nextBoolean()),
    LAMINATE("laminate", "ламинат", new Random().nextBoolean()),
    STEEL_DOOR("steel_door", "металлическая дверь", new Random().nextBoolean()),
    HEATER("heater", "обогреватель", new Random().nextBoolean()),
    INTERNET("internet", "проводной интернет", new Random().nextBoolean()),
    PC("pc", "персональный компьютер", new Random().nextBoolean()),
    FOLDING_BED("folding_bed", "раскладная кровать", new Random().nextBoolean()),
    WASHMACHINE("washmachine", "стиральная машина", new Random().nextBoolean()),
    DRYING_MACHINE("drying_machine", "сушильная машина", new Random().nextBoolean()),
    IRON("iron", "утюг с гладильной доской", new Random().nextBoolean()),
    CLEANING_PRODUCTS("cleaning_products", "чистящие средства", new Random().nextBoolean());

    private final String jsonValue;
    private final String name;
    private final boolean value;

    HouseEquipments(String jsonValue, String name, boolean value) {
        this.jsonValue = jsonValue;
        this.name = name;
        this.value = value;
    }

    public String getJsonValue() {
        return jsonValue;
    }

    public String getName() {
        return name;
    }

    public boolean isValue() {
        return value;
    }
}
