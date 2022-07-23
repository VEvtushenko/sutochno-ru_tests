package ru.sutochno.data;

import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;



public class Data {

    private static String[] getTextStrings(String fileName)  {
        try {
            List<String> text = new ArrayList((Files.readAllLines(Paths.get(fileName))));
            String[] stringsArray = new String[text.size()];
            for (int i = 0; i < text.size(); i++) {
                stringsArray[i] = text.get(i);
            }
            return stringsArray;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[] {""};
        }
    }


    private static String getTextString(String fileName)  {
        try {
            return new String((Files.readAllBytes(Paths.get(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
            return new String("");
        }
    }

    public static Requests requests = new Requests();

    public static String promoUrl = "https://promo.sutochno.ru";
    public static String authCookie =  requests.getAuth(Project.config.userPhone(), Project.config.userPassword());

//    todo api address
//    todo адресные переменные
    public String[] typeOfSpace = new String[] {"Апартамент"};
    public String[] country = new String[] {"Беларусь"};
    public String[] region = new String[] {"Брестская область"};
    public String[] city = new String[] {"Брест"}; // todo [][] by region
    public String[] streetType = getTextStrings("src/test/resources/data/streetName.txt");
    public String streetName = "Ленина";
    public String houseNumber = "12";
    public String houseExNumber = "А";
    public Integer maxGuests = 5;
    public Integer numberOfRooms = 4;
    public Integer numberOfBedrooms = 2;
// todo metod   public static Integer numberOfBeds = 2;
    public String[] typeOfBeds;
    public Integer bathroomsWithToilet = 1;
    public Integer bathroomsWithoutToilet = 0;
    public Integer toilets = 1;
    public String[] conveniencesInBathroom = getTextStrings("src/test/resources/data/convenciesInBathrooms.txt");
    public String[] homeFacilities = getTextStrings("src/test/resources/data/homeFcilities.txt");
//    public String[] typeOfKitchen= getTextStrings("");
//    public String[] typeOfRepairment = getTextStrings("");
    public String[] chooseView = getTextStrings("src/test/resources/data/views.txt");
    public String[] kitchenEquipments = getTextStrings("src/test/resources/data/kitchenEquipments.txt");
    public String[] houseEquipments = getTextStrings("src/test/resources/data/houseEquipments.txt");
    public String[] restEquipments = getTextStrings("src/test/resources/data/restEquipments.txt");
    public String[] yardEquipments = getTextStrings("src/test/resources/data/yardEquipments.txt");
    public String[] childrenEquipments = getTextStrings("src/test/resources/data/childrenEquipments.txt");
//    public String[] bookingGap = getTextStrings("");
//    public String[] bookingDuration = getTextStrings("");
//    public String[] currencyPay = getTextStrings("");
//    public String[] minimalPeriodOfResidence = getTextStrings("");
//    public String[] childrenAge = getTextStrings("");
    public String[] checkInTime = new String[] {"12:00"};
    public String[] checkOutTime = new String[] {"16:00"};
//    public String[] additionalServices = getTextStrings("");
    public Integer squareOfFlat = 120;
    public Integer floorOfFlat = 5;
    public boolean isAttic = true;
    public Integer numberOfFloors = 12;
    public boolean isElevator = true;
    public String photo1 = "src/test/resources/images/1.jpeg";
    public String photo2 = "src/test/resources/images/2.jpeg";
    public String photo3 = "src/test/resources/images/3.jpg";
    public String inputAdvertisementName = "В Бресте на бульваре";
    public String addUniqName = "Квартира в Бресте";
    public String inputAdvertisementDesc = "Брест, квартира, бульвар Ленина";
    public boolean withChildren = true;
    public boolean withPets = true;
    public boolean smoking = false;
    public boolean party = true;
    public boolean quickBooking = true;
    public Integer costPerDay = 3000;
    public Integer amountOfGuestsForCost = 1;
    public Integer exGuestPrice = 2000;
    public Integer cleaningCost = 10;
    public Integer depositAmount = 30000;
    public String transferTerm = "Transfer term";
    public Integer checkMainData = 3000;
    public String judgmentText = getTextString("src/test/resources/data/judgmentText.txt");
}
