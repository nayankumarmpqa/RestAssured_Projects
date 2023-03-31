package Mar28GetRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_storeInventory {
    public static void main(String[] args) {

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        Response response= given()
                .log().all()
                .contentType(ContentType.JSON)
            .when()
                .get("/store/inventory")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("string", equalTo(810))
                .extract().response();

        Assert.assertEquals(response.jsonPath().getInt("pending"), 8);


    }
}
