package oopExamples;

/*
 * Polymorphism means one reference can represent different forms of objects. 
 * Here, the Browser reference points to a Chrome object first and a Firefox object later. 
 * Both child classes override the launch() method. At runtime, Java decides which implementation to execute based on the actual object.
 */

class Browser {

	void launch() {
		System.out.println("Launching browser");
	}
}

class Chrome extends Browser {

	@Override
	void launch() {
		System.out.println("Launching Chrome");
	}
}

class Firefox extends Browser {

	@Override
	void launch() {
		System.out.println("Launching Firefox");
	}
}

public class Polymorphism {

	public static void main(String[] args) {

		Browser driver;
		driver = new Chrome(); // Runtime Polymorphism
		driver.launch();

		driver = new Firefox();
		driver.launch();

	}

}
