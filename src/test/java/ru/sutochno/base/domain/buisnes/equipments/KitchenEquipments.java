package ru.sutochno.base.domain.buisnes.equipments;

import java.util.Random;

public enum KitchenEquipments {

    BAR("bar", "барная стойка", new Random().nextBoolean()),
    GASSTOVE("gasstove", "газовая плита", new Random().nextBoolean()),
    COFFEMAKER("coffeemaker", "кофеварка", new Random().nextBoolean()),
    KITCHEN("kitchen", "кухонный гарнитур", new Random().nextBoolean()),
    DEEPFREEZE("deepfreeze", "морозильник", new Random().nextBoolean()),
    DINNER_TABLE("dinner_table", "обеденный стол", new Random().nextBoolean()),
    DISHWASHER("dishwasher", "посудомоечная машина", new Random().nextBoolean()),
    CUTLERLY("cutlery", "столовые приборы", new Random().nextBoolean()),
    TURKA("turka", "турка для приготовления кофе", new Random().nextBoolean()),
    ELECTRICRANGE("electricrange", "электроплита", new Random().nextBoolean()),
    REFRIGERATOR("refrigerator", "холодильник", new Random().nextBoolean()),
    BLENDER("blender", "блендер", new Random().nextBoolean()),
    OVEN("oven", "духовка", new Random().nextBoolean()),
    COFFEE_MACHINE("coffee_machine", "кофемашина", new Random().nextBoolean()),
    MINI_BAR("mini_bar", "мини-бар", new Random().nextBoolean()),
    CROCKERY("crockery", "посуда и принадлежности", new Random().nextBoolean()),
    MULTICOOKER("multicooker", "мультиварка", new Random().nextBoolean()),
    TOASTER("Toaster", "тостер", new Random().nextBoolean()),
    WATERFILTER("waterfilter", "фильтр для воды", new Random().nextBoolean());

    private final String jsonValue;
    private final String name;
    private final boolean value;

    KitchenEquipments(String jsonValue, String name, boolean value) {
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

    public boolean getValue() {
        return value;
    }

}
