/**
 * @fileName: ContainsDuplicate.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 23, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc217;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: ContainsDuplicate.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 23, 2019
 * 
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return false;
		
		Arrays.sort(nums);
		int i = 1;
		while(i < len) {
			if (nums[i-1] == nums[i])
				return true;
			i++;
		}
		return false;
	}
	
	@Test
	public void Test_101() {
		int[] nums = new int[]{1,2,3,1};
		boolean expected = true;
		assertEquals(expected, containsDuplicate(nums));
	}
	
	@Test
	public void Test_102() {
		int[] nums = new int[]{1,2,3,4,5,6,7,8};
		boolean expected = false;
		assertEquals(expected, containsDuplicate(nums));
	}

}
