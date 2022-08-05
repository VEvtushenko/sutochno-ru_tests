package ru.sutochno.base.domain.adverticement;

import java.util.Random;

import static java.lang.String.format;

public class MainInfo {
  /*
        "area":                 площадь
    "max_floor":            этажей в доме

    "quality_repair":       ремонт:     -10 - выберите
                                          0 - без ремонта
                                          1 - косметический ремонт
                                          2 - капитальный ремонт "под евро"
            3 - дизайнерский евроремонт

    "kitchen_flat":         кухня:        0 - выберите
                                          1 - отдельная кухня
                                          2 - кухня-столовая
                                          3 - кухонная зона
                                         -1 - без кухни


<p align="center"> Integer </p>

            "floor":                Этаж
            <p align="center"> boolean </p>

            "lift":                 Лифт (может быть true только если этажей больше двух)
    "attic_floor":          Мансарда (не может быть true если помещение на первом этаже)
*/

    private Integer maxGuests;
    private final Integer maximumGuests;
    private final Integer numberOfBedrooms;
    private final Integer numberOfBeds;
    private final Integer floorOfFlat;
    private final Integer numberOfFloors;
    private final Integer numberOfRooms;
    private boolean isElevator;
    private boolean isAttic;

    public MainInfo(Integer maxGuests, Integer numberOfBeds, Random random) {
        this.numberOfRooms = random.nextInt(10) + 1;
        this.maxGuests = maxGuests;
        this.maximumGuests = maxGuests;
        this.numberOfBedrooms = random.nextInt(numberOfRooms);
        this.numberOfBeds = numberOfBeds;
        this.numberOfFloors = random.nextInt(40) + 1;
        this.floorOfFlat = random.nextInt(this.numberOfFloors);
        this.isElevator = random.nextBoolean();
        this.isAttic =  random.nextBoolean();
    }

    public  MainInfo(Integer maxGuests, Integer numberOfBedrooms, Integer numberOfBeds, Integer floorOfFlat, boolean isAttic, Integer numberOfFloors, Integer numberOfRooms, boolean isElevator) {
        this.maxGuests = maxGuests;
        this.maximumGuests = maxGuests;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBeds = numberOfBeds;
        this.floorOfFlat = floorOfFlat;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
        this.isElevator = isElevator;
        this.isAttic = isAttic;
    }

    public  MainInfo(Integer maxGuests, Integer numberOfBedrooms, Integer numberOfBeds, Integer floorOfFlat, Integer numberOfFloors, Integer numberOfRooms, boolean isElevator) {
        this.maxGuests = maxGuests;
        this.maximumGuests = maxGuests;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBeds = numberOfBeds;
        this.floorOfFlat = floorOfFlat;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
        this.isElevator = isElevator;
    }

    public  MainInfo(Integer maxGuests, Integer numberOfBedrooms, Integer numberOfBeds, Integer floorOfFlat, boolean isAttic, Integer numberOfFloors, Integer numberOfRooms) {
        this.maxGuests = maxGuests;
        this.maximumGuests = maxGuests;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBeds = numberOfBeds;
        this.floorOfFlat = floorOfFlat;
        this.numberOfFloors = numberOfFloors;
        this.isAttic = isAttic;
        this.numberOfRooms = numberOfRooms;
    }

    public  MainInfo(Integer maxGuests, Integer numberOfBedrooms, Integer numberOfBeds, Integer floorOfFlat, Integer numberOfFloors, Integer numberOfRooms) {
        this.maxGuests = maxGuests;
        this.maximumGuests = maxGuests;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBeds = numberOfBeds;
        this.floorOfFlat = floorOfFlat;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
    }

    public String getDescMain() {
        String descMain;
        if (this.maxGuests == 1) {
            descMain =  format("%s гость", this.maxGuests);
        } else {
            if (this.maxGuests <= 4) {
                descMain =  format("%s гостя", this.maxGuests);
            } else {
                descMain =  format("%s гостей", this.maxGuests);
            }
        }

        if (this.numberOfBeds == 1) {
            descMain = descMain + format("%s кровать", this.numberOfBeds);
        } else {
            if (this.numberOfBeds <= 4) {
                descMain = descMain + format("%s кровати", this.numberOfBeds);
            } else {
                descMain = descMain + format("%s кроватей", this.numberOfBeds);
            }
        }

        if (this.numberOfBedrooms == 1) {
            descMain = descMain + format("%s спальня", this.numberOfBedrooms);
        } else {
            if (this.numberOfBedrooms <= 4) {
                descMain = descMain + format("%s спальни", this.numberOfBedrooms);
            } else {
                descMain = descMain + format("%s спален", this.numberOfBedrooms);
            }
        }

        descMain = descMain + format("%s из %s этаж", this.floorOfFlat, this.numberOfFloors);

        if (this.isElevator) {
            descMain = descMain + " лифт";
        }
        return descMain;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        if (maxGuests < this.maximumGuests) {
            this.maxGuests = maxGuests;
        }
    }

    public Integer getMaximumGuests() {
        return maximumGuests;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public Integer getFloorOfFlat() {
        return floorOfFlat;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public boolean isElevator() {
        return isElevator;
    }

    public boolean isAttic() {
        return isAttic;
    }
}
