package ru.sutochno.api.requests;

import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasToString;
import static ru.sutochno.api.specifications.Specs.requestSpecUser;
import static ru.sutochno.api.specifications.Specs.responseSpecUser;

public class Requests {
    String token = "Hy6U3z61fflbgT2yJ/VdlQ2719";
    public Cookie getAuth(String userPhone, String userPassword) {
        Cookie authCookie = new Cookie("_me_",
                given()
                        .spec(requestSpecUser)
                        .header("token", token)
                        .formParam("value", userPhone)
                        .formParam("password", userPassword)
                .when()
                        .post("/auth")
                .then()
                        .spec(responseSpecUser)
                        .body("data.messages.already", hasToString("Вы уже зарегистрированы в системе"))
                        .extract().response()
                        .getCookie("_me_"));
            return authCookie;
    }
}
