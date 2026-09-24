package oopExamples;

import org.openqa.selenium.remote.Browser;

/*
 * Polymorphism means one reference can represent different forms of objects. 
 * Here, the Browser reference points to a Chrome object first and a Firefox object later. 
 * Both child classes override the launch() method from parent Browser class. 
 * At runtime, Java decides which implementation to execute based on the actual object.
 */

interface WebDriver1 {

	void launch();
}

class Chrome implements WebDriver1 {

	@Override
	public void launch() {
		System.out.println("Launching Chrome");
	}
}

class Firefox implements WebDriver1 {

	@Override
	public void launch() {
		System.out.println("Launching Firefox");
	}
}

public class Polymorphism {

	public static void main(String[] args) {

		WebDriver1 driver;
		driver = new Chrome(); // Runtime Polymorphism
		driver.launch();

		driver = new Firefox(); // Runtime Polymorphism
		driver.launch();

	}

}
