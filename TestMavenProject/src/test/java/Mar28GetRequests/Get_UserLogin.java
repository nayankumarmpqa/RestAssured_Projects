package Mar28GetRequests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_UserLogin {
    public static void main(String[] args) {
        RestAssured.baseURI= "https://petstore.swagger.io/v2";

        given()
                .log().all()
                .header("accept", "application/json")
                .queryParam("username", "testusername")
                .queryParam("password", "testpassword")
        .when()
                .get("/user/login")
        .then()
                .log().all()
                .assertThat()
                    .statusCode(200)
                .body("code", equalTo(200))
                .header("Content-Type", "application/json")
                .header("Server","Jetty(9.2.9.v20150224)");

    }

}
