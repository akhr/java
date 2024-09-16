package com.akh.java_concepts_test.hashMapTest;

public class Student {

	String fName;
	String lName;
	int age;
	Address address;

	public static void main(String[] args) {
		Student diya = new Student();
		diya.fName = "diya";
		diya.lName = "akhash";
		diya.age = 4;
		diya.address = new Address("ginkgo", "fremont", "ca");

		Student achu = new Student();
		achu.fName = "achu";
		achu.lName = "vijay";
		achu.age = 5;
		achu.address = new Address("warmsprings", "orion", "mi");


		System.out.println("*** Diya HashCode: "+diya.hashCode());
		System.out.println("*** Achu HashCode: "+achu.hashCode());
	}

	@Override
	public int hashCode(){
		int hash = 0;
		hash = fName.hashCode() + lName.hashCode() + age + address.hashCode();
		return hash;
	}
}
