/**
 * 
 */
package com.akh.algorithms.palindrome;

import java.lang.Character.Subset;
import java.util.Scanner;

/**
 * @author akhashr
 *
 */
public class StringPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Word : ");
		String input = scanner.nextLine();
		input = input.toUpperCase();
		if(isPalindrome(input))
			System.out.println("yes");
		else
			System.out.println("no");

	}
	
	private static boolean isPalindrome(String input){
		System.out.println("Substring Input : "+input);
		
		if(input.length() <= 1)
			return true;
		else if(input.charAt(0) == input.charAt(input.length()-1))
			return isPalindrome(input.substring(1, input.length()-1));
		else
			return false;
			
	}

}
