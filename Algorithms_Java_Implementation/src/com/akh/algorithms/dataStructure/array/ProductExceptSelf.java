/**
 * 
 */
package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;


/**
 * @author Akhash Ramamurthy
 * Jan 9, 2017
 */
public class ProductExceptSelf {

	/**
	 * You are given an array of integers(with all valid input) 
	 * You have to write a function which will produce another array, 
	 * where the value in each index of the array will be the product of all values in the given array accept that index. 
	 * Example 
	 * Array 1: 1 2 3 4 5 
	 * Array 2: 120 60 40 30 24. 
	 *
	 * Input:  [1,2,3,4]
	 * Output: [24,12,8,6]
	 *
	 * Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
	 */
	
	public int[] getProdArr_DivMethod(int[] data){
		int[] res = new int[data.length];
		int totalP = 1;
		for(int d : data){
			totalP = totalP * d;
		}
		for(int i = 0; i<data.length; i++){
			res[i] = totalP/data[i];
		}
		return res;
	}
	
	private int[] getProdArr_Non_DivMethod_N_SQUARE(int[] data){
		int[] res = new int[data.length];
		for(int i=0; i<data.length; i++) {
			int prod = 1;
			for(int j=0; j<data.length; j++) {
				prod = (i!=j) ? (prod*data[j]) : prod; 
			}
			res[i] = prod;
		}
		return res;
	}
	
	private int[] getProdArr_Non_Div_N(int[] nums) {
		System.out.println("\n\nInput - ");
		System.out.println(Arrays.toString(nums));
		int len = nums.length;
	    int [] output = new int[len];
	    int temp = 1;
	    for(int i=0; i<len; i++) {
	    	output[i] = temp;
	    	temp = temp * nums[i];
	    }
	    System.out.println("After Walking L to R - Contains all left element prods --> ");
	    System.out.println(Arrays.toString(output));
	    
	    temp = 1;
	    for(int j=len-1; j>=0; j--) {
	    	output[j] = output[j]*temp;
	    	temp = temp * nums[j];
	    }
	    System.out.println("After Walking R to L - Contains all right element prods (with left) --> ");
	    System.out.println(Arrays.toString(output));
	    
	    System.out.println("Output - ");
	    System.out.println(Arrays.toString(output));
	    return output; 
	}
	
	private int[] getProdArr_Non_Div_N_WithExtra_Mem(int[] nums) {
		System.out.println("\n\nInput - "+Arrays.toString(nums));
		int len = nums.length;
		int[] out = new int[len];
		
		int[] left = new int[len];
		left[0] = 1;
		int[] right = new int[len];
		right[len-1] = 1;
		
		for(int i=1; i<len; i++) {
			left[i] = nums[i-1] * left[i-1];
		}
		System.out.println("Left --> "+Arrays.toString(left));
		
		for(int i=len-2; i>=0; i--) {
			right[i] = nums[i+1] * right[i+1];
		}
		System.out.println("Right --> "+Arrays.toString(right));
		
		for(int i=0; i<len; i++) {
			out[i] = left[i] * right[i];
		}
		
		System.out.println("Output - "+Arrays.toString(out));
		return out;
	}	
	
	@Test
	public void test_N_SQUARE() {
		ProductExceptSelf productOfAllItemsInAnArray = new ProductExceptSelf();
		int[] input = {1,2,3,4};
		int[] output = productOfAllItemsInAnArray.getProdArr_Non_DivMethod_N_SQUARE(input);
		System.out.println("Output - "+Arrays.toString(output));
		int[] expected = {24,12,8,6};
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void test_N() {
		ProductExceptSelf productOfAllItemsInAnArray = new ProductExceptSelf();
		int[] input = {1,2,3,4};
		int[] output = productOfAllItemsInAnArray.getProdArr_Non_Div_N(input);
		int[] expected = {24,12,8,6};
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void test_N_2() {
		ProductExceptSelf productOfAllItemsInAnArray = new ProductExceptSelf();
		int[] input = {1,2,3,4,5,6};
		int[] output = productOfAllItemsInAnArray.getProdArr_Non_Div_N(input);
		int[] expected = {720,360,240,180,144,120};
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void test_N_With_Mem() {
		ProductExceptSelf productOfAllItemsInAnArray = new ProductExceptSelf();
		int[] input = {5,6,2,1,4,3};
		int[] output = productOfAllItemsInAnArray.getProdArr_Non_Div_N_WithExtra_Mem(input);
		int[] expected = {144, 120, 360, 720, 180, 240};
		assertArrayEquals(expected, output);
	}
	
}
