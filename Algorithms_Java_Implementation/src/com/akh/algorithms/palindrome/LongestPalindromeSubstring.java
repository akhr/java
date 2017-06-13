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
		System.out.println("Longest Substring Palindrome = "+longestPalindrome_MyImpl_DP(input));
	}
	/**
	 * For explanation : https://www.youtube.com/watch?v=obBdxeCx_Qs 
	 * This is a O(N^2) algo. But better than brute-force which is O(N^3) because of storing 
	 * the previous results in boolean[][] matrix using memoization process of Dynamic Programming
	 * 
	 * There exist O(N) algo - Manacher's Algo
	 */
	public static String longestPalindrome_MyImpl_DP(String str){
		int n = str.length();
		String longestPalindrome = "";
		int maxLength = 0;
		int palindromeBeginPoint = 0;
		boolean[][] palindrome = new boolean[n][n];
		
		//Trivial case. All one char strings are by default palindromes
		for(int i=0; i<n; i++){
			palindrome[i][i] = true;
		}
		
		// Two Character palindromes. Meaning both chars should be same/equal
		for(int i=0; i<n-1; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				palindrome[i][i+1] = true;
				palindromeBeginPoint = i;
				maxLength = 2;
			}
		}
		
		/** 
		 * Starting from Substring of length 3 use following logic
		 * 1. Check start and end chars if equal
		 * 2. If yes, then next substring to check is -> start+1 and end-1 and the result
		 *    is already available in the matrix 
		 **/
		for(int currLen=3; currLen<=n; currLen++){
			for(int startPoint=0; startPoint<n-currLen+1; startPoint++){
				int endPoint = startPoint+currLen-1;
				if(startPoint < endPoint && str.charAt(startPoint) == str.charAt(endPoint)){
					if(palindrome[startPoint+1][endPoint-1]){
						palindrome[startPoint][endPoint] = true;
						maxLength = currLen;
						palindromeBeginPoint = startPoint;
					}
				}
			}
		}
		
		longestPalindrome = str.substring(palindromeBeginPoint, palindromeBeginPoint+maxLength);
		return longestPalindrome;
	}
}
