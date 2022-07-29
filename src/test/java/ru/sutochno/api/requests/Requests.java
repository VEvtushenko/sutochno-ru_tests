package ru.sutochno.api.requests;


import io.restassured.http.ContentType;
import ru.sutochno.api.models.AdvertisementChangeResponse;
import ru.sutochno.api.models.ChangeProperties;
import ru.sutochno.api.models.NewAdvertisement;

import java.io.File;
import java.util.Map;

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

    public AdvertisementChangeResponse setProperties(String authCookie, ChangeProperties requestBody)  {
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

    public void uploadPhotos(String authCookie, String objectId, File image){
        given()
                .spec(requestSpec)
                .log().all()
                .header("api-version", 1.9)
                .cookie("_me_", authCookie)
                .when()
                .formParam("entity_id", objectId)
                .formParam("module_name", "objects")
                .multiPart("files[0]", image, "image/jpg")
                .post("mdatas/uploadPhotos")
                .then()
                .spec(responseSpec)
//                .body("", hasToString(""));
        ;
    }

    public void addDiscount(String authCookie, String objectId, String disValue, String disDays, String disType,
                            String currency)  {
        given()
//                .spec(requestSpecObjects)
                .header("api-version", 1.10)
                .cookie("_me_", authCookie)
                .header("token", "Hy6U3z61fflbgT2yJ/VdlQ2719")
//                .contentType(ContentType.JSON)
        .when()
                .formParam("value", disValue)
                .formParam("days", disDays)
                .formParam("type", disType)
                .formParam("currencyId", currency)
                .formParam("objectId", objectId)
                .post("https://sutochno.ru/api/json/objects/addDiscount")
        .then()
                .log().all();
//                .spec(responseSpec)
//                .body("success", is(true))
//                .body("data.discounts.object_id", hasToString(objectId));
    }

    public void editDiscount(String authCookie, String discountId, String disValue, String disDays, String disType,
                             String currency)  {
        given()
                .spec(requestSpecObjects)
                .cookie("_me_", authCookie)
                .contentType(ContentType.JSON)
        .when()
                .formParam("value", disValue)
                .formParam("days", disDays)
                .formParam("type", disType)
                .formParam("currencyId", currency)
                .formParam("objectId", discountId)
        .post("/addDiscount")
                .then()
                .spec(responseSpec)
                .body("success", is(true))
                .body("data.discounts.id", hasToString(discountId));
        }

    public void setPrices(String authCookie, String objectId, String  pricesParams)  {

        given()
                .spec(requestSpecObjects)
                .cookie("_me_", authCookie)
                .contentType(ContentType.JSON)
        .when()
                .get("/addDiscount?objectId=" + objectId + "&params=" + pricesParams)
        .then()
                .spec(responseSpec)
                .body("success", is(true))
                .body("actions", hasToString("Objects price is updated"));
    }

}
