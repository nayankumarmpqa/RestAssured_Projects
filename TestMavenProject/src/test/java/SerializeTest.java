import com.beust.ah.A;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static void main(String[] args) throws JsonProcessingException {

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

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(ap);
        System.out.println(jsonString);
        System.out.println("------------------------");


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


/*

https://www.tutorialspoint.com/how-to-convert-java-object-to-json-using-jackson-library


{
	"accuracy": 50,
	"name": "Nayan house",
	"phone_number": "8699784815",
	"address": "Mohali ynr",
	"website": "https://google.com",
	"language": "Hindi",
	"location": {
		"lat": -38.383494,
		"lng": 33.427362
	},
	"types": [
		"type1",
		"type2",
		"type3"
	]
}
 */