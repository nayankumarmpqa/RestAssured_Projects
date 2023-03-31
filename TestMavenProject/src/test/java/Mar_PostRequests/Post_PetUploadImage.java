package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Post_PetUploadImage {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Hp\\Downloads\\screenshot-iPhone 13-16.0 (2).png");
        RestAssured.baseURI="https://petstore.swagger.io/v2";

        Response response = given()
                .log().uri()
                .header("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>")
                .accept("application/json")
                .multiPart("file", file)
            .when()
                .post("/pet/10/uploadImage")
            .then()
                .log().all()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(5000L))
                .extract().response();

    }
}
