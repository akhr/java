package com.akh.java8;

public class Student {
	
	String name;
	int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display1(String name) {
		System.out.println("Display 1 - Student Name --> "+name);
	}
	
	public void display2(Student a) {
		System.out.println("Display 2 - Student Name --> "+a.name);
		System.out.println("Display 2 - Student Age --> "+a.age);
	}
	
	
	public static void main(String[] args) {
		Student x = new Student("x", 3);
		x.display1("kais");
	}

}

