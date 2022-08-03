package ru.sutochno.data.adverticement;

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
