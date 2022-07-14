package ru.sutochno.data;

import org.openqa.selenium.Cookie;
import ru.sutochno.api.requests.Requests;
import ru.sutochno.config.Project;
import ru.sutochno.pages.MainPage;
import ru.sutochno.pages.Promo;


public class Data {
    public static MainPage mainPage = new MainPage();
    public static Promo promoPage = new Promo();
    public static Requests requests = new Requests();

    public static String promoUrl = "https://promo.sutochno.ru";
    public static Cookie authCookie = requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
}
