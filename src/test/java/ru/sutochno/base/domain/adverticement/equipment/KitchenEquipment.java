package ru.sutochno.base.domain.adverticement.equipment;

public enum KitchenEquipment {

    BAR("bar", "барная стойка"),
    GASSTOVE("gasstove", "газовая плита"),
    COFFEMAKER("coffeemaker", "кофеварка"),
    KITCHEN("kitchen", "кухонный гарнитур"),
    DEEPFREEZE("deepfreeze", "морозильник"),
    DINNER_TABLE("dinner_table", "обеденный стол"),
    DISHWASHER("dishwasher", "посудомоечная машина"),
    CUTLERLY("cutlery", "столовые приборы"),
    TURKA("turka", "турка для приготовления кофе"),
    ELECTRICRANGE("electricrange", "электроплита"),
    REFRIGERATOR("refrigerator", "холодильник"),
    BLENDER("blender", "блендер"),
    OVEN("oven", "духовка"),
    COFFEE_MACHINE("coffee_machine", "кофемашина"),
    MINI_BAR("mini_bar", "мини-бар"),
    CROCKERY("crockery", "посуда и принадлежности"),
    MULTICOOKER("multicooker", "мультиварка"),
    TOASTER("Toaster", "тостер"),
    WATERFILTER("waterfilter", "фильтр для воды");

    private final String jsonValue;
    private final String name;

    KitchenEquipment(String jsonValue, String name) {
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
