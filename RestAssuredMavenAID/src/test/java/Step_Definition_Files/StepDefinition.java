package Step_Definition_Files;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    @Given("User in on NetBanking Page")
    public void user_in_on_net_banking_page() {
        System.out.println("User in on NetBanking Page");
    }
    @When("User login with username and password")
    public void user_login_with_username_and_password() {
        System.out.println("User login with username and password");

    }
    @Then("Dashboard is displayed")
    public void dashboard_is_displayed() {
        System.out.println("Dashboard is displayed");

    }
    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");

    }


    @When("User login with {string} and {string}")
    public void user_login_with_and(String string, String string2) {
        System.out.println("User login with {string} and {string}: " + string + " " + string2);
    }
    @Then("Cards are not displayed")
    public void cards_are_not_displayed() {
        System.out.println("Cards are not displayed");
    }

}

