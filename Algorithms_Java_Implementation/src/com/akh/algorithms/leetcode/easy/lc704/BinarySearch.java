/**
 * @fileName: BinarySearch.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 23, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc704;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @fileName: BinarySearch.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 23, 2019
 * 
 */
public class BinarySearch {

	public int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length-1);
	}
	
	private int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		
		int mid = (left+right)/2;
		if (nums[mid] == target) {
			return mid;
		} else if(target < nums[mid]) {
			return binarySearch(nums, target, left, mid-1);
		} else {
			return binarySearch(nums, target, mid+1, right);
		}
	}
	
	@Test
	public void Test_101() {
		int[] nums = {-1,0,3,5,9,12};
		int expected = 4;
		assertEquals(expected, search(nums, 9));
	}
	
	@Test
	public void Test_102() {
		int[] nums = {-1,0,3,5,9,12};
		int expected = -1;
		assertEquals(expected, search(nums, 2));
	}

}
