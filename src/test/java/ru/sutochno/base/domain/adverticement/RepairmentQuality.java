package ru.sutochno.base.domain.adverticement;

public enum RepairmentQuality {

    NO_CHOOSE("выберите", -10),
    WHITHOUT_REPAIRMENT("без ремонта", 0),
    LIGHT("косметический ремонт", 1),
    EURO("капитальный ремонт \"под евро\"", 2),
    DISINER("дизайнерский евроремонт", 3);

    private final String name;
    private final Integer value;

    RepairmentQuality(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

}
