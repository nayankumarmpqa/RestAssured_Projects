package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_AddAPet {
    public static void main(String[] args) {

        String requestBody= "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Hugo\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"pettagname\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RestAssured.baseURI="https://petstore.swagger.io/v2";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                //.body(requestBody)
                // OR we have another way to call payload form external class methods
                .body(Post_Payloads.AddAPetRequestBody())
            .when()
                .post("/pet")
            .then()
                .log().body()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(4000L))
                .body("category.name", equalTo("Hugo"))
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("status"), "available");
    }
}
