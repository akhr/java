package com.akh.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterSimple {

	public void filterPrint01() {
		String[] items = {"One", "OneAndOnly", "Derek", "Change", "factory", "justBefore", "Italy", "Italy", "Thursday"};
		List<String> list = Arrays.asList(items);
		System.out.println(list.stream().anyMatch(str -> str.contains("a")));
		
		list.stream()
		.filter(str -> str.contains("a"))
		.forEach(System.out::println);
	}

	public void filterCollect(){
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> filteredList = list.stream().filter(x -> (x*2)%3==0).collect(Collectors.toList());
		System.out.println(Arrays.deepToString(filteredList.toArray()));
	}

	@Test
	public void test01(){
		filterPrint01();
	}

	@Test
	public void test02(){
		filterCollect();
	}

}
