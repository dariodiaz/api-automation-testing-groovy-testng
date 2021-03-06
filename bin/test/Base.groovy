package groovy

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;


class Base {
    @BeforeClass
    public static void setupRestAssured() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com"
        //RestAssured.basePath = "/api/"
        RequestSpecification requestSpec = new RequestSpecBuilder().
                addHeader("Content-Type", ContentType.JSON.toString()).
                addHeader("Accept", ContentType.JSON.toString()).
                build()
        RestAssured.requestSpecification = requestSpec
    }

}