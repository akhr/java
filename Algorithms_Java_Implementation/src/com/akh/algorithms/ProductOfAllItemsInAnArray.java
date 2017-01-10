/**
 * 
 */
package com.akh.algorithms;

import java.util.Scanner;

import com.akh.algorithms.dynamicProgramming.maxSubarraySumModulo.MaxSubarraySumModulo.TestCaseData;

/**
 * @author Akhash Ramamurthy
 * Jan 9, 2017
 */
public class ProductOfAllItemsInAnArray {

	/**
	 * You are given an array of integers(with all valid input) 
	 * You have to write a function which will produce another array, 
	 * where the value in each index of the array will be the product of all values in the given array accept that index. 
	 * Example 
	 * Array 1: 1 2 3 4 5 
	 * Array 2: 120 60 40 30 24. 
	 * Come up with a solution of O(n^2) can you improve it?
	 */
	public static void main(String[] args) {
		int[] data = getInputs();
		int[] res = generateProductArray(data);
		for(int r : res){
			System.out.println(r);
		}
	}

	private static int[] getInputs(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array size :");
		int size = scanner.nextInt();
		int[] data = new int[size];
		System.out.println("Enter array data :");
		for(int i = 0; i < size; i++){
			data[i] = scanner.nextInt();
		}
		return data;
	}
	
	private static int[] generateProductArray(int[] data){
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

}
