/**
 * @fileName: ReverseString.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jul 14, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc344;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * @fileName: ReverseString.java
 * @author: Akhash Ramamurthy
 * @Created on: Jul 14, 2019
 * 
 */
public class ReverseString {
	public static void reverseString(char[] s) {
		int start = 0;
		int end = s.length-1;
		while(start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
	
	@Test
	public void Test_101(){
		char[] s = {'h','e','l','l','o'};
		char[] expecteds = {'o','l','l','e','h'};
		reverseString(s);
		assertArrayEquals(expecteds, s);
	}

}
