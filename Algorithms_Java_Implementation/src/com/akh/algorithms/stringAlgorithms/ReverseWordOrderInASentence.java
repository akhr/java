package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.StringTokenizer;

import org.junit.Test;

/**
 *  @fileName: ReverseWordsInASentence.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 9, 2018
 */

public class ReverseWordOrderInASentence {
	public void reverseWords(char[] str) {
		int len = str.length;
		
		//Reverse full String
		reverse(str, 0, len-1);
		
		int start = 0;
		int end = 0;
		while(end < len) {
			if(end == str.length-1) {
				reverse(str, start, end);
				end++;
			}else if(str[end] == ' ') {
				reverse(str, start, end-1);
				start = end+1; //include 1 extra for space delimiter
				end = start;
			}else {
				end++;
			}
		}
	}
	
	public void reverse(char[] charArr, int start, int end) {
		int len = end - start;
		if(len == 0)
			return;
		
		while(start < end) {
			swap(charArr, start, end);
			start++;
			end--;
		}
	}
	
	private void swap(char[] arr, int from, int to) {
		char temp = arr[from];
		arr[from] = arr[to]; 
		arr[to] = temp;
	}
	
	
	@Test
	public void test_1() {
		ReverseWordOrderInASentence reverse = new ReverseWordOrderInASentence();
		char[] str =  {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		char[] expected = {'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
		reverse.reverseWords(str);
		assertArrayEquals(expected, str);
	}
}
