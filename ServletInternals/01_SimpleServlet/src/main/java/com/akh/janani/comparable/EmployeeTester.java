package com.akh.janani.comparable;

public class EmployeeTester {

	public static void main(String[] args) {
		Employee a = new Employee("diya", "akh", 3);
		Employee b = new Employee("aach", "vijay", 2);
		Employee c = new Employee("diya", "akh", 3);
		
//		System.out.println("a = "+a);
//		System.out.println("b = "+b);
//		System.out.println("c = "+c);
		
//		System.out.println("a.compareTo(c) ==> "+a.compareTo(c));
		System.out.println("a.compareTo(b) ==> "+a.compareTo(b));
		System.out.println("b.compareTo(a) ==> "+b.compareTo(a));
	}

}
