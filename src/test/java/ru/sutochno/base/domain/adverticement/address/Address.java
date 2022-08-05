package ru.sutochno.base.domain.adverticement.address;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public class Address {

    private final String streetName;
    private final String streetType;
    private final String houseNumber;
    private String houseExNumber;
    private final String address;

    public Address( String streetType, String streetName, String houseNumber, String houseExNumber) {
        this.streetType = streetType;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.houseExNumber = houseExNumber;
        this.address = format("%s %s, %s, к %s", streetName, streetType, houseNumber, houseExNumber);
    }

    public Address( String streetType, String streetName, String houseNumber) {
        this.streetType = streetType;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.address = format("%s %s, %s", streetName, streetType, houseNumber, houseExNumber);
    }

    public Address(Faker faker) {

        List<String> streetTypes = new ArrayList<>();
        for (StreetType streetType: StreetType.values()) {
            streetTypes.add(streetType.getName());
        }
        this.streetType = streetTypes.get(new Random().nextInt(streetTypes.size()));

        String streetName  = "Мира";
        String[] streetNameWithSuffix = faker.address().streetName().split(" ");
        for (String word : streetNameWithSuffix) {
            if (word.matches("[А-Я]"))  {
                streetName = word;
            }
        }
        this.streetName = streetName;

        this.houseNumber = faker.address().buildingNumber();
        this.houseExNumber = faker.bothify("??");

        this.address = format("%s %s, %s, к %s", this.streetName, streetType, houseNumber, houseExNumber);
    }


    public String getStreetName() {
        return streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getHouseExNumber() {
        return houseExNumber;
    }

    public String getAddress() {
        return address;
    }
}
