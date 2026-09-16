package tests.sauceDemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.sauceDemo.CartPage;
import pages.sauceDemo.HomePage;
import pages.sauceDemo.LoginPage;
import pages.sauceDemo.ProductDetailsPage;
import utils.CommonUtilities;
import utils.LoggerUtils;

public class ProductsTest extends BasePageTest {

	private static final Logger log = LoggerUtils.getLogger(ProductsTest.class);

	@Test(groups = { "smoke", "regression" })
	public void verifyProductsNames() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "All products are displayed");
		log.info("User logged in successfully");
		int expectedCount = 6;
		Assert.assertEquals(hp.countProducts(), expectedCount);

		// Printing them
		log.info("Products listed: " + hp.getProductNames());
	}

	@Test(groups = { "smoke", "regression" })
	public void addProductToCart() {

		// login
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		// Home Page
		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.isProductsDisplayed(), "All products are displayed");
		log.info("User logged in successfully");

		// Assertion
		String specificProduct = "Sauce Labs Backpack";
		hp.clickSpecificProduct(specificProduct);

		// Product Page
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.clickAddToCart();

		// Cart Page
		CartPage cp = new CartPage(driver);
		// Assertion
		Assert.assertTrue(cp.productIsDisplayed(specificProduct), specificProduct + " is added on cart page");
	}

	@Test(groups = { "smoke", "regression" })
	public void removeProductFromCart() {
		log.info("starting remove product from cart test");
		// login
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		// Home Page
		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "All products are displayed");
		String specificProduct = "Sauce Labs Backpack";
		hp.clickSpecificProduct(specificProduct);

		// Product Page
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.clickAddToCart();
		pdp.clickCartIcon();

		// Cart Page
		CartPage cp = new CartPage(driver);
		// Assertion
		Assert.assertTrue(cp.productIsDisplayed(specificProduct), specificProduct + " Products page is not displayed");

		// remove item from cart page
		cp.clickRemoveBtn();
		// Assertion
		Assert.assertFalse(cp.productIsDisplayed(specificProduct),
				specificProduct + " is still displayed in cart after removal");
		log.info("Product is removed from cart");
	}

	@Test(groups = { "smoke", "regression" })
	public void verifyProductsSortedByPriceLowToHigh() {
		log.info("Starting price sorting test");
		// login
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		// Home Page
		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "Products are not displayed");
		log.info("User logged in successfully");

		String sortOption = "Price (low to high)";
		hp.selectOptionFromDropDown(sortOption);

		log.info("Selected sorting option: {}", sortOption);

		List<Double> actualValues = hp.getPricesOfProducts();
		log.info("Values grabbed from UI: {}", actualValues);
		List<Double> expectedValues = new ArrayList<>(actualValues);
		CommonUtilities.sortNumericValues(expectedValues);
		log.info("Expected sorted values: {}", expectedValues);
		Assert.assertEquals(actualValues, expectedValues, "Price values are not sorted");
		log.info("Price sorting validation passed");
	}

	@Test(groups = { "smoke", "regression" })
	public void verifyProductsSortedByNamesZtoA() {

		log.info("Starting name sorting test");
		// login
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		// Home Page
		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "Products are not displayed");
		log.info("User logged in successfully");

		String sortOption = "Name (Z to A)";
		hp.selectOptionFromDropDown(sortOption);
		log.info("Selected sorting option: {}", sortOption);

		List<String> actualValues = hp.getProductNames();
		log.info("Values grabbed from UI: {}", actualValues);
		List<String> expectedValues = new ArrayList<>(actualValues);
		CommonUtilities.reverseSortStringValues(expectedValues);
		log.info("Expected sorted values: {}", expectedValues);
		Assert.assertEquals(actualValues, expectedValues, "Names are not sorted in Z-A");
		log.info("Name sorting validation passed");

	}

	@Test
	public void verifyProductsDetails() {
		log.info("Starting verify products deatils test");
		// login
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();

		// Home Page
		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "Products are not displayed");
		log.info("User logged in successfully");
		
		String specificProduct = "Sauce Labs Backpack";
		hp.clickSpecificProduct(specificProduct);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		
		Assert.assertTrue(pdp.isItemdisplayed(), "Specific item is not visible");
		Assert.assertEquals(pdp.getItemName(), specificProduct);
		log.info("exact "+specificProduct+" is displayed");
		Double price= 29.99;
		Assert.assertEquals(pdp.getItemPrice(), price);	
		log.info("exact price is displayed");
		Assert.assertTrue(pdp.isAddToCartButtonDisplayed(), "Add ToCart button is enabled");
		log.info("Add to cart button is also displayed");
		
		log.info("Verify Products Details validation is passed");
		
		
	}

}
