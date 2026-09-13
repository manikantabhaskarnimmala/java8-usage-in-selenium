package oopExamples;

/*
 * Abstraction means hiding implementation details and exposing only the required functionality. 
 * Here, the WebDriver interface defines the launch() method, but it doesn't define how the browser is launched. 
 * ChromeBrowser and FirefoxBrowser provide their own implementations.
 */

interface WebDriver {
	public void launch();
}

class ChromeBrowser implements WebDriver {

	@Override
	public void launch() {
		System.out.println("Launched chrome browser");
	}
}

class EdgeBrowser implements WebDriver {

	@Override
	public void launch() {
		System.out.println("Launched edge browser");
	}
}

public class Abstraction {

	public static void main(String[] args) {

		WebDriver driver ;
		driver= new ChromeBrowser();
		driver.launch();
		
		driver = new EdgeBrowser();
		driver.launch();

	}

}
