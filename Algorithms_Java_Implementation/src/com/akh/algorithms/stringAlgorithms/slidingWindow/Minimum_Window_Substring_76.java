package com.akh.algorithms.stringAlgorithms.slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *  @fileName: Minimum_Window_Substring_76.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 19, 2018
 *  
 *  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

		Example:

		Input: S = "ADOBECODEBANC", T = "ABC"
		Output: "BANC"
		Note:

		If there is no such window in S that covers all characters in T, return the empty string "".
		If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 */

public class Minimum_Window_Substring_76 {

	public String minWindow_Using_1_Map_Best(String s, String t) {
		if( s==null || t==null ||  s.length() <= 0 || t.length() <=0 || t.length()>s.length())
			return "";

		Map<Character, Integer> needToFind = new HashMap<>();

		for(char c : t.toCharArray()) {
			needToFind.put(c, needToFind.getOrDefault(c, 0)+1);
		}

		int minLen = Integer.MAX_VALUE;
		int minLenIndx = 0;
		int reqCharsCount = 0;
		int left, right;
		left = right = 0;

		while(right < s.length()) {

			char expandChar = s.charAt(right);
			if(needToFind.containsKey(expandChar)) {
				if(needToFind.get(expandChar) > 0){ 
					// One valid char found
					reqCharsCount++;
				}
				//If more than required then MAP val will be negative. STARRED_STEP 1
				needToFind.put(expandChar, needToFind.get(expandChar)-1); 
			}
			/** At end of this step MAP val shd be 
			 * 		-	'0' for required and found exact count 
			 * 		-	'-ve' for required and found extra count
			 */
			

			//Requirement of 't' satisfied - Now cut down junk chars
			while(left <= right && reqCharsCount == t.length()) {
				
				//Calculate the min window length
				if(minLen > right-left+1) {
					minLen = Math.min(minLen, right-left+1);
					minLenIndx = left;
				}
				
				char shrinkChar = s.charAt(left);
				if(needToFind.containsKey(shrinkChar)) {
					if(needToFind.get(shrinkChar) == 0) {
						// One valid char lost
						reqCharsCount--;
					}
					// Reverse of STARRED_STEP 1
					// If extra count then Map.value will incr from negative towards 0
					needToFind.put(shrinkChar, needToFind.get(shrinkChar)+1);
				}
				left++;
			}
			//Do at the bottom. Or else will mess up minLen calculation
			right++;
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minLenIndx, minLenIndx+minLen);
	}

	@Test
	public void test_1() {
		String s = "acbbaca";
		String t = "aba";
		String expected = "baca";
		assertEquals(expected, minWindow_Using_1_Map_Best(s, t));
	}
	
	@Test
	public void test_2() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String expected = "BANC";
		assertEquals(expected, minWindow_Using_1_Map_Best(s, t));
	}
	
	@Test
	public void test_3() {
		String s = "a";
		String t = "aa";
		String expected = "";
		assertEquals(expected, minWindow_Using_1_Map_Best(s, t));
	}
	
	@Test
	public void test_4() {
		String s = "a";
		String t = "b";
		String expected = "";
		assertEquals(expected, minWindow_Using_1_Map_Best(s, t));
	}
	
	@Test
	public void test_5() {
		String s = "abcdefghyyyyyyyyijklmnopqrstuvwxyzabcdopqrstuvwxyzabcdefghiaaaaaaaaabbbbbbbjklmcccccccccccnopqrstuvwefghijklmnxyz";
		String t = "efijmn";
		String expected = "efghijklmn";
		assertEquals(expected, minWindow_Using_1_Map_Best(s, t));
	}
	
	
	
	
	
	//*********************************  Using 2 Maps ****************************************************
	public String minWindow_Using_2_Maps(String s, String t) {
		if( s==null || t==null ||  s.length() <= 0 || t.length() <=0 || t.length()>s.length())
			return "";

		Map<Character, Integer> hasFound = new HashMap<>();
		Map<Character, Integer> needToFind = new HashMap<>();

		for(char c : t.toCharArray()) {
			needToFind.put(c, needToFind.getOrDefault(c, 0)+1);
		}

		int minLen = Integer.MAX_VALUE;
		int minLenIndx = 0;
		int counter = 0;
		int left, right;
		left = right = 0;

		while(right < s.length()) {

			char expandChar = s.charAt(right);
			if(needToFind.containsKey(expandChar)) {
				if(needToFind.get(expandChar) > hasFound.getOrDefault(expandChar, 0))
					counter++;
				hasFound.put(expandChar, hasFound.getOrDefault(expandChar, 0)+1);
			}

			while(left <= right && counter == t.length()) {
				if(minLen > right-left+1) {
					minLen = Math.min(minLen, right-left+1);
					minLenIndx = left;
					System.out.println("Found a minLen - "+minLen+" starting @ "+minLenIndx);
				}
				
				char shrinkChar = s.charAt(left);
				if(needToFind.containsKey(shrinkChar)) {
					if(needToFind.get(shrinkChar) == hasFound.get(shrinkChar)) {
						counter--;
					}
					hasFound.put(shrinkChar, hasFound.get(shrinkChar)-1);
				}
				left++;
			}
			right++;
		}

		if(minLen == Integer.MAX_VALUE) return "";
		return s.substring(minLenIndx, minLenIndx+minLen);
	}
	
}
