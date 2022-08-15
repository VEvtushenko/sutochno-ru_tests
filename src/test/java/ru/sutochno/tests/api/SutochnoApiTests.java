package ru.sutochno.tests.api;

import org.junit.jupiter.api.Test;
import ru.sutochno.api.models.ObjectProperties;
import ru.sutochno.config.Project;



public class SutochnoApiTests extends TestBase {
    @Test
    void makeAdvertisementApiTest() {
        requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    }

//    @Test
//    @Tag("apiTests")
//    String addNewAdvertisement() {
//        NewAdvertisement newAdvertisement = requests.addAdvertisement(AUTH_COOKIE);
//        return newAdvertisement.getData().getObject_id();
//    }
//
//    @Test
//    void moveAdvertisementToArchive(String objectId) {
//        requests.moveToArchive(AUTH_COOKIE, objectId);
//    }

    @Test
    void tested() {
        ObjectProperties objectProperties = new ObjectProperties();
        objectProperties.setObjectId(1212637);
//        generalInfoRequest.setProperties);
    }

    //todo negative discount test
}