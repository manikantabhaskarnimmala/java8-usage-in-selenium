package tests.demoWebsite;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.demoWebsite.HomePage;

public class HomePageTest1 extends BaseClass {

	@Test
	public void printTextFromlinks() {

		HomePage hp = new HomePage(driver);
		// This test method will find the no. of elements and returns the text of each
		// links.

		System.out.println(hp.getLinks().size());

//		//without Java 8		
//		for(WebElement link : hp.getLinks()) {
//			System.out.println(link.getText());
//		}

		// Java 8
		hp.getLinks().forEach((link) -> System.out.println(link.getText()));
	}

	@Test(dependsOnMethods = "printTextFromlinks")
	public void printLinksHavingHrefAttributes() {
		HomePage hp = new HomePage(driver);
		long hrefLinksCount = 0;
		// print the links having href attributes

//		// without Java 8
//		for (WebElement link : hp.getLinks()) {
//			if (link.getAttribute("href") != "") {
//				System.out.println(link.getText());
//				hrefLinksCount++;
//			}
//		}
//		System.out.println("Herf Links Count :"+hrefLinksCount);

		// with Java 8
		hrefLinksCount = hp.getLinks().stream().filter((link) -> link.getAttribute("href") != null).count();
		System.out.println("Herf Links Count :" + hrefLinksCount);

		hp.getLinks().stream().filter(link -> link.getAttribute("href") != null)
				.forEach(link -> System.out.println(link.getAttribute("href")));
	}

}
