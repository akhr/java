package com.akh.janani.equals;

public class StudentTester {
	
	public static void main(String[] args) {
		Student a = new Student("diya", "akh");
		Student b = new Student("aach", "vijay");
		Student c = new Student("diya", "akh");
		
//		System.out.println("a = "+a);
//		System.out.println("b = "+b);
//		System.out.println("c = "+c);
//		System.out.println("(a == b) ==> "+(a.equals(b)));
//		System.out.println("(a == c) ==> "+(a.equals(c)));
		
		System.out.println("a.hashCode = "+a.hashCode());
		System.out.println("b.hashCode = "+b.hashCode());
		System.out.println("c.hashCode = "+c.hashCode());
	}

}
