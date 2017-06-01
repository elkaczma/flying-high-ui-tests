package edu.iis.mto.bdd.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get("http://localhost:8080/#/welcome");
	}
	
	public void signIn(FrequentFlyerMember user) {
        driver.findElement(By.name("email")).sendKeys(user.getEmail());
        driver.findElement(By.name("password")).sendKeys(user.getPassword());
        driver.findElement(By.name("signin")).click();
    }
}
