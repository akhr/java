/**
 * 
 */
package com.akh.algorithms.stringAlgorithms;

/**
 * @author Akhash Ramamurthy
 * Apr 30, 2017
 */
public class FindIfRotatedSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	
	private static boolean isRotatedSubstring(String s1, String s2){
		if(s2.length() > s1.length())
			return false;
		
		String s1s1 = s1+s1;
		return isSubString(s1s1, s2);
	}
	
	private static boolean isSubString(String s1, String s2){
		//Need to implement
		return false;
	}
}
