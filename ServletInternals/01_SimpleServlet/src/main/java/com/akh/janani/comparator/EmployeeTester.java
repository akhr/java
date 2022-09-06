package com.akh.janani.comparator;

public class EmployeeTester {

	public static void main(String[] args) {
		Employee a = new Employee("diya", "akh", 3);
		Employee b = new Employee("aach", "vijay", 2);
		Employee c = new Employee("diya", "akh", 3);
	
		EmployeeComparator comparator = new EmployeeComparator();
		
		System.out.println("a.compareTo(b) ==> "+comparator.compare(a, b));
		System.out.println("b.compareTo(a) ==> "+comparator.compare(b, a));
	}

}
