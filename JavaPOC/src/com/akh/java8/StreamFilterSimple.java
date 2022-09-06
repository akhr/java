package com.akh.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterSimple {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		list.add("Thursday");
		list.add("");
		list.add("");
		
		System.out.println(list.stream().anyMatch(str -> str.contains("a")));
		
		list	
		.stream()
		.filter(str -> str.contains("a"))
		.forEach(x -> System.out.println(x));
		
		
	}
	
	private static class Order {
		int orderNum;
		int orderByName;
	}

}
