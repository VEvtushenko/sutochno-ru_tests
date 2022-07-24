package ru.sutochno.api.requests;


import io.restassured.http.ContentType;
import ru.sutochno.api.models.AdvertisementChangeResponse;
import ru.sutochno.api.models.SetProperties;
import ru.sutochno.api.models.NewAdvertisement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static ru.sutochno.api.specifications.Specs.*;

public class Requests {

    public String  getAuth(String userPhone, String userPassword) {
        return given()
                .spec(requestSpecUser)
                .formParam("value", userPhone)
                .formParam("password", userPassword)
        .when()
                .post("/auth")
        .then()
                .spec(responseSpec)
                .body("data.messages.already", hasToString("Вы уже зарегистрированы в системе"))
                .extract().response()
                .getCookie("_me_");
    }

    public void moveToArchive(String advertisementId, String authCookie) {
        given()
                .spec(requestSpecObjects)
                .cookie("_me_", authCookie)
                .formParam("objectId", advertisementId)
        .when()
                .log().body()
                .post("/updateObjectStop")
        .then()
                .spec(responseSpec)
                .body(    "success", is(true))
                .body(    "data.status", hasToString(advertisementId));
    }

    public NewAdvertisement  addAdvertisement(String authCookie) {
        NewAdvertisement newAdvertisement;
        return newAdvertisement =
            given()
                    .spec(requestSpecObjects)
                    .cookie("_me_", authCookie)
                    .formParam("data[type_id]", 1)
                    .formParam("data[location][city_id]", 332819)
            .when()
                    .post("/addObject")
            .then()
                    .spec(responseSpec)
                    .extract().as(NewAdvertisement.class);
    }

    public AdvertisementChangeResponse changeObjectGeneralInfo(String authCookie, SetProperties requestBody)  {
        AdvertisementChangeResponse advertisementChangeResponse;
        return advertisementChangeResponse =
                given()
                        .spec(requestSpecObjects)
                        .cookie("_me_", authCookie)
                        .body(requestBody)
                        .contentType(ContentType.JSON)
                .when()
                        .post("/setProperties")
                .then()
                        .spec(responseSpec)
                        .extract().as(AdvertisementChangeResponse.class);
    }

}
