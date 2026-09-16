package utils;

import java.util.Collections;
import java.util.List;

public class CommonUtilities {
	public static List<Double> sortNumericValues(List<Double> elements) {
		Collections.sort(elements);
		return elements;
	}

	public static List<Double> reverseSortNumericValues(List<Double> elements) {
		Collections.sort(elements, Collections.reverseOrder());
		return elements;
	}

	public static List<String> sortStringValues(List<String> elements) {
		Collections.sort(elements);
		return elements;
	}

	public static List<String> reverseSortStringValues(List<String> elements) {
		Collections.sort(elements, Collections.reverseOrder());
		return elements;
	}

}
