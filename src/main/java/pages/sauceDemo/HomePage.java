package pages.sauceDemo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class HomePage extends BasePage {

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// --------------------Locators------------------------------
	// ProductName Element
	@FindBy(xpath = "//*[text()='Products']")
	WebElement productsElement;

	// Products
	@FindBy(xpath = "//*[@data-test='inventory-item-name']")
	List<WebElement> products;
	
	// drop down
	@FindBy(xpath ="//select[@data-test='product-sort-container']")
	WebElement sortDropDown;
	
	//prices of products
	@FindBy(css="div.inventory_item_price")
	List<WebElement> prices;

	// --------------------Actions----------------

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

	// click specific item
	public void clickSpecificProduct(String name) {
		Optional<WebElement> expectedItem = products.stream().filter(pro -> pro.getText().equals(name)).findFirst();
		click(expectedItem.get());
	}
	
	// select option from drop down
	public void selectOptionFromDropDown(String option) {
		click(sortDropDown);
		Select select = new Select(sortDropDown);
		select.selectByVisibleText(option);
	}
	
	// Get prices of all the products
	public List<Double> getPricesOfProducts(){
		return getText(prices).stream().map(price -> Double.parseDouble(price.replace("$", ""))).collect(Collectors.toList());
	}
	
	
	
	

}
