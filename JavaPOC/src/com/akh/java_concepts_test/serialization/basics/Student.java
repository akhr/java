package com.akh.java_concepts_test.serialization.basics;


import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L; // For version control during serialization

	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{name='" + name + "', age=" + age + '}';
	}
}
