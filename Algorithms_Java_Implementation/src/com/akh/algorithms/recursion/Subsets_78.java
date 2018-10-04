package com.akh.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *  @fileName: Subsets_78.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 3, 2018
 *  
 *  Given a set of distinct integers, nums, return all possible subsets (the power set).

		Note: The solution set must not contain duplicate subsets.

		Example:

		Input: nums = [1,2,3]
		Output:
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
]
 */



public class Subsets_78 {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> all = new ArrayList<>();
		List<Integer> oneResult = new ArrayList<>();
		dfs(nums, 0, oneResult, all);
		return all;
	}

	private void dfs(int[] nums, int position, List<Integer> oneResult, List<List<Integer>> all) {

		// base case
		// If gone past leaf node the its time to 
		// 1. Create new subSet
		// 2. Copy contents of oneResult to new subSet
		// 3. return
		if(position == nums.length) {
			List<Integer> newSubset = new ArrayList<>();
			newSubset.addAll(oneResult);
			all.add(newSubset);
			return;
		}

		//Case 1 - Not including nums[position] in subset.. direct go to next recursive call
		dfs(nums, position+1, oneResult, all);
		//Once this step is complete, subSet would have been added to all[]

		//Case 2 - Including nums[position] in subset.. add to subset and then go to next recursive call
		oneResult.add(nums[position]);
		dfs(nums, position+1, oneResult, all);
		//Once this step is complete, subSet would have been added to all[]

		//While returning from this TREE LEVEL give oneResult as it was received. Remove nums[position] added to oneResult 
		oneResult.remove(oneResult.size()-1);
	}


	@Test
	public void subSet_1() {
		int[] nums = {1,2,3};
		List<List<Integer>> actual = subsets(nums);
		System.out.println("Result : "+Arrays.toString(actual.toArray()));
	}
}
