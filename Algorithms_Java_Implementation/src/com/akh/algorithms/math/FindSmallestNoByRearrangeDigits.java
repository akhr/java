package com.akh.algorithms.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: FindSmallestNoByRearrangeDigits.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 7, 2018
 *  Find the Smallest number (Not leading Zeros) which can be obtained by rearranging the digits of given number.

Examples:

Input: n = 846903
Output: 304689

Input: n = 55010
Output: 10055
 */

public class FindSmallestNoByRearrangeDigits {

	public static int findSmallest(int num){
		int[] digitsArr = new int[10];

		//Build digits array
		//Eg: 8073 --> 
		// [1, 0, 0, 1, 0, 0, 0, 1, 1, 0]
		// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		while(num > 0){
			int quotient = num / 10;
			int reminder = num % 10;
			digitsArr[reminder] += 1;
			num = quotient;
		}

		int result = 0;
		for(int i=1; i<10; i++){
			if(digitsArr[i] > 0){
				result = result*10 + i;
				digitsArr[i]--;
				break;
			}
		}

		for(int i=0; i<10; i++){
			if(digitsArr[i] > 0){
				while(digitsArr[i] > 0){
					result = result*10 + i;
					digitsArr[i]--;
				}
			}
		}
		
		return result;
	}
	
	@Test
	public void test_1(){
		int num = 846903;
		System.out.println("Smallest of "+num+" is --> "+findSmallest(num));
		assertEquals(304689, findSmallest(num));
	}
	
	@Test
	public void test_2(){
		int num = 55010;
		System.out.println("Smallest of "+num+" is --> "+findSmallest(num));
		assertEquals(10055, findSmallest(num));
	}
	
}
