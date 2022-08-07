package ru.sutochno.base.domain.adverticement.general;

import com.github.javafaker.Faker;

import java.util.Random;

import static java.lang.String.format;

public class GuestsVolume {

    private final Integer maxGuests;
    private final Integer numberOfBedrooms;
    private final Integer numberOfRooms;

    public GuestsVolume(Faker faker, Integer maxGuests) {
        this.numberOfRooms = faker.random().nextInt(1, 10);
        this.maxGuests = faker.random().nextInt(2, maxGuests);
        this.numberOfBedrooms = faker.random().nextInt(numberOfRooms);
    }

    public GuestsVolume(Integer maxGuests, Integer numberOfBedrooms, Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        this.maxGuests = maxGuests;
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String guestsVolumeDesc() {
        String descMain;
        if (this.maxGuests == 1) {
            return format("%s гость", this.maxGuests);
        } else {
            if (this.maxGuests <= 4) {
                return format("%s гостя", this.maxGuests);
            } else {
                return format("%s гостей", this.maxGuests);
            }
        }
    }

    public String bedroomsDesc() {
        if (this.numberOfBedrooms == 0) {
            return "";
        }
        if (this.numberOfBedrooms == 1) {
            return format("%s спальня", this.numberOfBedrooms);
        } else {
            if (this.numberOfBedrooms <= 4) {
                return format("%s спальни", this.numberOfBedrooms);
            } else {
                return format("%s спален", this.numberOfBedrooms);
            }
        }
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }
}
