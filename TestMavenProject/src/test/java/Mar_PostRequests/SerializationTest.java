package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SerializationTest {
    public static void main(String[] args) {

        RestAssured.baseURI="";

        Response response = given()
                .log().all()
                .queryParam("","")
                .body("")

                .when()
                .post("/maps/api/place/add/json")

                .then()
                .log().body()
                .assertThat().statusCode(200)
                .extract().response();

    }
}
