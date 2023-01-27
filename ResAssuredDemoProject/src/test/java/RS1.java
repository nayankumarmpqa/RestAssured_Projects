import PayloadFiles.AddPlacePayload;
import PayloadFiles.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class RS1 {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";

       String resp =  given().log().all()
                .header("key", "qaclick123")
                .header("Content-Tyope", "application/json")
                .body(AddPlacePayload.addPlacePayloadString())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()

                    .assertThat()
                    .statusCode(200)
                    .body("scope", equalTo("APP"))
                    .header("server", "Apache/2.4.41 (Ubuntu)")
               .extract().response().asString();


        System.out.println("Printing response -------------------- Start:");
        System.out.println(resp);
        System.out.println("Printing response -------------------- End:");

        JsonPath jsobj1 = new JsonPath(resp);
        String placeId= jsobj1.getString("place_id");
        System.out.println("The place ID in response is = "+ placeId);


        //PUT Place API
String newAddress = "65-a Mohali, USA";

        given()
                .header("key", "qaclick123")
                .header("Content-Tyope", "application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        // Get place API

       String getResponse = given()
                .queryParam("key", "qaclick123")
                .queryParam("place_id",placeId)

                .when()
                .get("/maps/api/place/get/json")

                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsobj2 = ReusableMethods.responseStringToJsonObj(getResponse);
        String actualAddress = jsobj2.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(newAddress, actualAddress );
    }
}
