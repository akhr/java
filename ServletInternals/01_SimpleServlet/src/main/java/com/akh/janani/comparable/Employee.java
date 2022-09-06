package com.akh.janani.comparable;

public class Employee implements Comparable<Employee>{
	String fName;
	String lName;
	int age;

	public Employee(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	@Override
	public int compareTo(Employee anotherEmp) {
		if(this.age == anotherEmp.age)
			return 0;
		else if (this.age > anotherEmp.age)
			return 1;
		else
			return -1;
	}
}
