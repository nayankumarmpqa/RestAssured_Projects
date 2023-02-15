package StepDefFiles;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

    @Given("^User is on Login to NetBanking Page$")
    public void User_is_on_Login_to_NetBanking_Page(){
        System.out.println("User_is_on_Login_to_NetBanking_Page");
    }

    @When("^User Login with Username and Password$")
    public void User_Login_with_Username_and_Password(){
        System.out.println("User_Login_with_Username_and_Password");
    }


    @Then("^HomePage is displayed$")
    public void HomePage_is_displayed(){
        System.out.println("HomePage_is_displayed");
    }

    @And("^Cards are displayed$")
    public void Cards_are_displayed(){
        System.out.println("Cards_are_displayed");

    }



    @When("User Login with {string} and {string}")
    public void user_login_with_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("public void user_login_with_and(String string, String string2) is :" + string + "-" + string2);
    }
    @Then("Cards are not displayed")
    public void cards_are_not_displayed() {
        System.out.println("cards_are_not_displayed");
    }
}
