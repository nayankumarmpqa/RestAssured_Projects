import files.Payloads;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class StaticJsonLibAPIs {

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        String addBookResponse =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .body(generateStringFromResource("C:\\Users\\Hp\\Desktop\\AddBookJsonFile.json"))
                        .when()
                        .post("Library/Addbook.php")

                        .then().log().all()
                        .assertThat().statusCode(200)
                        .extract().asString();

        JsonPath js = ReusableMethods.responseStringToJsonObj(addBookResponse);
        String id = js.get("ID");
        System.out.println(id);

    }

    public static String generateStringFromResource(String path) throws IOException{
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
