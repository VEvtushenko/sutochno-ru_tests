package ru.sutochno.tests.api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.sutochno.api.models.ChangeProperties;
import ru.sutochno.api.models.NewAdvertisement;
import ru.sutochno.config.Project;

import static com.codeborne.selenide.Selenide.open;
import static ru.sutochno.data.Data.AUTH_COOKIE;


public class SutochnoApiTests extends TestBase {
    @Test
    void makeAdvertisementApiTest() {
        requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    }

    @Test
    @Tag("apiTests")
    String addNewAdvertisement() {
        NewAdvertisement newAdvertisement = requests.addAdvertisement(AUTH_COOKIE);
        return newAdvertisement.getData().getObject_id();
    }

    @Test
    void moveAdvertisementToArchive(String advertisementId) {
        requests.moveToArchive(advertisementId, AUTH_COOKIE);
    }

    @Test
    void tested() {
        ChangeProperties changeProperties = new ChangeProperties();
        changeProperties.setObjectId(1212637);
//        generalInfoRequest.setProperties);
    }

    //todo negative discount test
}