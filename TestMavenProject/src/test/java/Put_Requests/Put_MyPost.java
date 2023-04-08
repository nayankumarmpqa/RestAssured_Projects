package Put_Requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class Put_MyPost {

    public static void main(String[] args) {

        RequestSpecification rsb = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                        .expectResponseTime(Matchers.lessThan(3000L))
                                .expectStatusCode(200)
                                        .build();

        Pojo payload = new Pojo();
        payload.setTitle("Nayan");
        payload.setBody("bodytext");
        payload.setUserId(87);
        payload.setId(88);

        Pojo pojo = given().spec(rsb)
                .body(payload)
                .when()
                .put("/posts/1")
                .then().spec(responseSpecification).extract().response().as(Pojo.class);

        System.out.println(pojo.toString());
        System.out.println(pojo.getId());
        Assert.assertEquals(pojo
                .getUserId(),payload.getUserId() );

        System.out.println(pojo.getTitle().equals(payload.getTitle()));
    }


}
