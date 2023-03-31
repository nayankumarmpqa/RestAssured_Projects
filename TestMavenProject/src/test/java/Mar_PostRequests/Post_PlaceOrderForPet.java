package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_PlaceOrderForPet {
    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
String requestBody= "{\n" +
        "  \"id\": 1,\n" +
        "  \"petId\": 1,\n" +
        "  \"quantity\": 10,\n" +
        "  \"shipDate\": \"2023-03-31T19:25:21.543Z\",\n" +
        "  \"status\": \"placed\",\n" +
        "  \"complete\": true\n" +
        "}";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(requestBody)
            .when()
                .post("/store/order")
            .then()
                .log().all()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .body("status", equalTo("placed"))
                .time(Matchers.lessThan(4500L))
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("status"), "placed");
    }
}
