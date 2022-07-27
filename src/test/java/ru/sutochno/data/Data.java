package ru.sutochno.data;

import com.github.javafaker.Faker;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;
import ru.sutochno.helpers.RandomUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;


public class Data {

    Random random = new Random();
    RandomUtils randomUtils = new RandomUtils();
    static Requests requests = new Requests();
    public static String promoUrl = "https://promo.sutochno.ru";
    public static final String AUTH_COOKIE =  requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    private Faker faker = new Faker(new Locale("RU", "RUS"));


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

    private Map<String, Boolean> setMapBoolean(String[] source) {
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < source.length; i++) {
            map.put(source[i], random.nextBoolean());
        }
        return map;
    }

    private Map<String, String> setMapString(String[] sourceData, String[] paramsName) {
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < sourceData.length; i++) {
            map.put(paramsName[i], sourceData[i]);
        }
        return map;
    }

    public String[] typeOfSpace = new String[] {"Апартамент"};
    public String[] country = new String[] {"Беларусь"};
    public String[] region = new String[] {"Брестская область"};
    public String[] city = new String[] {"Брест"};

    public String[] streetTypeArray = getTextStrings("src/test/resources/data/streetType.txt");
    public String streetType = streetTypeArray[random.nextInt(streetTypeArray.length)];

    public String streetName = faker.address().streetName();
    public Integer houseNumber = random.nextInt(50);
    public String houseExNumber = faker.bothify("??");

    public Integer maxGuests = random.nextInt(7);
    public Integer numberOfRooms = random.nextInt(9);
    public Integer numberOfBedrooms = random.nextInt(4);
    public Integer numberOfBeds = 3  /* + AddAdvertisementInfo.getCount()*/;
    public String[] typeOfBeds;

    public Integer cntBathroomsToilet = random.nextInt(2);
    public Integer cntBathrooms = random.nextInt(2);
    public Integer cntToilets = random.nextInt(2);

    public String[] conveniencesInBathroom = getTextStrings("src/test/resources/data/convenciesInBathrooms.txt");

    public String[] homeFacilitiesSourse = getTextStrings("src/test/resources/data/homeFcilities.txt");

    public String[] viewSource = getTextStrings("src/test/resources/data/views.txt");
    public Map<String, Boolean> view = setMapBoolean(viewSource);

    public String[] kitchenEquipments = getTextStrings("src/test/resources/data/kitchenEquipments.txt");
    public Map<String, Boolean> kitchen = setMapBoolean(kitchenEquipments);


    public String[] houseEquipments = getTextStrings("src/test/resources/data/houseEquipments.txt");
    public String[] restEquipments = getTextStrings("src/test/resources/data/restEquipments.txt");
    public String[] yardEquipments = getTextStrings("src/test/resources/data/yardEquipments.txt");
    public String[] childrenEquipments = getTextStrings("src/test/resources/data/childrenEquipments.txt");
//    public String[] bookingGap = getTextStrings("");
//    public String[] bookingDuration = getTextStrings("");
//    public String[] currencyPay = getTextStrings("");
    public Integer[] minNights = getFollowingIntArray(30);
    public Integer[] childrenAge = getFollowingIntArray(17);
//    public String[] checkOutTime = new String[] {"16:00"};
//    public String[] additionalServices = getTextStrings("");
    public String[] checkInEarly = new String[] {"0", "2", "3"};
    public String[] checkOutEarly = new String[] {"0", "2", "3"};

    public Integer squareOfFlat = random.nextInt(500);

    public Integer floor = random.nextInt(40);
    public boolean isAttic = true;
    public Integer maxFloor = randomUtils.getInt(floor, 40);
    public boolean isElevator = true;

    public String photo1 = "src/test/resources/images/" +
            "1.jpeg";
    public String photo2 = "src/test/resources/images/2.jpeg";
    public String photo3 = "src/test/resources/images/3.jpg";

    public String nameObject = faker.funnyName().name();
    public String selfNumberObject = faker.rockBand().name();
    public String description = faker.address().fullAddress();

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
    public  Integer gethering = random.nextInt(5000);

    public boolean withChildren = true;
    public String[] isChildrenArray = new String[] {"0", "2", "1"};
    public String isChildren = isChildrenArray[random.nextInt(isChildrenArray.length)];

    public boolean partyBoolean = true;
    public String[] partyArray = new String[] {"0", "2", "1"};
    public String party = partyArray[random.nextInt(partyArray.length)];

    public boolean withPets = true;
    public String[] petsArray = new String[] {"0", "2", "1"};
    public String pets = petsArray[random.nextInt(petsArray.length)];

    public boolean smokingBoolean = false;
    public String[] smokingArray = new String[] {"0", "1", "3"};
    public String smoking = smokingArray[random.nextInt(smokingArray.length)];

    //    public String[] qualityRepairString = getTextStrings("");
    public String[] qualityRepairArray = new String[] {"-10", "0", "1", "2", "3"};
    public String qualityRepair = qualityRepairArray[random.nextInt(qualityRepairArray.length)];

    //    public String[] kitchenFlatString = getTextStrings("");
    public String[] kitchenFlatArray = new String[] {"-1", "0", "1", "2", "3"};
    public String kitchenFlat = kitchenFlatArray[random.nextInt(kitchenFlatArray.length)];

    public String[] checkTime = new String[] {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    public String checkIn = checkTime[random.nextInt(checkTime.length)];
    public String checkOut = checkTime[random.nextInt(checkTime.length)];

    public String[] documentsArray = new String[] {"0", "2", "3"};
    public String documents = documentsArray[random.nextInt(documentsArray.length)];

}
