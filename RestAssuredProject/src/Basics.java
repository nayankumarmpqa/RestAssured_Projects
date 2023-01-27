import io.restassured.RestAssured;


public class Basics {
    public static void main(String[] args) {
        // validate add place api
        //given - inputd
        // when - method(andResourceName)
        // then - validate response
        System.out.println("Praise the Lord");

        RestAssured.baseURI = "https://rahulshettyacademy.com";

      /* given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("")
                .when()
                .post("maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200);
*/
    }

}
