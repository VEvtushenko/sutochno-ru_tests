package ru.sutochno.data;

import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.util.Random;


public class Data {

    Random random = new Random();

    private  String[] getTextStrings(String fileName)  {
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


    private  String getTextString(String fileName)  {
        try {
            return new String((Files.readAllBytes(Paths.get(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
            return new String("");
        }
    }

    private Integer[] getFollowingIntArray(int max)  {
        Integer[] intArray = new Integer[max];
        for (int i = 0; i < max; i++) {
            intArray[i] = i + 1;
        }
        return intArray;
    }


    public static Requests requests = new Requests();

    public static String promoUrl = "https://promo.sutochno.ru";
    public static final String AUTH_COOKIE =  requests.getAuth(Project.config.userPhone(), Project.config.userPassword());

//    todo api address
//    todo адресные переменные
    public String[] typeOfSpace = new String[] {"Апартамент"};
    public String[] country = new String[] {"Беларусь"};
    public String[] region = new String[] {"Брестская область"};
    public String[] city = new String[] {"Брест"}; // todo [][] by region
    public String[] streetType = getTextStrings("src/test/resources/data/streetType.txt");
    public String streetName = "Ленина";
    public String houseNumber = "12";
    public String houseExNumber = "А";
    public Integer maxGuests = 5;
    public Integer numberOfRooms = 4;
    public Integer numberOfBedrooms = 2;
    public Integer numberOfBeds = 3  /* + AddAdvertisementInfo.getCount()*/;
    public String[] typeOfBeds;
    public Integer cntBathroomsToilet = 1;
    public Integer cntBathrooms = 0;
    public Integer cntToilets = 1;
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
    public Integer[] minNights = getFollowingIntArray(30);
    public Integer[] childrenAge = getFollowingIntArray(17);
    public String[] checkTime = new String[] {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
//    public String[] checkOutTime = new String[] {"16:00"};
//    public String[] additionalServices = getTextStrings("");
    public String[] checkInEarly = new String[] {"0", "2", "3"};
    public String[] checkOutEarly = new String[] {"0", "2", "3"};

    public Integer squareOfFlat = random.nextInt(500);

    public Integer floor = 5;
    public boolean isAttic = true;
    public Integer maxFloor = 12;
    public boolean isElevator = true;
    public String photo1 = "src/test/resources/images/1.jpeg";
    public String photo2 = "src/test/resources/images/2.jpeg";
    public String photo3 = "src/test/resources/images/3.jpg";
    public String nameObject = "В Бресте на бульваре";
    public String selfNumberObject = "Квартира в Бресте";
    public String description = "Брест, квартира, бульвар Ленина";
    public boolean withChildren = true;
    public boolean withPets = true;
    public boolean smokingBoolean = false;
    public boolean partyBoolean = true;
    public boolean quickBooking = true;
    public Integer costPerDay = 3000;
    public Integer amountOfGuestsForCost = 1;
    public Integer exGuestPrice = 2000;
    public Integer cleaningCost = 10;
    public Integer deposit = 30000;
    public String transferTerm = "Transfer term";
    public Integer checkMainData = 3000;
    public String judgmentText = getTextString("src/test/resources/data/judgmentText.txt");
    public Integer beforeDays = random.nextInt(5)*30;
    public Integer beforeHours = random.nextInt(23) + 1;
    public String[] documents = new String[] {"0", "2", "3"};
    public  Integer gethering = random.nextInt(5000);
    public String[] isChildren = new String[] {"0", "2", "1"};
    public String[] party = new String[] {"0", "2", "1"};
    public String[] pets = new String[] {"0", "2", "1"};
    public String[] qualityRepair = new String[] {"-10", "0", "1", "2", "3"};
    public String[] smoking = new String[] {"0", "1", "3"};
    public String[] kitchenFlat = new String[] {"-1", "0", "1", "2", "3"};

}
