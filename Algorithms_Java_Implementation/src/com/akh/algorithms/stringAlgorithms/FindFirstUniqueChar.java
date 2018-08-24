package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 *  @fileName: FindFirstUniqueChar.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 9, 2018
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

public class FindFirstUniqueChar {
		
	public int firstUniqChar(String s) {
		if(s == null || s.length() == 0)
			return -1;
		
		s = s.toLowerCase();
		
		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else {
				map.put(c, 1);
			}
		}
		
		int index = -1;
		for(char c : s.toCharArray()) {
			index++;
			if(map.containsKey(c)) {
				if(map.get(c) == 1) {
					return index;
				}
			}
		}
		return -1;
	}
	
	@Test
	public void test_1() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "leetcode";
		assertEquals(0, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_2() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "loveleetcode";
		assertEquals(2, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_no_unique() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "aabbccdd";
		assertEquals(-1, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_null() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = null;
		assertEquals(-1, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_empty_string() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "";
		assertEquals(-1, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_uppercase() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "aaBcCdd";
		assertEquals(2, findFirstUniqueChar.firstUniqChar(s));
	}
	
	@Test
	public void test_number() {
		FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
		String s = "aa1cc1111112dd";
		assertEquals(11, findFirstUniqueChar.firstUniqChar(s));
	}

}
