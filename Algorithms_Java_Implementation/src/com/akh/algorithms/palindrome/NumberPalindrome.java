/**
 * 
 */
package com.akh.algorithms.palindrome;

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
			System.out.println("1st Imple : yes");
		else
			System.out.println("1st Imple : no");
		if(isPalindromeMyImpl(num))
			System.out.println("2nd Imple : yes");
		else
			System.out.println("2nd Imple : no");
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
	
	private static boolean isPalindromeMyImpl(long input){
		String val = String.valueOf(input);
		int i = 0;
		int j = val.length()-1;
		while(i != j && i < j){
			if(val.charAt(i) == val.charAt(j)){
				i++;
				j--;
			}else{
				return false;
			}
		}
		return true;
	}
	  
	
}