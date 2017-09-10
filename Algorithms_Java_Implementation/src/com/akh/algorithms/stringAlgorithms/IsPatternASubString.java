package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 *  @fileName: IsPatternASubString.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 21, 2017
 */

public class IsPatternASubString {
	
	/********************************* Brute Force - O(N*M) ******************************************************/
		public static boolean containsSubString_bruteForce(String string, String pattern){
			int iLength = string.length();
			int pLength = pattern.length();
			int matchStartIndex = -1;

			for(int i=0; i<iLength-pLength; i++){
				int iIndex = i, pIndex = 0;
				while(pIndex < pLength){
					if(string.charAt(iIndex) == pattern.charAt(pIndex)){
						if(pIndex == 0)
							matchStartIndex = iIndex;
						iIndex++;
						pIndex++;
					}else{
						if(matchStartIndex == -1){
							iIndex++;
						}else{
							matchStartIndex = -1;
							break;
						}
						pIndex = 0;
					}
				}
			}
			return matchStartIndex != -1;
		}
		
	/**************************************** Knuth Morris Pratt (KMP) ***************************************************
	 * Overall - O(N+M); N->text.len; M->pattern.len
	 * Step 1 - Construct SuffixPrefixArray O(M)
	 */
	public static int[] contructSuffixPrefixArray(String p){
		int index=0;
		int[] lps = new int[p.length()];
		
		for(int j=1; j < p.length();) //j shd not be automatically incremented
		{
			if(p.charAt(index) == p.charAt(j))
			{
				lps[j] = index+1;
				index++;
				j++;
			}else
			{
				if(index > 0){
					index = lps[index-1];
				}else{
					lps[j] = 0;
					j++;
				}
			}
		}
		System.out.println("PrefixSuffixArray : "+Arrays.toString(lps));
		return lps;
	}
	
	/**
	* Step 2 - Using SuffixPrefixArray compare text and pattern
	* O(N)
	*/
	public static boolean isSubString_KMP_Impl(String s, String p){
		int sIndex = 0;
		int pIndex = 0;
		int[] suffixPrefixArr = contructSuffixPrefixArray(p);
			
		while(sIndex < s.length() && pIndex < p.length()){
			if(s.charAt(sIndex) == p.charAt(pIndex)){
				if(pIndex == p.length()-1){
					//Found pattern
					return true;
				}else{
					sIndex++;
					pIndex++;
				}
			}else{
				if(pIndex != 0){
					pIndex = suffixPrefixArr[pIndex-1];
				}else{
					pIndex = 0;
					sIndex++;
				}
			}
		}
		return false;
	}
	
	
	/***************************************** Test Cases ******************************************************/
	@Test
	public void testValidInput_1(){
		String s = "ABCBABCBABDO";
		String p = "BABD";
		assertTrue(isSubString_KMP_Impl(s, p));
	}

	@Test
	public void testValidInput_2(){
		String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String p = "AAAAA";
		assertTrue(isSubString_KMP_Impl(s, p));
	}

	@Test
	public void testFailure(){
		String s = "BBBBBBBBBBBBBBBB";
		String p = "AAAA";
		assertFalse(isSubString_KMP_Impl(s, p));
	}

	@Test
	public void testValidInput_3(){
		String s = "BBBBBBBBBBBBBBBBCDEFBBBBBCDEFGHBBB";
		String p = "BBBCDEFG";
		assertTrue(isSubString_KMP_Impl(s, p));
	}
	
	@Test
	public void testValidInput_4(){
		String s = "abcxabcdabcdabcy";
		String p = "abcdabcy";
		assertTrue(isSubString_KMP_Impl(s, p));
	}
	
	@Test
	public void testValidInput_5(){
		String s = "ABCXABCDABXABCDABCDABCY";
		String p = "ABCDABC";
		assertTrue(isSubString_KMP_Impl(s, p));
	}
	
	@Test
	public void testValidInput_6(){
		String s = "ABCXABCDABXABCDABCDABCY";
		String p = "ABCDABCH";
		assertFalse(isSubString_KMP_Impl(s, p));
	}

	@Test
	public void testContructSuffixPrefixArray_1(){
		String pattern = "ACACABACACABACACAC";
		int[] expected = new int[]{0,0,1,2,3,0,1,2,3,4,5,6,7,8,9,10,11,4};
		assertArrayEquals(expected, contructSuffixPrefixArray(pattern));
	}
	
}
