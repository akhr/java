package com.akh.janani.equals;

public class Student {
	
	String fName;
	String lName;
	
	public Student(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	
	@Override
	public int hashCode() {
		char[] fNameChars = fName.toCharArray();
		int hashCode = 0;
		for(char c : fNameChars) {
			hashCode = hashCode + c;
		}
		
		char[] lNameChars = lName.toCharArray();
		for(char c : lNameChars) {
			hashCode = hashCode + c;
		}
		return hashCode;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Student anotherStudent = (Student)obj;
		if(this.fName == anotherStudent.fName &&
				this.lName == anotherStudent.lName) {
			return true;
		}
		return false;
	}
	
}
