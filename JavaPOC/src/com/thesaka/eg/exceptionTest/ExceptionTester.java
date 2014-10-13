package com.thesaka.eg.exceptionTest;

public class ExceptionTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Tester started");
		try {
			ExceptionTest test = new ExceptionTest("");
			System.out.println("This line doesnt execute since thrown exception jumps the program pointer to catch block");
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exception catched and proceeded");
	}

}
