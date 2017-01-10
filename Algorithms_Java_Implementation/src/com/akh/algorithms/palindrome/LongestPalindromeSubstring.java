/**
 * 
 */
package com.akh.algorithms.palindrome;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 * Jan 9, 2017
 */
public class LongestPalindromeSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Word : ");
		String input = scanner.nextLine();
		input = input.toUpperCase();
		if(longestPalindrome(input) == null)
			System.out.println("No palindrome found");
		else
			System.out.println("Longest Substring Palindrome = "+longestPalindrome(input));
	}

	//This is O(n^2) algorithm. O(n) solution is Manacher's Algorithm
	private static String longestPalindrome(String s) {
		if( s == null || s.length()<=1)
			return s;
		
		String max = "";
		
		//Go through each index
		for(int i = 0; i < s.length(); i++){
			
			//This case is for middle char occurs only once. Eg dabcba
			int start = i;
			int end = i;
			
			//If the char are equal then expand on both direction and once again for equality
			while(start >=0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
				//Expansion Step
				start--;
				end++;
			}
			
			//Generate the substring - start is added once since previous step looking to check for the next expansion but since 
			//its out of bounds we exit the while loop
			//So while extracting the substring we need to ignore the last expansion step
			String temp = s.substring(start+1, end);
			
			//Check if temp substring is longer than already found max string. If yes replace max with new max string
			max = (temp.length() > max.length()) ? temp : max;
			
			
			//This case is for middle char repeated twice. Eg dabccba
			start = i;
			end = i+1;
			while(start >=0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
				start--;
				end++;
			}
			temp = s.substring(start+1, end);
			max = (temp.length() > max.length()) ? temp : max;
		}
		return max;
	}
}
