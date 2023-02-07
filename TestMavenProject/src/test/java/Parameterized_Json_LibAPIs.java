import files.Payloads;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Parameterized_Json_LibAPIs {

    @Test(dataProvider = "myBooksDataProvider")
    public void parameterizedJsonPayloadTest(String isbn, String isle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .body(Payloads.addBookPayload(isbn, isle))
                        .when()
                        .post("Library/Addbook.php")

                        .then().log().all()
                        .assertThat().statusCode(200)
                        .extract().asString();

        JsonPath js = ReusableMethods.responseStringToJsonObj(addBookResponse);
        String id = js.get("ID");
        System.out.println(id);

    }


    @DataProvider(name = "myBooksDataProvider")
    public Object[][] getDataMethod() {
        return new Object[][]{{"nk1", "260111"}, {"nk2", "260112"}, {"nk3", "260113"}, {"nk4", "260114"}};
    }
}
