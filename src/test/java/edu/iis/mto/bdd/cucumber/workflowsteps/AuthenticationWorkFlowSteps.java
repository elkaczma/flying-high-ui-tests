package edu.iis.mto.bdd.cucumber.workflowsteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class AuthenticationWorkFlowSteps {
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	public AuthenticationWorkFlowSteps(WebDriver driver) {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	public void enterEmailAndPasswordFor(FrequentFlyerMember user) {
		loginPage.open();
        loginPage.signIn(user);
	}
	
	public void verifyWelcomeMessageFor(FrequentFlyerMember user) {
		assertThat(homePage.getWelcomeMessage(), equalTo("Witaj " + user.getFirstName()));
	}

}
