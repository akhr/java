/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 * Dec 29, 2016
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class MaxSubarraySum_KadaneAlgorithm {

	public int[] getMaxSubarraySum(int[] arr){
		int[] res = new int[3];
		int tempSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;

		for(int i=0; i<arr.length; i++){
			// If the a[i] takes tempSum below 0 then it means
			// a[i] nullifies all effect until that point. (sum of all +ve numbers so far < a[i])
			// So exclude a[i] and restart from next point
			if(tempSum + arr[i] < 0){
				tempSum = 0;
				start = i+1;
			}else{
				tempSum += arr[i];
				
				//Update maxSum and move endIndex only if the new sum is greater than maxSum
				//Eg 10, -2, -3, -1, -2, 16
				// maxS = 10,  endIndex = 1
				// tempS = 8 -- no update -- wait -- move to next
				// tempS = 5 -- no update -- wait -- move to next
				// tempS = 4 -- no update -- wait -- move to next
				// tempS = 2 -- no update -- wait -- move to next
				// tempS = 18 -- update -- maxS = 16, endIndex = 5
				// loop exits
				
				if(tempSum > maxSum){
					maxSum = Math.max(tempSum, maxSum);
					end=i;
				}
			}
		}

		res[0] = maxSum;
		res[1] = start;
		res[2] = end;
		return res;
	}

	@Test
	public void test_1(){
		int[] arr = new int[]{-10, 30, -5, 4, 6, -1, 2, -7, 1, -3};
		int[] res = getMaxSubarraySum(arr);
		System.out.println("Max sum = "+res[2]);
		System.out.println("Max sum start index = "+res[0]);
		System.out.println("Max sum end index = "+res[1]);
		assertEquals("MaxSum : ", 36, res[0]);
		assertEquals("Start : ", 1, res[1]);
		assertEquals("End : ", 6, res[2]);
		for(int i = res[0]; i<=res[1]; i++){
			System.out.println(arr[i]);
		}
	}
	
	@Test
	public void test_2(){
		int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int[] res = getMaxSubarraySum(arr);
		System.out.println("Max sum = "+res[2]);
		System.out.println("Max sum start index = "+res[0]);
		System.out.println("Max sum end index = "+res[1]);
		assertEquals("MaxSum : ", 6, res[0]);
		assertEquals("Start : ", 3, res[1]);
		assertEquals("End : ", 6, res[2]);
		for(int i = res[0]; i<=res[1]; i++){
			System.out.println(arr[i]);
		}
	}

}
