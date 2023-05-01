import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {
        // validate add place api
        //given - inputd
        // when - method(andResourceName)
        // then - validate response
        System.out.println("Praise the Lord");

       // addPlace API
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String addPlaceResponse = given()
                //.log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(files.Payloads.addPlacePayload())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();


        JsonPath jsobj1 = new JsonPath(addPlaceResponse);
        String addedPlace_id = jsobj1.getString("place_id");
        System.out.println(addedPlace_id);


        //Put place API
        String newAddress = "65-A Mohali";
        String putPlaceResponse = given().log().all()
                .header("Content-Type", "application/json")
                .queryParam("key", "qaclick123")
                .body("{\n" +
                        "\"place_id\":\""+addedPlace_id+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("msg",equalTo("Address successfully updated"))
                .extract().response().asString();


        //Get Place API

        String getApiresponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", addedPlace_id)

                .when()
                .get("/maps/api/place/get/json")

                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        //JsonPath getApiJsonObject = new JsonPath(getApiresponse);
        JsonPath getApiJsonObject =ReusableMethods.responseStringToJsonObj(getApiresponse);
        String actualAddress = getApiJsonObject.getString("address");

        Assert.assertEquals(newAddress, actualAddress);



        Response getApiresponse2 = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", addedPlace_id)

                .when()
                .get("/maps/api/place/get/json");
        System.out.println(getApiresponse2.toString());
        System.out.println("**********************");
        System.out.println(getApiresponse2.statusCode());
        System.out.println(getApiresponse2.asString());




    }

}
