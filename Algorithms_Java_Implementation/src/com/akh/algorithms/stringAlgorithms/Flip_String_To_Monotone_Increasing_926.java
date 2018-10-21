package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: Flip_String_To_Monotone_Increasing_926.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 20, 2018
 *  
 *  A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
		We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
		Return the minimum number of flips to make S monotone increasing.
		
		Example 1:
		Input: "00110"
		Output: 1
		Explanation: We flip the last digit to get 00111.
		Example 2:
		
		Input: "010110"
		Output: 2
		Explanation: We flip to get 011111, or alternatively 000111.
		Example 3:
		
		Input: "00011000"
		Output: 2
		Explanation: We flip to get 00000000.
 */

public class Flip_String_To_Monotone_Increasing_926 {
	
	public int minFlipsMonoIncr(String S) {
		if(S == null || S.length() <= 0 )
			return 0;

		char[] sChars = S.toCharArray();
		int flipCount = 0;
		int onesCount = 0;

		for(int i=0; i<sChars.length; i++){
			if(sChars[i] == '0'){
				if(onesCount == 0) continue;
				else flipCount++;
			}else{
				onesCount++;
			}
			if(flipCount > onesCount){
				flipCount = onesCount;
			}
		}
		return flipCount;
	}

	@Test
	public void test_101(){
		String S = "00110";
		int expected = 1;
		assertEquals(expected, minFlipsMonoIncr(S));
	}

	@Test
	public void test_102(){
		String S = "010110";
		int expected = 2;
		assertEquals(expected, minFlipsMonoIncr(S));
	}

	@Test
	public void test_103(){
		String S = "00011000";
		int expected = 2;
		assertEquals(expected, minFlipsMonoIncr(S));
	}

	@Test
	public void test_104(){
		String S = "0101100011";
		int expected = 3;
		assertEquals(expected, minFlipsMonoIncr(S));
	}

	@Test
	public void test_105(){
		String S = "0011000010";
		int expected = 3;
		assertEquals(expected, minFlipsMonoIncr(S));
	}
	
}
