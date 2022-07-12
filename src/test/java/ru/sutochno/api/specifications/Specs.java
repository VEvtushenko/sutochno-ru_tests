package ru.sutochno.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class Specs {

    public static RequestSpecification requestSpecUser =
            with()
                    .basePath("/api/json/users")
                    .baseUri("https://sutochno.ru")
                    .accept("application/json; charset=UTF-8");

    public static ResponseSpecification responseSpecUser = new ResponseSpecBuilder()
            .log(ALL)
            .expectContentType(ContentType.JSON)
            .expectStatusCode(200)
            .build();
}
