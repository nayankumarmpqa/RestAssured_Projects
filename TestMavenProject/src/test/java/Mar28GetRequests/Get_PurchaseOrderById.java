package Mar28GetRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_PurchaseOrderById {

    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";

        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
            .when()
                .get("/store/order/9")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(9))
                .body("status", equalTo("placed"))
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("complete"), "false");

    }
}
