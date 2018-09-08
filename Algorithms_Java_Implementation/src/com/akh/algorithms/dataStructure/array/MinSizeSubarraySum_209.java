package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 *  @fileName: MinSizeSubarraySum.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 7, 2018
 *  
 *  Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

		Example: 

		Input: s = 7, nums = [2,3,1,2,4,3]
		Output: 2
		Explanation: the subarray [4,3] has the minimal length under the problem constraint.
		Follow up:
		If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */

public class MinSizeSubarraySum_209 {

	public int minSubArrayLen(int s, int[] nums) {
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int startIndx = 0;
		
		if(nums == null || nums.length <= 0)
			return 0;
		
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			
			while(sum >= s) {
				minLen = Math.min(minLen, i-startIndx+1);
				sum -= nums[startIndx++];
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	@Test
	public void test_1() {
		int[] nums = {2,3,1,2,4,3};
		int s = 7;
		int expected = 2;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Min SubArr Len for Sum >= "+s+" ==> "+minSubArrayLen(s, nums));
		assertEquals(expected, minSubArrayLen(s, nums));
	}
	
	@Test
	public void test_2() {
		int[] nums = {2,3,1,2,4,7};
		int s = 7;
		int expected = 1;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Min SubArr Len for Sum >= "+s+" ==> "+minSubArrayLen(s, nums));
		assertEquals(expected, minSubArrayLen(s, nums));
	}
	
	@Test
	public void test_3() {
		int[] nums = {1,2,3,4,5};
		int s = 11;
		int expected = 3;
		System.out.println("Arr - "+Arrays.toString(nums)+" - Min SubArr Len for Sum >= "+s+" ==> "+minSubArrayLen(s, nums));
		assertEquals(expected, minSubArrayLen(s, nums));
	}

}
