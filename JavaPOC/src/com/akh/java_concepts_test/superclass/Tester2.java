package com.akh.java_concepts_test.superclass;

public class Tester2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubClassB<Integer> subClassObj = new SubClassB<Integer>();
		System.out.println(subClassObj.add(subClassObj));

	}

}
