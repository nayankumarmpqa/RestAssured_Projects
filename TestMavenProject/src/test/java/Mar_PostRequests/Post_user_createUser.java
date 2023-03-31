package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_user_createUser {
    public static void main(String[] args) {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
String requestBody= "{\n" +
        "  \"id\": 19,\n" +
        "  \"username\": \"Nayank87\",\n" +
        "  \"firstName\": \"Nayan\",\n" +
        "  \"lastName\": \"87\",\n" +
        "  \"email\": \"nayank87@gmail.com\",\n" +
        "  \"password\": \"t3stf1rst\",\n" +
        "  \"phone\": \"8699741245\",\n" +
        "  \"userStatus\": 19\n" +
        "}";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body(requestBody)
            .when()
                .post("/user")
            .then()
                .log().all()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .body("message", equalTo("19"))
                .time(Matchers.lessThan(4500L))
                .extract().response();
        Assert.assertEquals(response.jsonPath().getString("type"), "unknown");
    }
}
