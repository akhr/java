package com.akh.algorithms.stringAlgorithms.slidingWindow;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.SharedInputStream;

/**
 *  @fileName: Find_All_Anagrams_In_A_String_438.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 20, 2018
 *  
 *  
		Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

		Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

		The order of output does not matter.

		Example 1:

		Input:
		s: "cbaebabacd" p: "abc"

		Output:
		[0, 6]

		Explanation:
		The substring with start index = 0 is "cba", which is an anagram of "abc".
		The substring with start index = 6 is "bac", which is an anagram of "abc".
		Example 2:

		Input:
		s: "abab" p: "ab"

		Output:
		[0, 1, 2]

		Explanation:
		The substring with start index = 0 is "ab", which is an anagram of "ab".
		The substring with start index = 1 is "ba", which is an anagram of "ab".
		The substring with start index = 2 is "ab", which is an anagram of "ab".
 *  
 */

public class Find_All_Anagrams_In_A_String_438 {

	//Checkout 00_IMP_README.txt in this dir
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> resList = new ArrayList<>();
		
		if(s==null | p==null || s.length()<=0 || p.length()<=0 || p.length()>s.length())
			return resList;
		
		Map<Character, Integer> needToFind = new HashMap<>();

		for(char c : p.toCharArray()) {
			needToFind.put(c, needToFind.getOrDefault(c, 0)+1);
		}

		int left, right, requiredCharCount;
		left = right = 0;
		requiredCharCount = 0;

		//Window Expand
		while(right < s.length()) {
			
			char expandChar = s.charAt(right);
			if(needToFind.containsKey(expandChar)) {
				if(needToFind.get(expandChar) > 0) requiredCharCount++;
				needToFind.put(expandChar, needToFind.getOrDefault(expandChar, 0)-1);
			}
			
			//Window Shrink
			while(requiredCharCount == p.length()) {
				char shrinkChar = s.charAt(left);
				if(needToFind.containsKey(shrinkChar)) {
					if(needToFind.get(shrinkChar) == 0) requiredCharCount--;
					needToFind.put(shrinkChar, needToFind.getOrDefault(shrinkChar, 0)+1);
				}
				
				//Add Anagram to Results
				if(p.length() == right-left+1) {
					resList.add(left);
				}
				left++;
			}
			right++;
		}
		return resList;
	}
	
	
	@Test
	public void test_1() {
		String s = "cbaebabacd";
		String p= "abc";
		int[] expected = {0,6};
		int[] actual = findAnagrams(s, p).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void test_2() {
		String s = "abab";
		String p= "ab";
		int[] expected = {0,1,2};
		int[] actual = findAnagrams(s, p).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

}



























