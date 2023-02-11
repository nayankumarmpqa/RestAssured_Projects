import com.beust.ah.A;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.AddPlacePojo;
import pojo.CreateUserPOJO;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class SerializeTest {

    public static void main(String[] args) {

        AddPlacePojo ap = new AddPlacePojo();
        ap.setAccuracy(50);
        ap.setName("Nayan house");
        ap.setPhone_number("8699784815");
        ap.setAddress("Mohali ynr");
        ap.setWebsite("https://google.com");
        ap.setLanguage("Hindi");

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        ap.setLocation(l);

        List<String> myTypeList = new ArrayList<>();
        myTypeList.add("type1");
        myTypeList.add("type2");
        myTypeList.add("type3");

        ap.setTypes(myTypeList);


        CreateUserPOJO cup=new CreateUserPOJO();
        cup.setName("Nayan1");
        cup.setJob("Manager1");

        RestAssured.baseURI = "https://reqres.in/";

        Response res = given()
                .body(cup).log().all()
                .when().post("/api/users")
                .then().log().all()
                .assertThat().statusCode(201).extract().response();

        System.out.println(res.asString());
    }
}
