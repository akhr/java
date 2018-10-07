package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: ReverseOnlyLetters_917.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 6, 2018
 */

public class ReverseOnlyLetters_917 {
	public String reverseOnlyLetters(String S) {
		int left = 0;
		int right = S.length()-1;
		char[] chars = S.toCharArray();


		while(left < right){
			if(!Character.isLetter(chars[left])) {
				left++;
				continue;
			}
			if(!Character.isLetter(chars[right])) {
				right--;
				continue;
			}

			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
		return String.valueOf(chars);
	}

	@Test 
	public void test_1(){
		String S = "ab-cd";
		assertEquals("dc-ba", reverseOnlyLetters(S));
	}

	@Test 
	public void test_2(){
		String S = "a-bC-dEf-ghIj";
		assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters(S));
	}
}
