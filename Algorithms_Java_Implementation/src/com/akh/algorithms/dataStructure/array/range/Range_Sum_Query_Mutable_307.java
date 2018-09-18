package com.akh.algorithms.dataStructure.array.range;

import java.util.Arrays;

/**
 *  @fileName: Range_Sum_Query_Mutable_307.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 18, 2018
 *  
 *  Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

		The update(i, val) function modifies nums by updating the element at index i to val.

		Example:

		Given nums = [1, 3, 5]

		sumRange(0, 2) -> 9
		update(1, 2)
		sumRange(0, 2) -> 8
		Note:

		The array is only modifiable by the update function.
		You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class Range_Sum_Query_Mutable_307 {

	private int[] nums;
	private int[] segTree;

	public Range_Sum_Query_Mutable_307(int[] nums) throws IllegalArgumentException{
		if(nums == null || nums.length <= 0)
			throw new IllegalArgumentException("Input array cannot be null or empty");
		
		this.nums = nums;
		this.segTree = new int[getSegTreeSize(nums.length)];
		Arrays.fill(segTree, 0);
		constSTree(0, 0, nums.length-1);
		System.out.println("Segment Tree Constructed : "+Arrays.toString(segTree));
	}

	
	/************************************************* Construct SegmentTree ********************************************************/
	private int constSTree(int currN, int s, int e) {
		if(s == e) { //Leaf Node
			segTree[currN] = nums[s];
		}else { //Internal Sum Node
			int leftRes = constSTree(getLftChdIndx(currN), s, getMid(s, e));
			int rightRes = constSTree(getRghtChdIndx(currN), getMid(s, e)+1, e);
			segTree[currN] =  leftRes + rightRes;
		}
		return segTree[currN];
	}
	
	
	private int getMid(int start, int end) {
		return (end+start)/2;
	}
	
	private int getLftChdIndx(int parent) {
		return (2*parent)+1;
	}
	
	private int getRghtChdIndx(int parent) {
		return (2*parent)+2;
	}
	
	private int getParentIndx(int child) {
		return (child-1)/2;
	}
	
	private int getSegTreeSize(int n) {
		return (int)Math.pow(2, n) - 1;
		
		/*//Even count
		if(n%2 == 0) return (int)Math.pow(2, n) - 1;
		
		//Odd Count
		int res = (int)Math.pow(2, getNextPowOf2(n)) - 1;
		return res;*/
	}

	private int getNextPowOf2(int a) {
		int res = (int) Math.ceil(getLog2(a));
		return res + 1; //Next pow .. So add 1
	}

	private double getLog2(int a) {
		double res = Math.log(a)/Math.log(2);
		return res;
	}
	
	
	
	/************************************************* SumRange Query ********************************************************/
	public int sumRange(int i, int j) {
		if(i < 0 || i > nums.length-1)
			return -1;
		if(j < 0 || j > nums.length-1)
			return -1;
		
		return sumRangeHelper(0, 0, nums.length-1, i, j);
	}
	
	private int sumRangeHelper(int currN, int s, int e, int l, int r) {
		// No Overlap (l,r) eg (l,r)==>(2,6) (s,e)==>(14,17)
		if(l>e || r<s) 
			return 0;
		
		// Total Overlap eg (l,r)==>(2,6) (s,e)==>(3,6)||(3,5)
		if(l <= s && r >= e)
			return segTree[currN];
		
		//Partial Overlap eg (l,r)==>(2,6) (s,e)==>(3,9)
		int leftRes = sumRangeHelper(getLftChdIndx(currN), s, getMid(s, e), l, r);
		int rightRes = sumRangeHelper(getRghtChdIndx(currN), getMid(s, e)+1, e, l, r);
		return leftRes + rightRes;
	}

	
	
	
	/************************************************* Update nums and SegmentTree ********************************************************/
	public void update(int i, int val) {
		if(i < 0 || i > nums.length-1)
			return;
		
		updateHelper(0, 0, nums.length-1, i, val);
		System.out.println("Segment Tree After Update : "+Arrays.toString(segTree));
	}
	
	private int updateHelper(int currN, int s, int e, int upIndx, int newVal) {
		if(s == e) { //Leaf Node
			if(s == upIndx) {
				segTree[currN] = nums[s] = newVal;
			}
		}else { //Internal Sum Node			
			int leftUpdate = updateHelper(getLftChdIndx(currN), s, getMid(s, e), upIndx, newVal);
			int rightUpdate = updateHelper(getRghtChdIndx(currN), getMid(s, e)+1, e, upIndx, newVal);
			segTree[currN] = leftUpdate + rightUpdate;
		}
		return segTree[currN];
	}

}
