package com.akh.java_concepts_test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamHandler {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList(new String[] {"231", "Dixon", "Landing", "", "Apt", "185"});
		String asas = "";
		asas.length();
//		String s = strings.stream().map(Object::toString).collect(Collectors.joining(","));
		String s = strings.stream().filter(str -> str.length() > 0).collect(Collectors.joining("\s"));
		System.out.println(s);
	}

}
