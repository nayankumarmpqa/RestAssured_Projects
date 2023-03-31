package Mar28GetRequests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUser_PetStore {

    public static void main(String[] args) {

        RestAssured.baseURI="https://petstore.swagger.io/v2";

        given()
                .log().all()
                .header("Content-Type","application/json")
        .when()
                .get("/user/user1")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .header("content-type", "application/json")
                .body("id",equalTo(100))
                .header("Server","Jetty(9.2.9.v20150224)");

    }
}
