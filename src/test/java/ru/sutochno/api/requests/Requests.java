package ru.sutochno.api.requests;


import ru.sutochno.api.models.AdvertisementChangeResponse;
import ru.sutochno.api.models.ObjectProperties;
import ru.sutochno.api.models.NewAdvertisement;

import java.io.File;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    public void moveToArchive(String authCookie, String objectId) {
        given()
                .spec(requestSpecObjects)
                .cookie("_me_", authCookie)
                .formParam("objectId", objectId)
        .when()
                .log().body()
                .post("/updateObjectStop")
        .then()
                .spec(responseSpec)
                .body(    "success", is(true))
                .body(    "data.status", hasToString(objectId));
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

    public AdvertisementChangeResponse setProperties(String authCookie, ObjectProperties requestBody)  {
        AdvertisementChangeResponse advertisementChangeResponse;
        return advertisementChangeResponse =
                given()
                        .spec(requestSpecObjects)
                        .cookie("_me_", authCookie)
                        .body(requestBody)
                        .contentType(JSON)
                .when()
                        .post("/setProperties")
                .then()
                        .spec(responseSpec)
                        .extract().as(AdvertisementChangeResponse.class);
    }

    public void uploadPhotos(String authCookie, String objectId, File image){

        ArrayList<String> fileName =
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
                    .body("success", is(true))
                    .extract().body().path("data.files.fileName");

        assertEquals(image.getName(), fileName.get(0));
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
                .contentType(JSON)
        .when()
                .formParam("value", disValue)
                .formParam("days", disDays)
                .formParam("type", disType)
                .formParam("currencyId", currency)
                .formParam("objectId", discountId)
                .post("/editDiscountById")
        .then()
                .spec(responseSpec)
                .body("success", is(true))
                .body("data.discounts.id", hasToString(discountId));
        }

    public void setPrices(String authCookie, String objectId, String  pricesParams)  {

        ArrayList<String> actions =
        given()
                .spec(requestSpecObjects)
                .header("api-version", 1.7)
                .cookie("_me_", authCookie)
                .contentType(JSON)
        .when()
                .param("objectId", objectId)
                .param("params", pricesParams)
                .get("/setObjectPrices")
        .then()
                .spec(responseSpec)
                .body("success", is(true))
                .body("data.object_id", hasToString(objectId))
                .extract().body().path("actions");

        assertEquals("Objects price is updated", actions.get(0));
    }


    public void setAddress(String authCookie, String objectId,  String streetType, String streetName,String houseNumber, String houseExNumber, String lat, String  lng) {

        given()
                .spec(requestSpecObjects)
                .header("accept","application/json, text/plain, */*")
                .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("content-type","multipart/form-data;  boundary=----WebKitFormBoundarySQveeHXAjzfYkC1e")
                .log().all()
                .cookie("_me_", authCookie)
        .when()
//                .body("------WebKitFormBoundarySQveeHXAjzfYkC1e\\r\\nContent-Disposition: form-data; name=\"objectId\"\\r\\n\\r\\n1236339\\r\\n------WebKitFormBoundarySQveeHXAjzfYkC1e\\r\\nContent-Disposition: form-data; name=\"data[location][stype]\"\\r\\n\\r\\nулица\\r\\n------WebKitFormBoundarySQveeHXAjzfYkC1e\\r\\nContent-Disposition: form-data; name=\"data[location][street]\"\\r\\n\\r\\nlenina\\r\\n------WebKitFormBoundarySQveeHXAjzfYkC1e\\r\\nContent-Disposition: form-data; name=\"data[location][house]\"\\r\\n\\r\\n55\\r\\n------WebKitFormBoundarySQveeHXAjzfYkC1e\\r\\nContent-Disposition: form-data; name=\"data[location][korp]\"\\r\\n\\r\\n1b\\r\\n------WebKitFormBoundarySQveeHXAjzfYkC1e--\\r\\n")
                .multiPart("objectId", objectId)
                .multiPart("data[location][stype]", streetType)
                .multiPart("data[location][street]", streetName)
                .multiPart("data[location][house]", houseNumber)
                .multiPart("data[location][korp]", houseExNumber)
                .multiPart("data[location][lat]", lat)
                .multiPart("data[location][lng]", lng)
                .post("/editObject")
        .then()
//                .spec(responseSpec)
                .log().all()
                .body("success", is(true))
                .body("data.object_id", hasToString(objectId));
    }

    public void setAddress(String authCookie, String objectId,  String streetType, String streetName) {
        given()
                .spec(requestSpecObjects)
                .header("accept", "application/json, text/plain, */*")
                .cookie("_me_", authCookie)
                .formParam("objectId", objectId)
                .formParam("data[location][stype]", streetType)
                .formParam("data[location][street]", streetName)
                .when()
                .log().body()
                .post("/editObject")
                .then()
                .spec(responseSpec)
                .body(    "success", is(true))
                .body(    "data.object_id", hasToString(objectId));
    }


}
