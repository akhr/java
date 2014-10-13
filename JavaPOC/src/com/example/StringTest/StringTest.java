package com.example.StringTest;

public class StringTest {

	/**
	 * @param args
	 */
	
	private static final String CONTRACTS ="Contracts";
	public static void main(String[] args) {
		System.out.println(CONTRACTS.equalsIgnoreCase(CONTRACTS));
		String s = "0123456789";
		System.out.println("SubString 0,0 - "+s.substring(9, 11));
	}

}
