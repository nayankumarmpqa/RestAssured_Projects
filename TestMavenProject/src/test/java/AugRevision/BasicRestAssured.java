package AugRevision;

import PayloadFilesPackage.PlacePayloads;
import PayloadFilesPackage.ResourceURLs;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class BasicRestAssured {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

    String addPlaceResponse =
        given().log().all()
                .queryParam("key", "qaclick123")
                .contentType("application/json")
                .header("Connection", "keep-alive")
                .body(PlacePayloads.AddPlacePayload())
        .when()
                .post("maps/api/place/add/json")
        .then().log().status()
                .assertThat() // making assertions below
                    .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Content-Type", "application/json;charset=UTF-8")
        .extract().asString(); // extracting response as String

        System.out.println(addPlaceResponse);

        //For parsing json response
        JsonPath jsonPath = new JsonPath(addPlaceResponse);
        //fetching place_Id in a string
        String place_Id =
                    jsonPath.getString("place_id");

        System.out.println("Place Id from response = " + place_Id);

//Put place API code
        String newAddress = "New floor apartment, USA";
        given().log().all()
                .contentType("application/json")
                .header("key", "qaclick123")
                .body(PlacePayloads.UpdatePlacePayload(place_Id, newAddress))
        .when()
                .put(ResourceURLs.putPlaceResource)
        .then()
                .log().status()
                .assertThat()
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));



    //Get place API code
    given().log().all()
            .queryParam("key", "qaclick123")
            .queryParam("place_id", place_Id)

    .when()
            .get(ResourceURLs.getPlceResource)

    .then().log().status()
            .log().body()

            .assertThat()
                .statusCode(200)
                .body("address",equalTo(newAddress));

    }
}
