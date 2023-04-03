package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Post_MyPosts {

    public static void main(String[] args) {

        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": \"1\" \n}";

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
               // .body(requestBody)
                // Or we can call method from Payloads class
                .body(Post_Payloads.myPostRequestBody("Nayan", "bar"))
            .when()
                .post("/posts")
            .then()
                .log().body()
                .assertThat().statusCode(201)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(3000L))
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("title"), "Nayan");
        Assert.assertEquals(response.jsonPath().getInt("id"), 101);


    }
}
