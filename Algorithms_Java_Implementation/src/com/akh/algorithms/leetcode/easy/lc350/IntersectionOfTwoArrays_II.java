/**
 * @fileName: IntersectionOfTwoArrays_II.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 23, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc350;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @fileName: IntersectionOfTwoArrays_II.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 23, 2019
 * 
 */
public class IntersectionOfTwoArrays_II {

	//Time: O(N+M) Space:O(N+M)
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];

		Map<Integer, Integer> map;
		if (nums1.length > nums2.length) {
			map = loadIntoMap(nums1); //O(N)
			return getIntersections(map, nums2); //O(M)
		} else {
			map = loadIntoMap(nums2);
			return getIntersections(map, nums1);
		}
	}

	private Map<Integer, Integer> loadIntoMap(int[] nums){
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		return map;
	}

	private int[] getIntersections(Map<Integer, Integer> map, int[] nums) {
		int[] res = new int[nums.length];
		int i = 0;
		for(int num : nums) {
			if (map.containsKey(num) && map.get(num) > 0) {
				res[i++] = num;
				map.put(num, map.get(num)-1);
			}
		}
		return Arrays.copyOf(res, i);
	}
	
	//How to optimize if the two arrays are sorted?
	
	
	
	
	@Test
	public void Test_101() {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] expecteds = {2,2};
		assertArrayEquals(expecteds, intersect(nums1, nums2));
	}

	@Test
	public void Test_102() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] expecteds = {4,9};
		assertArrayEquals(expecteds, intersect(nums1, nums2));
	}

}
