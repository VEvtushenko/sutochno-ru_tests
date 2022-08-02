package ru.sutochno.data;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import static java.lang.String.format;

public class CheckData {
    Data data = new Data();

    public String getAddress(String streetName, String streetType, String houseNumber, String houseExNumber) {
        if (!houseExNumber.equals("")) {
            return format("%s %s, %s, к %s", streetName, streetType, houseNumber, houseExNumber);
        } else {
            return format("%s %s, %s", streetName, streetType, houseNumber);
        }
    }

    public String getParams(String maxGuests, String numberOfBedrooms, String numberOfBeds, String floorOfFlat, String numberOfFloors, boolean isElevator) {
        if (isElevator) {
            return format("%s гостей%s кровати%s спальни%s из %s этаж (лифт)", maxGuests, numberOfBeds, numberOfBedrooms, floorOfFlat, numberOfFloors);
        } else {
            return format("%s гостей%s кровати%s спальни%s из %s этаж", maxGuests, numberOfBeds, numberOfBedrooms, floorOfFlat, numberOfFloors);
        }
    }

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
            return new String("нельзя с питомцами");
        }
    }
    public String getPartyRules(boolean party) {
        if (party) {
            return new String("можно проводить вечеринки и мероприятия");
        } else {
            return new String("без вечеринок и мероприятий");
        }
    }

    public String addDigitSpace(Integer number) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' '); //разделитель тысяч '
        formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(number);
    }

    public String mainParams = getParams(data.maxGuests.toString(), data.numberOfBedrooms.toString(), data.numberOfBeds.toString(), data.floor.toString(), data.maxFloor.toString(), true);
}