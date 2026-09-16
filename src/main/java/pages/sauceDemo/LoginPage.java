package pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	// login
	@FindBy(id = "user-name")
	WebElement loginPH;

	// password
	@FindBy(id = "password")
	WebElement passwordPH;

	// login Button
	@FindBy(id = "login-button")
	WebElement loginButton;

	// Error Message
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMsg;

	// Action methods

	// Enter username
	public void setUsername(String user) {
		enterText(loginPH, user);
	}

	// Enter password
	public void setPassword(String pass) {
		enterText(passwordPH, pass);	}

	// Click login
	public void clickLoginButton() {
		click(loginButton);
	}

	// grab error message text
	public String getErrorMessage() {
		return getText(errorMsg);
	}

}
