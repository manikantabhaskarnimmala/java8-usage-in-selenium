package pages.sauceDemo;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	// items on cart page
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	List<WebElement> itemNames;
	
	// remove button
	
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removeBtn;

	//specific item is visible on web page
	public boolean productIsDisplayed(String name) {
		return itemNames.stream().anyMatch(item -> item.getText().equals(name));
	}
	
	// click on remove button
	public void clickRemoveBtn() {
		click(removeBtn);
	}

}
