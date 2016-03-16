package com.thesaka.eg.comparableTest;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HumanType person1 = HumanType.Men;
		HumanType person2 = HumanType.Women;
		HumanType person3 = HumanType.Women;
		
		System.out.println("Person1 == Person2   ---->" + person2.compareTo(person1));
		System.out.println("Person2 == Person3   ---->" + person2.compareTo(person3));


	}

}
