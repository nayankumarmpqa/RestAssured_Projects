package StepDefinitions;

import PoJoClasses.AddPetPojo;
import PoJoClasses.Category;
import PoJoClasses.Tag;
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

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PetStepDefinition {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response actualResponse;


    @Given("Pet object that needs to be added to the store")
    public void pet_object_that_needs_to_be_added_to_the_store() {
       AddPetPojo addPetPojo = new AddPetPojo();
       addPetPojo.setId(20);
        Category category = new Category();
        category.setId(30);
        category.setName("catName");
    addPetPojo.setCategory(category);
    addPetPojo.setName("Nayan");

        ArrayList<String> p = new ArrayList<>();
        p.add("photourl1");
    addPetPojo.setPhotoUrls(p);

            Tag tag = new Tag();
            tag.setId(40);
            tag.setName("Tag name");
                    ArrayList<Tag> t = new ArrayList<>();
                    t.add(tag);
    addPetPojo.setTags(t);
    addPetPojo.setStatus("nkavailable");



        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(3000L))
                .build();

        requestSpecification = given().
                spec(requestSpecification).body(addPetPojo);
    }
    @When("I run {string} with Post request")
    public void i_run_with_post_request(String string) {

        actualResponse =  requestSpecification.when().post("/pet")
               .then().log().all()
                .spec(responseSpecification).extract().response();

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
}
