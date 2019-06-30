/**
 * @fileName: TwoSum.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 29, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc1;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @fileName: TwoSum.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 29, 2019
 * 
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		while(i < nums.length) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
			i++;
		}
		return new int[2];
	}
	
	
	@Test
	public void Test_101() {
		int[] nums = {2, 7, 11, 15};
		int[] expecteds = {0,1};
		int target = 9;
		assertArrayEquals(expecteds, twoSum(nums, target));
	}

	@Test
	public void Test_102() {
		int[] nums = {3,2,4};
		int[] expecteds = {1,2};
		int target = 6;
		assertArrayEquals(expecteds, twoSum(nums, target));
	}
	
	@Test
	public void Test_103() {
		int[] nums = {3,3};
		int[] expecteds = {0,1};
		int target = 6;
		assertArrayEquals(expecteds, twoSum(nums, target));
	}
}
