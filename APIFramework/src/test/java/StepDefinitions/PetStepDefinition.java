package StepDefinitions;

import PoJoClasses.AddPetPojo;
import PoJoClasses.Category;
import PoJoClasses.Tag;
import Resources.APIResourceEnum;
import Resources.PayloadDataCreation;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PetStepDefinition extends Utils {
    Response actualResponse;
    PayloadDataCreation testData;
    APIResourceEnum apiResourceEnum;
    @Given("Pet object that needs to be added to the store")
    public void pet_object_that_needs_to_be_added_to_the_store() throws IOException {
//       AddPetPojo addPetPojo = new AddPetPojo();
//       addPetPojo.setId(20);
//        Category category = new Category();
//        category.setId(30);
//        category.setName("catName");
//    addPetPojo.setCategory(category);
//    addPetPojo.setName("Nayan");
//
//        ArrayList<String> p = new ArrayList<>();
//        p.add("photourl1");
//    addPetPojo.setPhotoUrls(p);
//
//            Tag tag = new Tag();
//            tag.setId(40);
//            tag.setName("Tag name");
//                    ArrayList<Tag> t = new ArrayList<>();
//                    t.add(tag);
//    addPetPojo.setTags(t);
//    addPetPojo.setStatus("nkavailable");

        testData = new PayloadDataCreation();


//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri("https://petstore.swagger.io/v2")
//                .setContentType(ContentType.JSON)
//                .setAccept(ContentType.JSON)
//                .build();
        // Or create a util class and extend that class here


//        responseSpecification = new ResponseSpecBuilder()
//                .expectStatusCode(200)
//                .expectContentType(ContentType.JSON)
//                .expectResponseTime(Matchers.lessThan(3000L))
//                .build();
        // Or create a util class and extend that class here

        requestSpecification = given().
                //spec(requestSpecification).body(addPetPojo); OR
        spec(requestSpecification()).body(testData.addPetPayloadCreation());
        //requestSpecification variable above is coming from utils class that we extended here
    }
    @When("I run {string} with Post request")
    public void i_run_with_post_request(String string) throws FileNotFoundException {
        apiResourceEnum = APIResourceEnum.valueOf(string); // this will call the constructor and assign the value

      //  actualResponse =  requestSpecification.when().post("/pet")
        //Or we can call emun class method to get the assigned resource name
        actualResponse =  requestSpecification.when().post(apiResourceEnum.getAPIResourceName())
               .then().log().all()
                .spec(responseSpecification()).extract().response();
        //responseSpecification variable above is coming from utils class that we extended here

    }
    @Then("The call is successful with status code {string}")
    public void the_call_is_successful_with_status_code(String string) {
         Assert.assertEquals(actualResponse.getStatusCode(), 200);
    }
    @Then("The {string} in the response body is {string}")
    public void the_in_the_response_body_is(String string, String string2) {
        String resp = actualResponse.asString();
        JsonPath js = new JsonPath(resp);
        Assert.assertEquals(js.getString(string), string2);
    }

    @Given("Pet object that needs to be added to the store with {string} {string} {string}")
    public void petObjectThatNeedsToBeAddedToTheStoreWith(String arg0, String arg1, String arg2) throws IOException {
        testData = new PayloadDataCreation();
        requestSpecification = given().
                spec(requestSpecification()).body(testData.addPetPayloadCreation(arg0, arg1, arg2));
    }
}
