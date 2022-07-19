package ru.sutochno.tests.api;

import org.junit.jupiter.api.Test;
import ru.sutochno.api.models.GeneralInfoRequest;
import ru.sutochno.api.models.NewAdvertisement;
import ru.sutochno.config.Project;

import static ru.sutochno.data.Data.authCookie;

public class SutochnoApiTests extends TestBase {
    @Test
    void makeAdvertisementApiTest() {
        requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    }

    @Test
    String addNewAdvertisement() {
        NewAdvertisement newAdvertisement = requests.addAdvertisement(authCookie);
        return newAdvertisement.getData().getObject_id();
    }

    @Test
    void moveAdvertisementToArchive(String advertisementId) {
        requests.moveToArchive(advertisementId, authCookie);
    }

    @Test
    void tested() {
        GeneralInfoRequest generalInfoRequest= new GeneralInfoRequest();
        generalInfoRequest.setObjectId(1212637);
//        generalInfoRequest.setProperties);
    }
}
