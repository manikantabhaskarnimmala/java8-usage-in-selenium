package pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	// add to cart button
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	WebElement addToCartBtn;

	// Cart Icon
	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	WebElement cartIcon;

	// item name
	@FindBy(css = "div[data-test='inventory-item-name']")
	WebElement itemName;

	// item price
	@FindBy(css = "div[data-test='inventory-item-price']")
	WebElement itemPrice;

	// Then click on add to cart
	public void clickAddToCart() {
		click(addToCartBtn);
	}

	// click Cart Icon
	public void clickCartIcon() {
		click(cartIcon);
	}

	// get item name
	public String getItemName() {
		return getText(itemName);
	}

	// is item visible
	public boolean isItemdisplayed() {
		return displayed(itemName);
	}

	//Item price
	public double getItemPrice() {
		String value = itemPrice.getText().replace("$", "");
		return Double.parseDouble(value);
	}

	//Verify addtoCart button is visible
	public boolean isAddToCartButtonDisplayed() {
		return displayed(addToCartBtn);
	}
}
