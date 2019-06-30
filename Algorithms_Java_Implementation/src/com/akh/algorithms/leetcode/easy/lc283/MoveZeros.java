/**
 * @fileName: MoveZeros.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 29, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc283;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: MoveZeros.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 29, 2019
 * 
 */
public class MoveZeros {
	
	public void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				i++;
			}
			j++;
		}
		
		Arrays.fill(nums, i, nums.length, 0);
	}
	
	@Test
	public void Test_101() {
		int[] nums = {0,1,0,3,12};
		int[] expecteds = {1,3,12,0,0};
		moveZeroes(nums);
		assertArrayEquals(expecteds, nums);
	}

}
