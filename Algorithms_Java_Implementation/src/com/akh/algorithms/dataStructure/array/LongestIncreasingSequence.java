/*
 *  LongestIncreasingSequence.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jul 31, 2018
 */

package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

/**
 *  @fileName: LongestIncreasingSequence.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 31, 2018
 *  
 *  
	Given an unsorted array of integers, find the length of longest increasing subsequence.

	Example:

	Input: [10,9,2,5,3,7,101,18]
	Output: 4 
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	Note:

	There may be more than one LIS combination, it is only necessary for you to return the length.
	Your algorithm should run in O(n2) complexity.
	Follow up: Could you improve it to O(n log n) time complexity?
 */

/**
 * @author akhash
 *
 */
public class LongestIncreasingSequence {

	public enum ALGO_TYPE{
		BRUTE_FORCE,
		RECURSION, 
		N_SQUARE,
		N_LOG_N
	}

	public int lengthOfLIS(int[] nums, ALGO_TYPE algoType) {
		switch (algoType) {
		case BRUTE_FORCE:
			return lengthOfLIS_BruteForce(nums, Integer.MIN_VALUE, 0);
		case RECURSION:
			return lengthOfLIS_BruteForce(nums, Integer.MIN_VALUE, 0);
		case N_SQUARE:
			return lengthOfLIS_N_SQUARE(nums);
		case N_LOG_N:

		}		
		return 0;
	}


	/**
	 * Most important is the "prev".
	 * Even for 1st item set prev = Integer.MIN_VALUE
	 * Because the problem requires to compare 2 numbers
	 * Time: O(2^n) - At each "i" you find LIS with and without arr[i] and the take max. 
	 * Recursive call resembles Binary Tree
	 */
	private int lengthOfLIS_BruteForce(int[] nums, int prev, int currPos) {
		if(currPos == nums.length)
			return 0;

		int taken = 0; //LIS with currPos taken into consideration
		if(nums[currPos] > prev) {
			taken = 1 + lengthOfLIS_BruteForce(nums, nums[currPos], currPos+1);
		}

		//LIS withOUT currPos - Prev wont change. Just move pointer to next location
		int notTaken = lengthOfLIS_BruteForce(nums, prev, currPos+1); 

		return Math.max(taken, notTaken);
	}

	
	/**
	 * Create a helper array of length = inputArr
	 * Fill helper array with 1
	 * Helper arr will carry the longest sequence until index i ==> helper[i] --> longest sequence until index i
	 * Current result can be used to calculate future results
	 * Helper will get updated only when nums[i] > nums[j]
	 * 	- will be updated with Max(exisiting value or new val)
	 * 	- new value --> helper[j] + 1
	 */
	private int lengthOfLIS_N_SQUARE(int[] nums) {
		int[] longestUntilThatPoint =  new int[nums.length];
		Arrays.fill(longestUntilThatPoint, 1);
		
		for(int i=1; i<nums.length; i++) {
			for(int j=0; j<=i-1; j++) {
				if(nums[i] > nums[j]) {
					longestUntilThatPoint[i] = Math.max(longestUntilThatPoint[i], longestUntilThatPoint[j]+1);
				}
			}
		}
		
		int lis = 1;
		for(int k : longestUntilThatPoint) {
			lis = Math.max(lis, k); 
		}
		
		System.out.println("Helper -- "+Arrays.toString(longestUntilThatPoint));
		return lis;
	}

	@Ignore
	@Test 
	public void testLIS_BRUTE_FORCE() {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int[] arr = new int[]{10,9,2,5,3,7,101,18};
		System.out.println("LIS - "+lis.lengthOfLIS(arr, ALGO_TYPE.BRUTE_FORCE));
		assertEquals(4, lis.lengthOfLIS(arr, ALGO_TYPE.BRUTE_FORCE));
	}

	@Ignore
	@Test
	public void testLIS_RECURSION() {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int[] arr = new int[]{15, 27, 14, 38, 26, 55, 46, 65, 85};
		System.out.println("LIS - "+lis.lengthOfLIS(arr, ALGO_TYPE.RECURSION));
		assertEquals(6, lis.lengthOfLIS(arr, ALGO_TYPE.RECURSION));
	}
	
	@Test
	public void testLIS_N_SQUARE_1() {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int[] arr = new int[]{10,9,2,5,3,7,101,18};
		int result = lis.lengthOfLIS(arr, ALGO_TYPE.N_SQUARE);
		System.out.println("LIS - "+result);
		assertEquals(4, result);
	}

	@Test
	public void testLIS_N_SQUARE_2() {
		LongestIncreasingSequence lis = new LongestIncreasingSequence();
		int[] arr = new int[]{15, 27, 14, 38, 26, 55, 46, 65, 85};
		int result = lis.lengthOfLIS(arr, ALGO_TYPE.N_SQUARE);
		System.out.println("LIS - "+result);
		assertEquals(6, result);
	}


}
