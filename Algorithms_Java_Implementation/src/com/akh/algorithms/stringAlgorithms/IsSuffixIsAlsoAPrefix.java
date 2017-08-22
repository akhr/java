package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  @fileName: IsSuffixIsAlsoAPrefix.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 21, 2017
 */

public class IsSuffixIsAlsoAPrefix {

	public static void main(String[] args) {
		String input = "ACACABACACABACACACX";
		System.out.println("Is Suffix Is Also A Prefix : "+isSuffixIsAlsoAPrefix(input));
	}
	
	public static String isSuffixIsAlsoAPrefix(String input){
		
		if(input == null || input.length() == 1)
			return null;
		
		int mid = input.length()/2;
		int left = mid-1;
		int right = input.length()-1;
		int matchCharCount = -1;
		
		while(left >= 0){
			if(input.charAt(left) == input.charAt(right)){
				matchCharCount = (matchCharCount == -1) ? left+1 : matchCharCount;
				left--;
				right--;
			}else{
				matchCharCount = -1;
				left--;
			}
		}
		return (matchCharCount != -1) ? input.substring(0, matchCharCount) : null;
	}
	
	@Test
	public void testMatch(){
		String input = "ABCDEFABC";
		assertEquals("ABC", isSuffixIsAlsoAPrefix(input));
	}
	
	@Test
	public void testMatch_2(){
		String input = "ACACABACACABACACAC";
		assertEquals("ACAC", isSuffixIsAlsoAPrefix(input));
	}
	
	@Test
	public void testNotMatch(){
		String input = "ACACABACACABACACACX";
		assertNull(isSuffixIsAlsoAPrefix(input));
	}

}
