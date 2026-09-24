package oopExamples;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class EmployeeClass {
	private String name;
	private int salary;

	public EmployeeClass(String name, int salary) {
		this.name = name;
		this.salary = salary;

	}

	public EmployeeClass() {

	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
}

public class SerializationAndDeserialization {

	public static void main(String[] args) throws JsonProcessingException {

		List<EmployeeClass> data = new ArrayList<>();
		data.add(new EmployeeClass("manikanta", 13));
		data.add(new EmployeeClass("manikanta", 12));

		ObjectMapper obj = new ObjectMapper();

		for (EmployeeClass em : data) {

			// Serialization
			String json = obj.writeValueAsString(em);
			System.out.println("JSON: " + json);

			// Deserialization
			EmployeeClass employee = obj.readValue(json, EmployeeClass.class);

			System.out.println("Name: " + employee.getName());
			System.out.println("ID: " + employee.getSalary());
		}
	}

}
