package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_user_createWithArray {
    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
String requestBody= "[\n" +
        "  {\n" +
        "    \"id\": 10,\n" +
        "    \"username\": \"Nayan\",\n" +
        "    \"firstName\": \"Kumar\",\n" +
        "    \"lastName\": \"Kumar\",\n" +
        "    \"email\": \"mpqa@gmail.com\",\n" +
        "    \"password\": \"t3stf1rst\",\n" +
        "    \"phone\": \"869784512\",\n" +
        "    \"userStatus\": 10\n" +
        "  }\n" +
        "]";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(requestBody)
            .when()
                .post("/user/createWithArray")
            .then()
                .log().all()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .body("message", equalTo("ok"))
                .time(Matchers.lessThan(4500L))
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("type"), "unknown");
    }
}
