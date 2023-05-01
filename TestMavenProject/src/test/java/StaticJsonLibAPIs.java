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
                        .body(generateStringFromResourceFilePath("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\TestMavenProject\\AddBookJsonFile.json"))
                        .when()
                        .post("Library/Addbook.php")

                        .then().log().all()
                        .assertThat().statusCode(200)
                        .extract().asString();

        JsonPath js = ReusableMethods.responseStringToJsonObj(addBookResponse);
        String id = js.get("ID");
        System.out.println(id);

        //Below is just an example for Files class readAllBytes method
        System.out.println(new String(Files.readAllBytes(
                Paths.get("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\TestMavenProject\\myfile.txt")
        )));

    }

    public static String generateStringFromResourceFilePath(String path) throws IOException{
        // For understanding:
            //Files.readAllBytes(Path path) // returns array of bytes[] from the file
            // Paths.get(String path) // returns Path

        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
