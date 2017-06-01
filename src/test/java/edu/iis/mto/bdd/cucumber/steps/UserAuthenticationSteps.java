package edu.iis.mto.bdd.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.cucumber.workflowsteps.AuthenticationWorkFlowSteps;
import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class UserAuthenticationSteps {

    private WebDriver driver;
    private AuthenticationWorkFlowSteps authenticationWorkFlow;

    @Before
    public void init() {
        driver = new FirefoxDriver();
        authenticationWorkFlow = new AuthenticationWorkFlowSteps(driver);
    }

    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(String userEmail) {}

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember user) {
        authenticationWorkFlow.enterEmailAndPasswordFor(user);
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember user) {
    	authenticationWorkFlow.verifyWelcomeMessageFor(user);
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember user) {
    	authenticationWorkFlow.enterEmailAndPasswordFor(user);
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {}

    @After
    public void close() {
        driver.close();
    }

}
