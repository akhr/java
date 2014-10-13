/**
 * 
 */
package com.example.algo.palindrome;

import java.util.Scanner;

/**
 * @author Akhash
 *
 */
public class NumberPalindrome {
	/*
	 *//**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number : ");
		long num = scanner.nextLong();
		System.out.println("Input : " +num);
		if(isPalindrome(num))
			System.out.println("yes");
		else
			System.out.println("no");


	}

	private static boolean isPalindrome(long input){

		long rev = 0;
		long num = input;
		for(int i=0; i<=num; i++){
			long r = num%10;
			rev = rev*10+r;
			num=num/10;
			i=0;
		}

		return (rev == input) ?  true : false;
	}
	  
	
}