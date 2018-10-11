package com.akh.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

	public List<List<Integer>> subsets_DFS_Recursive(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> input = new ArrayList<>();
		// Start with empty input (input.size == 0) to recursion
		// input is the key to these recursive calls
		// Inside recursive func... 
		// 1.You will do/add something to the input and call its children passing the new input 
		dfs_Recursive(nums, 0, input, result);
		return result;
	}

	private void dfs_Recursive(int[] nums, int position, List<Integer> input, List<List<Integer>> result) {

		// base case
		// If (position ==  nums.length) it means we have no other item in nums[] to go further down
		// Its a good time to RECORD the result of this branch to results[].. So
		if(position == nums.length) {
			result.add(new ArrayList<>(input));
			return;
		}

		// Case 1 - Do not include self(nums[postion]) in input... 
		// So directly call next recursion call and pass input without changes (as it was received)
		dfs_Recursive(nums, position+1, input, result);
		//Once this step is complete, subSet would have been added to all[]

		//Case 2 - Including nums[position] in subset.. add to subset and then go to next recursive call
		input.add(nums[position]);
		dfs_Recursive(nums, position+1, input, result);
		//Once this step is complete, subSet would have been added to all[]

		//While returning from this TREE LEVEL give oneResult as it was received. Remove nums[position] added to oneResult 
		input.remove(input.size()-1);
	}
	
	public List<List<Integer>> subsets_DFS_Iterative(int[] nums) {
		if(nums == null || nums.length <= 0)
			return new ArrayList<>();
		
		List<List<Integer>> res = new ArrayList<>();

		Stack<Integer> levelStack = new Stack<>();
		List<Integer> tempList = new ArrayList<>();
		levelStack.push(0);
		
		int listCnt = 0;
		
		while(!levelStack.isEmpty()){
			int pos = levelStack.pop();
			if(pos == nums.length){
				listCnt++;
				res.add(new ArrayList<>(tempList));
				if(!tempList.isEmpty())
					tempList.remove(tempList.size()-1);
				continue;
			}
			
			levelStack.push(pos+1);
			
			tempList.add(nums[pos]);
			levelStack.push(pos+1);
		}
		System.out.println("# of Lists created : "+listCnt);
		return res;
	}
	
/*	public List<List<Integer>> subsets_BFS(int[] nums) {
		if(nums == null || nums.length <= 0)
			return new ArrayList<>();
		
		List<List<Integer>> res = new ArrayList<>();
		Queue<Integer> levelQueue = new LinkedList<>();
	}
*/

	@Test
	public void subSet_1() {
		int[] nums = {1,2,3};
		List<List<Integer>> actual = subsets_DFS_Recursive(nums);
		System.out.println("Result : "+Arrays.toString(actual.toArray()));
	}
	
	@Test
	public void subSet_2() {
		int[] nums = {1,2,3};
		List<List<Integer>> actual = subsets_DFS_Iterative(nums);
		System.out.println("Result : "+Arrays.toString(actual.toArray()));
	}
}
