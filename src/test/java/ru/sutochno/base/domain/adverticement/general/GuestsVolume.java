package ru.sutochno.base.domain.adverticement.general;

import java.util.Random;

import static java.lang.String.format;

public class GuestsVolume {

    private final Integer maxGuests;
    private final Integer numberOfBedrooms;
    private final Integer numberOfRooms;

    public GuestsVolume(Random random, Integer maxGuests) {
        this.numberOfRooms = random.nextInt(10) + 1;
        this.maxGuests = random.nextInt(maxGuests);
        this.numberOfBedrooms = random.nextInt(numberOfRooms);
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
}
