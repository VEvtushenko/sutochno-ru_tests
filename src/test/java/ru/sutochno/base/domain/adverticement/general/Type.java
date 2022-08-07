package ru.sutochno.base.domain.adverticement.general;

public enum Type {
    APART("Апартамент"),
    FLAT("Квартира"),
    STUDIO("Студия");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
