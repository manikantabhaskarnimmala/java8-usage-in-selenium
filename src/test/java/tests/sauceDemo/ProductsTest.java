package tests.sauceDemo;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.sauceDemo.HomePage;
import pages.sauceDemo.LoginPage;

public class ProductsTest extends BaseTest{
	
	@Test//(dependsOnMethods = "validLogin")
	public void verifyProductsNames() {
		LoginPage lp = new LoginPage(driver);
	    lp.setUsername("standard_user");
	    lp.setPassword("secret_sauce");
	    lp.clickLoginButton();

		HomePage hp = new HomePage(driver);
		// Assertion
		Assert.assertTrue(hp.isProductsDisplayed(), "All products are displayed");
		int expectedCount=6;
		Assert.assertEquals(hp.countProducts(), expectedCount);
		
		//Printing them
		System.out.println("Products listed: "+hp.getProductNames());
		
		
	}

}
