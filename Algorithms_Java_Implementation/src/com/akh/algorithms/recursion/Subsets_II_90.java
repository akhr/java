package com.akh.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 *  @fileName: Subsets_II_90.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 3, 2018
 *  
 *  Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

		Note: The solution set must not contain duplicate subsets.

		Example:

		Input: [1,2,2]
		Output:
		[
		  [2],
		  [1],
		  [1,2,2],
		  [2,2],
		  [1,2],
		  []
		]
 */

public class Subsets_II_90 {

	public List<List<Integer>> subsetsWithDup_DFS_Recursive(int[] nums) {
		if(nums == null | nums.length <= 0)
			return new ArrayList<>();

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		dfs_Pre_Recursive(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void dfs_Pre_Recursive(int[] nums, int position, List<Integer> tempList, List<List<Integer>> res){
		if(position == nums.length){
			res.add(new ArrayList<Integer>(tempList));
			return;
		}

		// (Refer ./Subset_II_90_Tree.jpeg)
		// 1. Looking into the tree that is getting created will give a clear picture (Refer ./Subset_II_90_Tree.jpeg)
		// 2. Left Child is created by not adding nums[current pos]
		// 3. Do not create left child if the tempList's last added item == nums[current pos]
		// 4. Applies only to left child.

		// Strategy can be changed to eliminate the duplicate RIGHT child but comparatively tougher than getting rid of left.
		if(tempList.isEmpty() || tempList.get(tempList.size()-1) != nums[position]){
			//Left Child
			dfs_Pre_Recursive(nums, position+1, tempList, res);
		}

		//Right Child
		tempList.add(nums[position]);
		dfs_Pre_Recursive(nums, position+1, tempList, res);		
		tempList.remove(tempList.size()-1);
	}

	public List<List<Integer>> subsetsWithDup_DFS_Iterative(int[] nums) {
		if(nums == null | nums.length <= 0)
			return new ArrayList<>();

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		Stack<Integer> levelStack = new Stack<>();
		List<Integer> tempList = new ArrayList<>();
		levelStack.push(0);

		while(!levelStack.isEmpty()){
			int pos = levelStack.pop();

			if(pos == nums.length){
				res.add(new ArrayList<>(tempList));
				if(!tempList.isEmpty()){
					tempList.remove(tempList.size()-1);
				}
				continue;
			}

			//Right Child
			tempList.add(nums[pos]);
			levelStack.push(pos+1);
			
			//Left Child
			if(tempList.isEmpty() || tempList.get(tempList.size()-1) != nums[pos]){
				levelStack.push(pos+1);
			}
		}
		return res;
	}


	@Test
	public void subSet_1() {
		int[] nums = {1,2,2};
		List<List<Integer>> actual = subsetsWithDup_DFS_Recursive(nums);
		System.out.println("Result : "+Arrays.toString(actual.toArray()));
	}

	@Test
	public void subSet_2() {
		int[] nums = {1,2,2};
		List<List<Integer>> actual = subsetsWithDup_DFS_Iterative(nums);
		System.out.println("Result : "+Arrays.toString(actual.toArray()));
	}
}
