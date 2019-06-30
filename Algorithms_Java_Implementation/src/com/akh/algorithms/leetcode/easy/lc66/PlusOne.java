/**
 * @fileName: PlusOne.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 29, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc66;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @fileName: PlusOne.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 29, 2019
 * 
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		if (digits.length == 1 && digits[0] == 0) {
			return new int[] {1};
		}
		
		reverse(digits);
		
		int i = 0;
		int carry = 0;
		int digitPlus = 0;
		int addVal = 1;
		while(i < digits.length) {
			digitPlus = digits[i] + carry + addVal;
			if (digitPlus >= 10) {
				digits[i] = digitPlus%10;
				carry = digitPlus/10;
			}else{
				digits[i] = digitPlus;
				carry = 0;
			}
			addVal = 0;
			i++;
		}
		
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			for(int j=0; j<digits.length; j++) {
				res[j] = digits[j];
			}
			res[res.length-1] = carry;
			reverse(res);
			return res;
		}
		
		reverse(digits);
		return digits;
	}
	
	private void reverse(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	@Test
	public void Test_101() {
		int[] digits = {1,2,3};
		int[] expecteds = {1,2,4};
		assertArrayEquals(expecteds, plusOne(digits));
	}
	
	@Test
	public void Test_102() {
		int[] digits = {4,3,2,1};
		int[] expecteds = {4,3,2,2};
		assertArrayEquals(expecteds, plusOne(digits));
	}
	
	@Test
	public void Test_103() {
		int[] digits = {0};
		int[] expecteds = {1};
		assertArrayEquals(expecteds, plusOne(digits));
	}
	
	@Test
	public void Test_104() {
		int[] digits = {9,9,9};
		int[] expecteds = {1,0,0,0};
		assertArrayEquals(expecteds, plusOne(digits));
	}

}
