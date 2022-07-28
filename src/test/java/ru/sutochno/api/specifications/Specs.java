package ru.sutochno.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.sutochno.config.Project;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static ru.sutochno.helpers.ApiListener.withCustomTemplates;

public class Specs {

    private static final String TOKEN = Project.config.siteToken();

    public static RequestSpecification requestSpecUser =
            with()
                    .filter(withCustomTemplates())
                    .header("token", TOKEN)
                    .basePath("/api/json/users")
                    .baseUri("https://sutochno.ru")
                    .accept("application/json; charset=UTF-8");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectContentType(ContentType.JSON)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification requestSpecObjects =
            with()
                    .log().body()
                    .filter(withCustomTemplates())
                    .header("token", TOKEN)
                    .basePath("/api/json/objects")
                    .baseUri("https://sutochno.ru");
}
