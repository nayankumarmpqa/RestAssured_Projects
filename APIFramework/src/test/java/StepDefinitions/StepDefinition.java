package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {


    @Given("Add Place Payload")
    public void add_place_payload() {
        System.out.println("Add Place Payload");
    }
    @When("User call AddPlaceAPI wiht POST http request")
    public void user_call_add_place_api_wiht_post_http_request() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the API call is successfull with status code {int}")
    public void the_api_call_is_successfull_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("status in response body is OK")
    public void status_in_response_body_is_ok() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    //---------------------------
    @When("User call {string} wiht POST http request")
    public void user_call_wiht_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
