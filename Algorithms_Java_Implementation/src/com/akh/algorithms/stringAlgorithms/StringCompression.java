package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCompression {

	/**
	 * Given an array of characters, compress it in-place.

		The length after compression must always be smaller than or equal to the original array.

		Every element of the array should be a character (not int) of length 1.

		After you are done modifying the input array in-place, return the new length of the array.


		Follow up:
		Could you solve it using only O(1) extra space?


		Example 1:
		Input:
		["a","a","b","b","c","c","c"]

		Output:
		Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

		Explanation:
		"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
		Example 2:
		Input:
		["a"]

		Output:
		Return 1, and the first 1 characters of the input array should be: ["a"]

		Explanation:
		Nothing is replaced.
		Example 3:
		Input:
		["a","b","b","b","b","b","b","b","b","b","b","b","b"]

		Output:
		Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

		Explanation:
		Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
		Notice each digit has it's own entry in the array.

		Note:
		All characters have an ASCII value in [35, 126].
		1 <= len(chars) <= 1000.
	 * 
	 */


	public int compress(char[] chars) {
		if(chars == null || chars.length <= 0)
			return 0;
		if(chars.length == 1)
			return 2;
		
		int lo = 0, hi = lo, lastWrite = -1;
		
		while(hi < chars.length) {
			char ch = chars[lo];
			while(hi<chars.length-1 && chars[hi+1] == ch) {
				hi++;
			}
			int count = hi - lo + 1;
			int tmpCnt = count, dCnt = 0;
			while(tmpCnt > 0) {
				dCnt++;
				tmpCnt /= 10;
			}
			
			if(hi < chars.length-1) {
				lastWrite += 1+1+dCnt;
			}
			lo = hi = hi+1;
		}
		return lastWrite+1;
	}
	
	@Test
	public void test_1() {
		StringCompression sCompress = new StringCompression();
		String input = "aaabbc";
		String output = "a3b2c1";
		System.out.println("Compressed String Length: "+sCompress.compress(input.toCharArray()));
		assertEquals(output.length(), sCompress.compress(input.toCharArray()));
	}
	
	@Test
	public void test_2() {
		StringCompression sCompress = new StringCompression();
		String input = "a";
		String output = "a1";
		System.out.println("Compressed String Length: "+sCompress.compress(input.toCharArray()));
		assertEquals(output.length(), sCompress.compress(input.toCharArray()));
	}
	
	@Test
	public void test_3() {
		StringCompression sCompress = new StringCompression();
		String input = "abc";
		String output = "a1b1c1";
		System.out.println("Compressed String Length: "+sCompress.compress(input.toCharArray()));
		assertEquals(output.length(), sCompress.compress(input.toCharArray()));
	}
	
	@Test
	public void test_4() {
		StringCompression sCompress = new StringCompression();
		String input = "aaaaaaaaaaaabbccc";
		String output = "a12b2c3";
		System.out.println("Compressed String Length: "+sCompress.compress(input.toCharArray()));
		assertEquals(output.length(), sCompress.compress(input.toCharArray()));
	}
}
