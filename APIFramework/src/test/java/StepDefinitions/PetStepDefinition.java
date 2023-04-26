package StepDefinitions;

import PoJoClasses.AddPetPojo;
import PoJoClasses.Category;
import PoJoClasses.Tag;
import Resources.APIResourceEnum;
import Resources.PayloadDataCreation;
import Resources.Utils;
import io.cucumber.java.en.And;
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
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class PetStepDefinition extends Utils {
    Response actualResponse;
    PayloadDataCreation testData;
    APIResourceEnum apiResourceEnum;

    static String expectedPetId;

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

    @When("I run {string} with {string} request")
    public void i_run_with_post_request(String resourceNameFromFeatureFile, String httpMethod) throws IOException {
        apiResourceEnum = APIResourceEnum.valueOf(resourceNameFromFeatureFile); // this will call the constructor and assign the value
        System.out.println(apiResourceEnum);


        //  actualResponse =  requestSpecification.when().post("/pet")
        //Or we can call emun class method to get the assigned resource name
        if (httpMethod.equalsIgnoreCase("Post")) {
            actualResponse = requestSpecification.when().post(apiResourceEnum.getAPIResourceName());
            System.out.println(actualResponse.getStatusCode());
            //.then()
            // .spec(responseSpecification()).extract().response();
            //responseSpecification variable above is coming from utils class that we extended here
        } else if (httpMethod.equalsIgnoreCase("Get")) {
            requestSpecification = given().
                    spec(requestSpecification());
            actualResponse = requestSpecification.when().get(apiResourceEnum.getAPIResourceName());
            System.out.println(actualResponse.getStatusCode());
        }else if (httpMethod.equalsIgnoreCase("Delete")) {
            requestSpecification = given().
                    spec(requestSpecification());
            actualResponse = requestSpecification.when().delete(apiResourceEnum.getAPIResourceName());
            System.out.println(actualResponse.getStatusCode());
        }
    }

    @Then("The call is successful with status code {int}")
    public void the_call_is_successful_with_status_code(int successCode) {
        Assert.assertEquals(actualResponse.getStatusCode(), successCode);
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

    @Then("verify created petid using {string}")
    public void verify_created_petid_using(String resourceNameFromFeatureFile) throws IOException {
         expectedPetId = getJsonPathKeyValue(actualResponse, "id");
        requestSpecification = given().spec(requestSpecification()).basePath("{resourcePath}")
                .pathParam("resourcePath", expectedPetId);
        i_run_with_post_request(resourceNameFromFeatureFile, "Get");
        String actualPetId = getJsonPathKeyValue(actualResponse, "id");
        System.out.println("actualPetId = " + actualPetId);
        System.out.println("petId and actualPetId = " + expectedPetId + " , " + actualPetId);


        Assert.assertEquals(actualPetId, expectedPetId);
    }


    @Given("Delete Pet payload object that is needed is ready")
    public void delete_pet_payload_object_that_is_needed_is_ready() throws IOException {


        requestSpecification = given().spec(requestSpecification()).header("api_key", "special-key").basePath("{resourcePath}")
                .pathParam("resourcePath", expectedPetId);

    }

}
