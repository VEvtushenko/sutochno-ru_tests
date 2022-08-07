package ru.sutochno.data;

import com.github.javafaker.Faker;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.base.domain.prices.Price;
import ru.sutochno.config.Project;
import ru.sutochno.helpers.RandomUtils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;

import static java.lang.String.format;


public class Data {

    private Random random = new Random();
    private RandomUtils randomUtils = new RandomUtils();
    private static Requests requests = new Requests();
    public String promoUrl = "https://promo.sutochno.ru";
    public static final String AUTH_COOKIE =  requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    private Faker faker = new Faker(new Locale("RU", "RUS"));


    private  String getTextString(String fileName)  {
        try {
            return new String((Files.readAllBytes(Paths.get(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    private String setPrices(Price price, String pricePerPerson, String includedPersons, String checkIn, String checkOut) {
        return format(getTextString("src/test/resources/data/requests/set_prices_params.txt"),
                price.getPrice(), price.getCurrency(), price.getGethering(), price.getDeposit(), pricePerPerson, includedPersons, checkIn, checkOut);
    }

    public String judgmentText = getTextString("src/test/resources/data/judgmentText.txt");

    public String[] typeOfSpace = new String[] {"Апартамент"};
    public String[] country = new String[] {"Беларусь"};
    public String[] region = new String[] {"Брестская область"};
    public String[] city = new String[] {"Брест"};

//    public String streetType = streetTypeArray[random.nextInt(streetTypeArray.length)];

//    public String streetName = faker.animal().name();
//    public Integer houseNumber = random.nextInt(50) + 1;
//    public String houseExNumber = faker.bothify("??");

// MainInfo   public Integer maxGuests = random.nextInt(6) + 2;
// MainInfo   public Integer numberOfRooms = random.nextInt(9) + 1;
// MainInfo   public Integer numberOfBedrooms = random.nextInt(numberOfRooms);
// MainInfo   public Integer numberOfBeds = 3  /* + AddAdvertisementInfo.getCount()*/;

// Sanitation   public Integer cntBathroomsToilet = random.nextInt(2);
// Sanitation   public Integer cntBathrooms = random.nextInt(2);
// Sanitation   public Integer cntToilets = random.nextInt(2);

//    public String[] bathroomEquipmentsSource = getTextStrings("src/test/resources/data/convenciesInBathrooms.txt");
//    public Map<String, Boolean> bathroomEquipments = setMapBoolean(bathroomEquipmentsSource);

//    public String[] homeFacilitiesSource = getTextStrings("src/test/resources/data/homeFcilities.txt");
//    public Map<String, Boolean> homeFacilities = setMapBoolean(homeFacilitiesSource);
//
//    public String[] viewSource = getTextStrings("src/test/resources/data/views.txt");
//    public Map<String, Boolean> view = setMapBoolean(viewSource);

//    public String[] kitchenEquipmentsSource = getTextStrings("src/test/resources/data/kitchenEquipments.txt");
//    public Map<String, Boolean> kitchen = setMapBoolean(kitchenEquipmentsSource);
//
//    public String[] houseEquipmentsSource = getTextStrings("src/test/resources/data/houseEquipments.txt");
//    public Map<String, Boolean> houseEquipments = setMapBoolean(houseEquipmentsSource);
//
//    public String[] restEquipmentsSource = getTextStrings("src/test/resources/data/restEquipments.txt");
//    public Map<String, Boolean> restEquipments = setMapBoolean(restEquipmentsSource);
//
//    public String[] yardEquipmentsSource = getTextStrings("src/test/resources/data/yardEquipments.txt");
//    public Map<String, Boolean> yardEquipments = setMapBoolean(yardEquipmentsSource);
//
//    public String[] childrenEquipmentsSource = getTextStrings("src/test/resources/data/childrenEquipments.txt");
//    public Map<String, Boolean> childrenEquipments = setMapBoolean(childrenEquipmentsSource);

//    public String[] bookingGap = getTextStrings("");
//    public String[] bookingDuration = getTextStrings("");
//    public String[] currencyPay = getTextStrings("");
    public Integer minNights = new Random().nextInt(30);
//    public String[] checkOutTime = new String[] {"16:00"};
//    public String[] additionalServices = getTextStrings("");
    public String[] checkInEarly = new String[] {"0", "2", "3"};
    public String[] checkOutEarly = new String[] {"0", "2", "3"};

// MainInfo    public Integer squareOfFlat = randomUtils.getInt(100, 500);

// MainInfo   public Integer floor = random.nextInt(40) + 1;
// MainInfo   public Integer maxFloor = randomUtils.getInt(floor, 41);
// MainInfo   public boolean isAttic = true;
// MainInfo   public boolean isElevator = true;

    public String photo1 = "src/test/resources/images/1.jpeg";
    public String photo2 = "src/test/resources/images/2.jpeg";
    public String photo3 = "src/test/resources/images/3.jpg";

    public String nameObject = faker.funnyName().name();
    public String selfNumberObject = faker.rockBand().name();
    public String description = faker.address().fullAddress();

//    public boolean transfer = random.nextBoolean();
//    public String transferTerm = "Transfer term";

    public boolean withChildren = true;
    public final String[] isChildrenArray = new String[] {"0", "2", "1"};
    public String isChildren = isChildrenArray[random.nextInt(isChildrenArray.length)];
    public Integer childrenAge = random.nextInt(17);

    public boolean partyBoolean = true;
    public final String[] partyArray = new String[] {"0", "2", "1"};
    public String party = partyArray[random.nextInt(partyArray.length)];

    public boolean withPets = true;
    public final String[] petsArray = new String[] {"0", "2", "1"};
    public String pets = petsArray[random.nextInt(petsArray.length)];

    public boolean smokingBoolean = false;
    public final String[] smokingArray = new String[] {"0", "1", "3"};
    public String smoking = smokingArray[random.nextInt(smokingArray.length)];

//    //    public String[] qualityRepairString = getTextStrings("");
//    public final String[] qualityRepairArray = new String[] {"-10", "0", "1", "2", "3"};
//    public String qualityRepair = qualityRepairArray[random.nextInt(qualityRepairArray.length)];
//
//    //    public String[] kitchenFlatString = getTextStrings("");
//    public final String[] kitchenFlatArray = new String[] {"-1", "0", "1", "2", "3"};
//    public String kitchenFlat = kitchenFlatArray[random.nextInt(kitchenFlatArray.length)];

    public final String[] checkTime = new String[] {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00",
                                              "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
                                              "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    public String checkIn = checkTime[random.nextInt(checkTime.length)];
    public String checkOut = checkTime[random.nextInt(checkTime.length)];

    public final String[] documentsArray = new String[] {"0", "2", "3"};
    public String documents = documentsArray[random.nextInt(documentsArray.length)];

//    public Integer checkMainData = 3000;
//    public boolean quickBooking = true;
    public Integer costPerDay = randomUtils.getInt(10000, 100000);
//    public Integer amountOfGuestsForCost = random.nextInt(maxGuests-1) + 1;
    public Integer exGuestPrice = random.nextInt(costPerDay);
    public Integer deposit = random.nextInt(100000);

    public Integer beforeDays = random.nextInt(5)*30;
    public Integer beforeHours = random.nextInt(23) + 1;
//    public Integer gethering = random.nextInt(5000);
//    private String[] currencyNumbers = getTextStrings("src/test/resources/data/currency_values.txt");
//    public String currency = currencyNumbers[random.nextInt(currencyNumbers.length)];
//    public Map<String, String> currencyNames = setMapString(currencyNumbers, getTextStrings("src/test/resources/data/currency_names.txt"));
//    public Map<String, String> currencySymbols = setMapString(currencyNumbers, getTextStrings("src/test/resources/data/currency_symbols.txt"));

//    Price price = new Price(costPerDay.toString(), currency, gethering.toString(), deposit.toString());
    //    public String prices = setPrices(price, exGuestPrice.toString(), amountOfGuestsForCost.toString(), checkIn, checkOut);

}
