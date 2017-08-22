package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  @fileName: IsPatternASubString.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 21, 2017
 */

public class IsPatternASubString {

	public static boolean isSubString(String s, String p){

		int sIndex = 0;
		int pIndex = 0;
		boolean matchStarted = false;

		while(sIndex < s.length()-1){

			if(s.charAt(sIndex) == p.charAt(pIndex)){
				//Are in the middle of matching process and just getting started
				matchStarted = (pIndex == 0) ? true : matchStarted;

				//Increment both index pointers
				sIndex++;
				//If last char of pattern match exit returning true
				if(pIndex == p.length()-1)
					return true;
				pIndex++;
			}else{
				//Check if you are broken in the mid way while a matching started
				//If not in stop mid way then just incr sIndex and continue
				if(!matchStarted)
					sIndex++;
				else{
					String suffixPrefix = isSuffixIsAlsoAPrefix(p.substring(0, pIndex));
					if(suffixPrefix != null){
						pIndex = suffixPrefix.length();
					}else{
						//Reset match found flag and pIndex - start from O index of pattern
						pIndex = 0;
						matchStarted = false;
					}
				}
			}
		}
		return false;
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
	public void testValidInput_1(){
		String s = "ABCBABCBABDO";
		String p = "BABD";
		assertTrue(isSubString(s, p));
	}

	@Test
	public void testValidInput_2(){
		String s = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		String p = "AAAAA";
		assertTrue(isSubString(s, p));
	}

	@Test
	public void testFailure(){
		String s = "BBBBBBBBBBBBBBBB";
		String p = "AAAA";
		assertFalse(isSubString(s, p));
	}

	@Test
	public void testValidInput_3(){
		String s = "BBBBBBBBBBBBBBBBCDEFBBBBBCDEFGHBBB";
		String p = "BBBCDEFG";
		assertTrue(isSubString(s, p));
	}
	
	
	//Brute Force - O(N*M)
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

}
