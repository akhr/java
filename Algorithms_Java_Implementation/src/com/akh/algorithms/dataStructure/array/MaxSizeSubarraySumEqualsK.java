package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *  @fileName: MaxSizeSubarraySumEqualsK.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 29, 2018
 *  
 *  Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

		Note:
		The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
		
		Example 1:
		
		Input: nums = [1, -1, 5, -2, 3], k = 3
		Output: 4 
		Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
		Example 2:
		
		Input: nums = [-2, -1, 2, 1], k = 1
		Output: 2 
		Explanation: The subarray [-1, 2] sums to 1 and is the longest.
		Follow Up:
		Can you do it in O(n) time?
		 */

public class MaxSizeSubarraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length <=0)
			return 0;
		
		int sum = 0;
		int maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			
			if(sum == k) {
				maxLen = i+1;
			}
			
			int diff = sum - k;
			
			if(map.containsKey(diff)) {  
				// Diff - diff between new range sum AND one of the old range sum. 
				// If diff found then (i - map.get(diff)) will give the new range with start and end points
				maxLen = Math.max(maxLen, i - map.get(diff));
			
			}else if(!map.containsKey(sum)){ 
				// Check sum in map. 
				// If not only add. Dont override. Oldest will always generate longest subarray
				map.put(sum, i);
			}
			
		}
		return maxLen;
	}
	
	@Test
	public void test_1() {
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		int expected = 4;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_2() {
		int[] nums = {-2, -1, 2, 1};
		int k = 1;
		int expected = 2;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_3() {
		int[] nums = {0,0,0,0,0};
		int k = 0;
		int expected = 5;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_4() {
		int[] nums = {};
		int k = 3;
		int expected = 0;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_5() {
		int[] nums = null;
		int k = 3;
		int expected = 0;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_6() {
		int[] nums = {0,0,0,0,0,-1};
		int k = -1;
		int expected = 6;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
	
	@Test
	public void test_7() {
		int[] nums = {1,0,-1};
		int k = -1;
		int expected = 2;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Max SubArr Len for Sum Equals "+k+" ==> "+maxSubArrayLen(nums, k));
		assertEquals(expected, maxSubArrayLen(nums, k));
	}
}
