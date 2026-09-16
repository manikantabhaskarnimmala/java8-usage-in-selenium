package pages.sauceDemo;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	// ProductName Element
	@FindBy(xpath = "//*[text()='Products']")
	WebElement productsElement;

	// Products
	@FindBy(xpath = "//*[@data-test='inventory-item-name']")
	List<WebElement> products;

	// Action Methods
	// Get text of products element
	public String getText() {
		wait.until(ExpectedConditions.visibilityOf(productsElement));
		return productsElement.getText();
	}
	
	// Check whether products are displayed
	public boolean isProductsDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElements(products));
		return products.stream().allMatch(product -> product.isDisplayed());
	}
	
	// Count the products
	public int countProducts() {
		return products.size();
	}

	// Get names of all the products
	public List<String> getProductNames() {
		List<String> productNames = products.stream().map((product) -> product.getText()).collect(Collectors.toList());
		return productNames;
	}
	
	

}
