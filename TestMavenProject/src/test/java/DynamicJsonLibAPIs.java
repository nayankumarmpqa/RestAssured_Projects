import files.Payloads;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJsonLibAPIs {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse =
                given().log().all()
                        .header("Content-Type", "application/json")
                        //.body(Payloads.addBookPayload())
                        //OR
                        .body(Payloads.addBookPayload("nk", "260103"))
                        .when()
                        .post("Library/Addbook.php")

                        .then().log().all()
                        .assertThat().statusCode(200)
                        .extract().asString();

        JsonPath js = ReusableMethods.responseStringToJsonObj(addBookResponse);
        String id = js.get("ID");
        System.out.println(id);

    }
}
