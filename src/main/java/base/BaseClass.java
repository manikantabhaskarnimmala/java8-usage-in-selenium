package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	protected WebDriver driver;

	@BeforeClass
	public void setUp() {

		ChromeOptions options = new ChromeOptions();
		// Run Chrome without opening the browser window
		options.addArguments("--headless=new");

		// Launch browser
		driver = new ChromeDriver(options);

		// Maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to application
		// for demo website
		driver.get("https://demowebshop.tricentis.com/");
	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
