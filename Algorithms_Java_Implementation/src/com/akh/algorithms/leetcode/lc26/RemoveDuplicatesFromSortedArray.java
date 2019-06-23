/**
 * @fileName: RemoveDuplicatesFromSortedArray.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 22, 2019
 * 
 */
package com.akh.algorithms.leetcode.lc26;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @fileName: RemoveDuplicatesFromSortedArray.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 22, 2019
 * 
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return 1;
		}
		int swapIndx = 1;
		int lastNum = nums[0];
		for (int num : nums) {
			if (num != lastNum) {
				lastNum = num;
				nums[swapIndx] = num;
				swapIndx++;
			}
		}
		return swapIndx;
	}


	@Test
	public void test_101() {
		RemoveDuplicatesFromSortedArray remoDups = new RemoveDuplicatesFromSortedArray();
		int[] in = new int[] {1,1,2};
		int res = remoDups.removeDuplicates(in);
		assertEquals(2, res);
	}
	
	@Test
	public void test_102() {
		RemoveDuplicatesFromSortedArray remoDups = new RemoveDuplicatesFromSortedArray();
		int[] in = new int[] {0,0,1,1,1,2,2,3,3,4};
		int res = remoDups.removeDuplicates(in);
		assertEquals(5, res);
	}
	
	@Test
	public void test_103() {
		RemoveDuplicatesFromSortedArray remoDups = new RemoveDuplicatesFromSortedArray();
		int[] in = new int[] {1,1,2};
		int res = remoDups.removeDuplicates(in);
		assertEquals(2, res);
	}
}
