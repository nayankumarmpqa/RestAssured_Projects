package Mar28GetRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get_MyPosts {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response=
                            given()
                                    .log().all()
                                    .header("Connection","keep-alive")
                                    .contentType(ContentType.JSON)
                            .when()
                                    .get("/posts")
                            .then()
                                    .log().all()
                                    .assertThat().statusCode(200)
                                    .body("title[0]", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                                    .header("Server","cloudflare" )
                                    .time(Matchers.lessThan(4000L))
                                    .extract().response();


        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
}
