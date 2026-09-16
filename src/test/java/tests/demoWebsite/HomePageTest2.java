package tests.demoWebsite;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.demoWebsite.HomePage;

public class HomePageTest2 extends BaseTest {

	@Test
	public void getBooksSize() {

		HomePage hp = new HomePage(driver);
		hp.clickBooksLink();// clicks Booklink on home page
		// Assertion
		Assert.assertEquals(hp.getBooksSize(), 6);
	}

	@Test
	public void checkOptionsSorted() {

	    HomePage hp = new HomePage(driver);
	    hp.clickBooksLink();
	    hp.selectSortOption("Name: A to Z");
	    List<String> actual = hp.getBookNames();
	    List<String> expected = actual.stream()
	            .sorted()
	            .collect(Collectors.toList());
	    Assert.assertEquals(actual, expected);
	}
}
