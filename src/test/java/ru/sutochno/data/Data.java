package ru.sutochno.data;

import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;
import ru.sutochno.pages.MainPage;
import ru.sutochno.pages.Promo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Data {

    private String[] getTextStrings(String fileName) throws FileNotFoundException {
        List<String> text = new ArrayList();
        FileReader reader = new FileReader(fileName);

        //        return text;
    }

    public static MainPage mainPage = new MainPage();
    public static Promo promoPage = new Promo();
    public static Requests requests = new Requests();

    public static String promoUrl = "https://promo.sutochno.ru";
    public static String authCookie =  requests.getAuth(Project.config.userPhone(), Project.config.userPassword());

//    todo api address
//    todo адресные переменные
    public static String[] streetType = new String[] {"бульвар", "переулок", "улица", "проспект", "шоссе", "другое"};
    public static String streetName = "Ленина";
    public static String houseNumber = "12";
    public static String houseExNumber = "А";
    public static Integer maxGuests = 5;
    public static Integer numberOfRooms = 4;
    public static Integer numberOfBedrooms = 2;
// todo metod   public static Integer numberOfBeds = 2;
    public static String[] typeOfBeds;
    public static Integer bathroomsWithToilet = 1;
    public static Integer bathroomsWithoutToilet = 0;
    public static Integer toilets = 1;
    public static String[] conveniencesInBathroom =  new String[] {""};
    public static Integer squareOfFlat = 120;
    public static Integer floorOfFlat = 5;
    public static boolean isAttic = true;
    public static Integer numberOfFloors = 12;
    public static boolean isElevator = true;
    public static String[] typeOfKitchen;
    public static String[] typeOfRepairment;
    public static String[] homeFacilities;
    public static String[] chooseView;
    public static String[] kitchenEquipments;
    public static String[] houseEquipments;
    public static String[] restEquipments;
    public static String[] yardEquipments;
    public static String[] childrenEquipments;
    public static String photo1 = "src/test/resources/images/1.jpeg";
    public static String photo2 = "src/test/resources/images/2.jpeg";
    public static String photo3 = "src/test/resources/images/3.jpeg";
    public static String inputAdvertisementName = "В Бресте на бульваре";
    public static String addUniqName = "Квартира в Бресте";
    public static String inputAdvertisementDesc = "Брест, квартира, бульвар Ленина";
    public static String[] childrenAge;
    public static boolean withChildren = true;
    public static boolean withPets = true;
    public static boolean smoking = false;
    public static boolean party = true;
    public static String[] checkInTime = new String[] {"12:00"};
    public static String[] checkOutTime = new String[] {"16:00"};
    public static boolean quickBooking = true;
    public static String[] bookingGap;
    public static String[] bookingDuration;
    public static String[] currencyPay;
    public static String[] minimalPeriodOfResidence;
    public static Integer costPerDay = 3000;
    public static Integer amountOfGuestsForCost = 1;
    public static Integer exGuestPrice = 2000;
    public static String[] additionalServices;
    public static Integer cleaningCost = 10;
    public static Integer depositAmount = 30000;
    public static String transferTerm = "Transfer term";
    public static Integer checkMainData = 3000;












}
