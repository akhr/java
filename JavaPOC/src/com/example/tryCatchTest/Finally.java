package com.example.tryCatchTest;

public class Finally {

	public static void main(String[] args) {
		System.out.println("Calling go");
		String st = go();
		System.out.println("Back from go: " + st);
	}

	public static String go() {
		try {
//			throw(new Exception());
			System.out.println("Just try - no exception");
		}
		catch (Exception ex) {
			System.out.println("Entered catch");
			return "Went into Catch Block";
		}
		finally {
			System.out.println("Entered finally");
		}
		return "All OK";
	}
}

