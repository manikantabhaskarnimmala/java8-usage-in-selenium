package pages.demoWebsite;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Locators
	// login Button
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginBtn;

	// links
	@FindBy(tagName = "a")
	List<WebElement> links;

	// BooksELement
	@FindBy(xpath = "//*[@class='top-menu']//a[normalize-space()='Books']")
	WebElement booksLink;

	// Common xpath for books name
	@FindBy(xpath = "//h2[@class='product-title']")
	List<WebElement> bookNames;

	// sort dropdown
	@FindBy(id = "products-orderby")
	WebElement dropdown;

	//// action methods

	// click Login Btn
	public void clickLoginBtn() {

		// without lambda expressions
		// wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		wait.until(driver -> loginBtn.isDisplayed());
		loginBtn.click();

	}

	// returns links
	public List<WebElement> getLinks() {
		return links;
	}

	// Click on Books link
	public void clickBooksLink() {

		// without Java 8
		// wait.until(ExpectedConditions.elementToBeClickable(booksLink));

		// with Java 8
		wait.until(driver -> booksLink.isDisplayed());
		booksLink.click();
	}

	// returns books count
	public int getBooksSize() {
	    return bookNames.size();
	}

	// returns dropdown element
	public void selectSortOption(String option) {
		
		//with out java 8 
		//wait.until(ExpectedConditions.visibilityOf(dropdown));
		
		//with Java 8
		wait.until(driver -> dropdown.isDisplayed());
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	// returns  books name
	public List<String> getBookNames() {
		return bookNames.stream().map(WebElement::getText).collect(Collectors.toList());
	}

}
