package ru.sutochno.base.domain.adverticement.general;

import java.util.Random;

import static java.lang.String.format;

public class GeneralInfo {

    private final Integer floorOfFlat;
    private final Integer numberOfFloors;
    private final boolean isElevator;
    private final boolean isAttic;
    private final Integer square;
    private String type;

    public GeneralInfo(Random random, Type type) {
        this.numberOfFloors = random.nextInt(99) + 1;
        this.floorOfFlat = random.nextInt(this.numberOfFloors);
        if (numberOfFloors > 2) {
            this.isElevator = random.nextBoolean();
        } else {
            this.isElevator = false;
        }
        if (floorOfFlat > 1) {
            this.isAttic = random.nextBoolean();
        } else {
            this.isAttic = false;
        }
        this.square = random.nextInt(600);

        this.type = type.name();
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

        this.type = type.name();
    }

    public String descFloors() {
        if (this.isElevator) {
            return format("%s из %s этаж (лифт)", this.floorOfFlat, this.numberOfFloors);
        } else {
            return format("%s из %s этаж", this.floorOfFlat, this.numberOfFloors);
        }
    }

    public String descType() {
        return format("%s %sм2", this.type, this.square.toString());
    }
}
