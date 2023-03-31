package Mar28GetRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_MyComments {
    public static void main(String[] args) {
//https://devqa.io/rest-assured-api-requests-examples/

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        Response resp = given()
                .log().all()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("postId", "2")
        .when()
                .get("/comments")
        .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("email[3]", equalTo("Meghan_Littel@rene.us"))
                .body("id[0]", equalTo(6))
                .extract().response();

        Assert.assertEquals("Meghan_Littel@rene.us", resp.jsonPath().getString("email[3]"));


    }
}
