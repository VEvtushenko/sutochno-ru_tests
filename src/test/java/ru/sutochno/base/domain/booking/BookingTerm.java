package ru.sutochno.base.domain.booking;

import com.github.javafaker.Faker;
import ru.sutochno.base.domain.booking.placementTerm.PlacementTerm;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BookingTerm {

    private final String checkIn;
    private final String checkOut;
    private final PlacementTerm placementTerm;
//    todo bookingGap, bookingDuration

    private final String timeColonPattern = "H:mm";
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeColonPattern);

    public BookingTerm(Faker faker) {
        this.checkIn = LocalTime.of(faker.random().nextInt(1, 23), 00).format(timeFormatter);
        this.checkOut = LocalTime.of(faker.random().nextInt(1, 23), 00).format(timeFormatter);
        this.placementTerm = new PlacementTerm(faker);
    }

    public BookingTerm(PlacementTerm placementTerm, LocalTime checkIn, LocalTime checkOut) {
        this.placementTerm = placementTerm;
        this.checkIn = checkIn.format(timeFormatter);
        this.checkOut = checkOut.format(timeFormatter);
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public PlacementTerm getPlacementTerm() {
        return placementTerm;
    }
}
