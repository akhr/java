package com.akh.java8;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamFilterObjects {

	public static void main(String[] args) {
		List<Order> list = new ArrayList<>();
		list.add(new Order(1, "One"));
		list.add(new Order(2, "OneAndOnly"));
		list.add(new Order(3, "Derek"));
		list.add(new Order(4, "Change"));
		list.add(new Order(5, "factory"));
		list.add(new Order(6, "justBefore"));
		list.add(new Order(7, "Italy"));
		list.add(new Order(1, "Italy"));
		list.add(new Order(8, "Thursday"));
		list.add(new Order(10, ""));

		System.out.println(list
				.stream()
				.anyMatch(order -> order.getOrderByName().contains("a")));

		list
			.stream()
			.filter(order -> order.getOrderByName().contains("a"))
			.forEach(order -> System.out.println(order.toString()));

	}

	@AllArgsConstructor(access = AccessLevel.PUBLIC)
	private @Data static class Order {
		int orderNum;
		String orderByName;
	}
}
