/**
 * @fileName: RotateArray.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 23, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc189;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: RotateArray.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 23, 2019
 * 
 */
public class RotateArray {
	
//	Time: O(N) Space: O(1) 
 	public static void rotate_best_1(int[] nums, int k) {
 		int len = nums.length;
    	k = k % len; //If k > len then do % to fit the big number into the available indexes (0 - nums.length)
    	
    	int count = 0;
    	int currentIndx = 0;
    	int currentVal = nums[0];
    	int nextIndx = 0;
    	
    	while(count < len) {
    		nextIndx = (currentIndx + k) % len;
    		int temp = nums[nextIndx];
    		nums[nextIndx] = currentVal;
    		currentIndx = nextIndx;
    		currentVal = temp;
    		count++;
    	}
	}
 	
// 	Time: O(N) Space: O(1)
    public static void rotate_best_2(int[] nums, int k) {
//    	int len = nums.length;
//    	k = k % len; //If k > len then do % to fit the big number into the available indexes (0 - nums.length)
    	
    	reverse(nums, 0, nums.length-1);
    	reverse(nums, 0, k-1);
    	reverse(nums, k, nums.length-1);
    	
    }
    
    private static void reverse(int[] nums, int start, int end) {
    	while(start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
	
// 	Time: O(N) Space: O(N)
    public static void rotate_good(int[] nums, int k) {
    	int len = nums.length;
    	k = k % len; //If k > len then do % to fit the big number into the available indexes (0 - nums.length)    	
    	
    	int[] res = new int[nums.length];
    	int i = 0;
		int j = 0;
    	while(i < len ) {
    		j = (i+k < len) ? (i+k) : ((i+k)-len);
    		res[j] = nums[i];
    		i++;
    	}
    	for (int indx=0; indx<len; indx++) {
    		nums[indx] = res[indx];
    	}
    }
	
    @Test
    public void Test_101() {
    	int[] nums = new int[]{1,2,3,4,5,6,7};
    	rotate_good(nums, 3);
    	System.out.println(Arrays.toString(nums));
    	assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    }
    
    @Test
    public void Test_102() {
    	int[] nums = new int[]{1,2,3,4,5,6,7};
    	rotate_best_1(nums, 3);
    	System.out.println(Arrays.toString(nums));
    	assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    }
    
    @Test
    public void Test_103() {
    	int[] nums = new int[]{1,2,3,4,5,6,7};
    	rotate_best_2(nums, 3);
    	System.out.println(Arrays.toString(nums));
    	assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    }
    
    @Test
    public void Test_104() {
    	int[] nums = new int[]{4};
    	rotate_best_2(nums, 2);
    	System.out.println(Arrays.toString(nums));
    	assertArrayEquals(new int[]{4}, nums);
    }
    
    
}
