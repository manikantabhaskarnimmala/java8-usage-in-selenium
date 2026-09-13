package oopExamples;

/*
 * In automation, Page Object Model is a good example of encapsulation. 
 * We keep locators and WebDriver implementation details private inside the page class.
 * And expose methods such as login() or search() to the test class.
 */

class Employee {
	private String name;
	private int salary;

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
}

public class Encapsulation {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Manikanta");
		emp.setSalary(1300000);

		System.out.println(emp.getName());
		System.out.println(emp.getSalary());

	}

}
