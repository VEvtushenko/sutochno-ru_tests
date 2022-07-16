package ru.sutochno.api.requests;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static ru.sutochno.api.specifications.Specs.*;
import static ru.sutochno.data.Data.authCookie;
import static ru.sutochno.helpers.ApiListener.withCustomTemplates;

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



    public void moveToArchive1(String advertisementId, String authCookie) {
        given()
                .log().body()
                .filter(withCustomTemplates())
                .header("token", "Hy6U3z61fflbgT2yJ/VdlQ2719")
//                .basePath("/api/json/objects")
//                .baseUri("https://sutochno.ru")
                .formParam("objectId", advertisementId)
                .cookie("_me_", authCookie)
        .when()
                .log().body()
                .post("https://sutochno.ru/api/json/objects/updateObjectStop")
        .then()
//                .spec(responseSpec)
                .body(    "success", is(true))
                .body(    "data.status", hasToString(advertisementId));
    }

}
