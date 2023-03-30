package Mar28;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Get_MyComments {
    public static void main(String[] args) {

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .queryParam("postId", "2")
        .when()
                .get("/comments")
        .then()
                .log().all()
                .assertThat().statusCode(200);


    }
}
