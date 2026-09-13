package oopExamples;

/*
 * Abstraction means hiding implementation details and exposing only the required functionality. 
 * Here, the Browser interface defines the launch() method, but it doesn't define how the browser is launched. 
 * Chrome and Firefox provide their own implementations.
 */

interface WebDriver {
	public void get();
}

class ChromeBrowser implements WebDriver {

	@Override
	public void get() {
		System.out.println("Launched chrome browser");
	}
}

class EdgeBrowser implements WebDriver {

	@Override
	public void get() {
		System.out.println("Launched edge browser");
	}
}

public class Abstraction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeBrowser();
		driver.get();

	}

}
