package com.akh.algorithms.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: ContainerWithMostWater.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 7, 2018
 *  
 *  Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */

public class ContainerWithMostWater {
	
	public static int mostWater(int[] heights){
		int len = heights.length-1;
		int left = 0;
		int right = len;
		int maxArea = Integer.MIN_VALUE;
		
		while(left < right){
			int minHeight = Math.min(heights[left], heights[right]);
			int width = right-left;
			maxArea = Math.max(maxArea, (minHeight * width));
			if(heights[left] > heights[right])
				right--;
			else
				left++;
		}
		return maxArea;
	}
	
	
	@Test
	public void test_1(){
		int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println("Most Water (MaxArea) --> "+mostWater(arr));
		assertEquals(49, mostWater(arr));
	}
}
