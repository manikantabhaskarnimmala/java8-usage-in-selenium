package tests.demoWebsite;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import pages.demoWebsite.HomePage;

public class BasicTest extends BaseTest {

	@Test
	public void clickLoginBtn() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickLoginBtn();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		
		
	}
}