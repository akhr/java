package com.akh.algorithms.stringAlgorithms.slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *  @fileName: Longest_Substring_WO_Repeating_3.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 20, 2018
 *  
 *  Given a string, find the length of the longest substring without repeating characters.

		Example 1:

		Input: "abcabcbb"
		Output: 3 
		Explanation: The answer is "abc", with the length of 3. 
		Example 2:

		Input: "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:

		Input: "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3. 
		             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Longest_Substring_WO_Repeating_3 {
	
	// Counter in this class keeps track of the UNIQUEness of the window. 
	// If uniqueness is broken then it increments. 
	// You need to shrink window inorder and make counter == 1 to restore UNIQUEness
	

	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()<=0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		int left, right;
		left = right = 0;
		int uniquenessBrokenCounter = 0; //If this counter == 0 then window contains only UNIQUE chars
		int maxLen = Integer.MIN_VALUE;

		//Window EXPAND
		while(right < s.length()) {
			char scannedChar = s.charAt(right);
			map.put(scannedChar, map.getOrDefault(scannedChar, 0)+1);
			if(map.get(scannedChar) > 1) 
				uniquenessBrokenCounter++;
			right++;
			
			//Window SHRINK
			while(uniquenessBrokenCounter > 0) {
				char shrinkChar = s.charAt(left);
				map.put(shrinkChar, map.get(shrinkChar)-1);
				if(map.get(shrinkChar) > 0)
					uniquenessBrokenCounter--;
				left++;				
			}
			
			maxLen = Math.max(maxLen, right-left);
			
		}
		return maxLen;
	}
	
	
	@Test
	public void test_1() {
		String s = "abcabcbb";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_2() {
		String s = "bbbbb";
		int expected = 1;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_3() {
		String s = "pwwkew";
		int expected = 3;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_4() {
		String s = "au";
		int expected = 2;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
	@Test
	public void test_5() {
		String s = "aab";
		int expected = 2;
		assertEquals(expected, lengthOfLongestSubstring(s));
	}
	
}
