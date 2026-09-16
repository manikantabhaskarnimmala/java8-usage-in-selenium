package tests.sauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.sauceDemo.HomePage;
import pages.sauceDemo.LoginPage;

public class LoginTest extends BaseTest {

	@Test(testName = "validLoginTest")
	public void validLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		HomePage hp = new HomePage(driver);
		String actualText = hp.getText();
		String expectedText = "Products";

		// Assertion
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(testName = "invalidLoginTest")
	public void invalidLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret");
		lp.clickLoginButton();

		String actualText = lp.getErrorMessage();
		String expectedText = "Epic sadface: Username and password do not match any user in this service";

		// Assertion
		Assert.assertEquals(actualText, expectedText);
	}

}
