package Mar28;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_PetbyID {
    public static void main(String[] args) {
        baseURI="https://petstore.swagger.io/v2";

        Response resp = given()
                .log().all()
                .contentType(ContentType.JSON)
            .when()
                .get("/pet/64")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .header("Content-Type", "application/json")
                .body("category.name", equalTo("Mensachtig"))
                .time(Matchers.lessThan(3000L))
                .extract().response();
        Assert.assertEquals(resp.jsonPath().getString("category.name"), "Mensachtig");


    }
}
