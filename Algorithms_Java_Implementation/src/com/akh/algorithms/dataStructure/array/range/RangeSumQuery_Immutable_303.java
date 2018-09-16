package com.akh.algorithms.dataStructure.array.range;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 *  @fileName: RangeSumQuery_Immutable_303.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 9, 2018
 *  
 *  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

		Example:
		Given nums = [-2, 0, 3, -5, 2, -1]

		sumRange(0, 2) -> 1
		sumRange(2, 5) -> -1
		sumRange(0, 5) -> -3
		Note:
		You may assume that the array does not change.
		There are many calls to sumRange function.
 */

public class RangeSumQuery_Immutable_303 {
	private int[] nums;

	public RangeSumQuery_Immutable_303(int[] nums) {
		this.nums = nums;   
		preProcess();
		System.out.println("Preprocess - "+Arrays.toString(nums));
	}

	public int sumRange(int i, int j) {
		if(i-1>=0)
			return nums[j] - nums[i-1];
		else
			return nums[j];
	}

	public void preProcess(){
		for(int i=1; i<nums.length; i++){
			nums[i] += nums[i-1];
		}
	}

	public static void main(String[] args){
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQuery_Immutable_303 rangeSumQuery = new RangeSumQuery_Immutable_303(nums);
		assertEquals(1, rangeSumQuery.sumRange(0, 2));
		assertEquals(-1, rangeSumQuery.sumRange(2, 5));
		assertEquals(-3, rangeSumQuery.sumRange(0, 5));
	}
}
