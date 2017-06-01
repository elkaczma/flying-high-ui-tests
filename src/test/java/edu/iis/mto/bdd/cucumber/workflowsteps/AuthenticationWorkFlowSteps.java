package edu.iis.mto.bdd.cucumber.workflowsteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.thucydides.core.annotations.Step;

public class AuthenticationWorkFlowSteps {
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	public AuthenticationWorkFlowSteps(){
		
	}
	
	public AuthenticationWorkFlowSteps(WebDriver driver) {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Step
	public void enterEmailAndPasswordFor(FrequentFlyerMember user) {
		loginPage.open();
        loginPage.signIn(user);
	}
	
	@Step
	public void verifyWelcomeMessageFor(FrequentFlyerMember user) {
		assertThat(homePage.getWelcomeMessage(), equalTo("Witaj " + user.getFirstName()));
	}

}
