package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 *  @fileName: ReversingSentence.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 9, 2018
 *  Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
 */

public class ReversingSentence {
	
	public String reverseString(String s) {
		if(s.length() == 0 || s.length() == 1)
			return s;
		
		char[] charArr = s.toCharArray();
		int start = 0;
		int end = s.length()-1;
		while(start < end) {
			swap(charArr, start, end);
			start++;
			end--;
		}
		return new String(charArr);
	}
	
	private void swap(char[] arr, int from, int to) {
		char temp = arr[from];
		arr[from] = arr[to]; 
		arr[to] = temp;
	}
	
	
	@Test
	public void test_1() {
		ReversingSentence reversingSentence = new ReversingSentence();
		String s = "hello";
		String expected = "olleh";
		String actual = reversingSentence.reverseString(s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_2() {
		ReversingSentence reversingSentence = new ReversingSentence();
		String s = "A man, a plan, a canal: Panama";
		String expected = "amanaP :lanac a ,nalp a ,nam A";
		String actual = reversingSentence.reverseString(s);
		assertEquals(expected, actual);
	}
}
