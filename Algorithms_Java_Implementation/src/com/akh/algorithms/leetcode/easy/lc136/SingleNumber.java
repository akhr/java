/**
 * @fileName: SingleNumber.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 23, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc136;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: SingleNumber.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 23, 2019
 * 
 */
public class SingleNumber {

	public int singleNumber_best(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		
		int i = 0;
		int x = 0;
		while(i < len) {
			x ^= nums[i];
			i++;
		}
		return x;
	}
	
	
	public int singleNumber_good(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		Arrays.sort(nums);
		
		int i = 0;
		while(i < len-1) {
			if(nums[i] == nums[i+1]) {
				i = i+2;
				continue;
			}else {
				return nums[i];
			}
		}
		return nums[i];
	}
	
	@Test
	public void Test_101() {
		int[] nums = new int[]{2,2,1};
		int expected = 1;
		assertEquals(expected, singleNumber_best(nums));
	}
	
	@Test
	public void Test_102() {
		int[] nums = new int[]{4,1,2,1,2};
		int expected = 4;
		assertEquals(expected, singleNumber_best(nums));
	}

	/*	public int singleNumber(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];

		Arrays.sort(nums);
		boolean findPair = true;
		int i = 1;
		int item = nums[0];

		while(i < len) {
			if(findPair) {
				if(nums[i] != item) {
					return item; //Its a single item without pair. Return it
				}else {

				}
			}else {

			}
		}
	}*/
}
