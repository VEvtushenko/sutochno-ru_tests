package ru.sutochno.tests.api;

import org.junit.jupiter.api.Test;
import ru.sutochno.config.Project;



public class SutochnoApiTests extends TestBase {
    @Test
    void makeAdvertisementApiTest() {
        requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    }

    @Test
    void moveAdvertisementToArchive() {
//        mainPage
//                .authorization(new Cookie("_me_", authCookie), Project.config.userName());
        String moveAuthCookie = requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
        requests.moveToArchive1("1211137", moveAuthCookie);
    }

}
