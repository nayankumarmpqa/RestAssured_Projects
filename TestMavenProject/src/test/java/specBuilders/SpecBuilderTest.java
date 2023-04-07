package specBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {

    public static void main(String[] args) {

        //How to Build Request Spec Builder
        RequestSpecification rspec = new RequestSpecBuilder()
                .setBaseUri("")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        // Example usage of request spec
        given().spec(rspec).body("").post()
                .then().extract().response();


        //How to Build Response Spec Builder
        ResponseSpecification resSpec = new ResponseSpecBuilder()
                .expectHeader("", "")
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(3000L))
                .expectContentType(ContentType.JSON)
                .build();
        // Example usage of response spec
        given().spec(rspec).body("").post()
                .then()
                .spec(resSpec).extract().response().asString();


    }
}
