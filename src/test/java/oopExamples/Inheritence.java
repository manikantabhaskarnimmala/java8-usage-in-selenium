package oopExamples;

/*
 * Inheritance is an OOP concept where a child class acquires the properties and behaviors of a parent class. 
 * In Java, we use the extends keyword for class inheritance. 
 * Here, LoginTest extends BaseTest, so it can directly access the common methods launchBrowser() and closeBrowser() defined in BaseTest. 
 * This provides code reusability and avoids duplicating common setup and teardown code in every test class.
 */

class BaseTest {

	void launchBrowser() {
		System.out.println("Launching browser");
	}

	void closeBrowser() {
		System.out.println("Closing browser");
	}
}

class LoginTest extends BaseTest {

	void login() {
		System.out.println("Performing login");
	}
}

public class Inheritence {

	public static void main(String args[]) {

		LoginTest test = new LoginTest();

		test.launchBrowser();
		test.login();
		test.closeBrowser();
	}

}
