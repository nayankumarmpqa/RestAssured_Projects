package Mar28GetRequests;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Get_UserLogout {
    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";

        given()
                .log().all()
                .header("accept", "application/json")
                //no query params for this request
        .when()
                .get("/user/logout")
        .then()
                .log().all()
                .assertThat()
                        .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("ok"))
                .header("Content-Type", "application/json")
                .header("Server", "Jetty(9.2.9.v20150224)")
                .time(Matchers.lessThan(4000L))
               ;

    }
}
