package ru.sutochno.base.domain.adverticement.general;

import com.github.javafaker.Faker;

import java.util.Random;

import static java.lang.String.format;

public class GeneralInfo {

    private final Integer floorOfFlat;
    private final Integer numberOfFloors;
    private final boolean isElevator;
    private final boolean isAttic;
    private final Integer square;
    private Type type;

    public GeneralInfo(Faker faker, Type type) {
        this.numberOfFloors = faker.random().nextInt(1, 99);
        this.floorOfFlat = faker.random().nextInt(this.numberOfFloors);
        if (numberOfFloors > 2) {
            this.isElevator = faker.random().nextBoolean();
        } else {
            this.isElevator = false;
        }
        if (floorOfFlat > 1) {
            this.isAttic = faker.random().nextBoolean();
        } else {
            this.isAttic = false;
        }
        this.square = new Faker().random().nextInt(30, 600);

        this.type = type;
    }

    public GeneralInfo(Integer floorOfFlat, boolean isAttic, Integer numberOfFloors, boolean isElevator, Integer square, Type type) {
        this.floorOfFlat = floorOfFlat;
        this.numberOfFloors = numberOfFloors;
        if (numberOfFloors > 2) {
            this.isElevator = isElevator;
        } else {
            this.isElevator = false;
        }
        if (floorOfFlat > 1) {
            this.isAttic = isAttic;
        } else {
            this.isAttic = false;
        }
        this.square = square;

        this.type = type;
    }

    public String descFloors() {
        String floorOfFlat = this.floorOfFlat.toString();
        if (this.floorOfFlat == 0) {
            floorOfFlat = "цоколь";
        }
        if (this.isElevator) {
            return format("%s из %s этаж (лифт)", floorOfFlat, this.numberOfFloors);
        } else {
            return format("%s из %s этаж", floorOfFlat, this.numberOfFloors);
        }
    }

    public String descType() {
        return format("%s %sм2", this.type, this.square.toString());
    }

    public Integer getFloorOfFlat() {
        return floorOfFlat;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isElevator() {
        return isElevator;
    }

    public boolean isAttic() {
        return isAttic;
    }

    public Integer getSquare() {
        return square;
    }

    public Type getType() {
        return type;
    }
}
