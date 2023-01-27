import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI="https://reqres.in/";
                given()
                .queryParam("page","2")
                .when()
                .get("api/users")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
