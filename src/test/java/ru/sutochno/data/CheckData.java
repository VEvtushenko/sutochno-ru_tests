package ru.sutochno.data;

import ru.sutochno.data.Data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import static java.lang.String.format;

public class CheckData {

//todo    public String getBeds(String maxGuests, String numberOfBedrooms, String numberOfBeds, String floorOfFlat, String numberOfFloors, boolean isElevator) {
//        if (isElevator) {
//            return String.format("%s гостей %s кровати %s спальни %s из %s этаж (лифт)", maxGuests, numberOfBedrooms, numberOfBeds, floorOfFlat, numberOfFloors);
//        } else {
//            return String.format("%s гостей %s кровати %s спальни %s из %s этаж", maxGuests, numberOfBedrooms, numberOfBeds, floorOfFlat, numberOfFloors);
//        }
//    }

    public String getChildrenRules(boolean withChildren, String childrenAge) {
        if (withChildren) {
            String childrenRules = "можно с детьми ";
            if (childrenAge.equals("1")) {
                return format("можно с детьми от %s года и старше", childrenAge);
            } else {
                return format("можно с детьми от %s лет и старше", childrenAge);
            }
        } else {
            return new String("нельзя с детьми");
        }
    }

    public String getSmokingRules(boolean smoking) {
        if (smoking) {
            return new String("курение разрешено");
        } else {
            return new String("курение запрещено");
        }
    }

    public String getPetsRules(boolean withPets) {
        if (withPets) {
            return new String("можно с питомцами");
        } else {
            return new String("можно с питомцами по согласованию с хозяином жилья");
        }
    }
    public String getPartyRules(boolean party) {
        if (party) {
            return new String("можно проводить вечеринки и мероприятия");
        } else {
            return new String("вечеринки и мероприятия по согласованию с хозяином жилья");
        }
    }

}