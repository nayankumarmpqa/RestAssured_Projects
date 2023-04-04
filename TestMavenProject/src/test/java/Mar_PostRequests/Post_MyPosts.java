package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import pojo.Post_Payloads_Pojo;

import static io.restassured.RestAssured.given;

public class Post_MyPosts {

    //---------------- API call using Pojo class objects which is used to create dynamic payloads
    public static void main(String[] args) {

        Post_Payloads_Pojo myPojoObj = new Post_Payloads_Pojo();
        myPojoObj.setTitle("NK");
        myPojoObj.setBody("MyBody");
        myPojoObj.setUserId(87);

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(myPojoObj)
                .when()
                .post("/posts")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(3000L))
                .extract().response();

        //Assert.assertEquals(response.jsonPath().getString("title"), "Nayan");
        // or we can use pojo class getter methods to get value in the assertions
        Assert.assertEquals(response.jsonPath().getString("title"), myPojoObj.getTitle());

        Assert.assertEquals(response.jsonPath().getInt("id"), 101);


    }

    //------------------------------------- API call using direct string in the request body
    public static void main2(String[] args) {

        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": \"1\" \n}";

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("/posts")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(3000L))
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("title"), "foo");


        Assert.assertEquals(response.jsonPath().getInt("id"), 101);
    }


//------------- OR API call using request body string returned by the payload class method with parameters

    public static void main3(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = given()
                .log().uri()
                .contentType(ContentType.JSON)
                // we can call method from Payloads class
                .body(Post_Payloads.myPostRequestBody("Nayan", "bar"))

                .when()
                .post("/posts")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(3000L))
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("title"), "Nayan");

        Assert.assertEquals(response.jsonPath().getInt("id"), 101);


    }
}