package tests.sauceDemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {

		
		driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// for saucedemo
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
	
	


}
