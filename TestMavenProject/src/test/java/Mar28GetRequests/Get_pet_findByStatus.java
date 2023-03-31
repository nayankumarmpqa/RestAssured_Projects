package Mar28GetRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_pet_findByStatus {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response resp = given()
                .log().all()
                .header("accept", "application/json")
                .queryParam("status", "available")
            .when()
                .get("/pet/findByStatus")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .header("Content-Type", "application/json")
                .body("category.name[0]", equalTo("monkey"))
                .time(Matchers.lessThan(3500L))
                .extract().response();

       Assert.assertEquals((resp.jsonPath().getString("name[43]")),"doggie");

    }
}
