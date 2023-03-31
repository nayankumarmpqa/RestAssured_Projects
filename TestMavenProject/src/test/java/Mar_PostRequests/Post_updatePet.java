package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Post_updatePet {

    public static void main(String[] args) {

        RestAssured.baseURI="https://petstore.swagger.io/v2";

        Response response = given()
                .log().all()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .accept("application/json")
                .formParam("name","Hugo")
                .formParam("status","spayed")

                    .post("/pet/11")
                .then()
                    .log().all()
                    .assertThat().statusCode(200)
                    .extract().response();

        Assert.assertEquals(response.jsonPath().getString("message"), "11");

    }
}
