package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.akh.algorithms.dataStructure.array.LongestIncreasingSequence.ALGO_TYPE;

/**
 *  @fileName: CheckIfArrayIsIncreasingSquence.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 13, 2017
 *  
 *  
 *  Given a sequence of integers as an array, determine whether it is possible 
 *  to obtain a strictly increasing sequence by removing no more than one element from the array.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false;

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. 
Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
*/

public class CheckIfArrayIsIncreasingSquence {
	
	public boolean almostIncreasingSequence(int[] arr){
		int prev = arr[0];
		int deleteCount = 0;
		
		for(int i=1; i< arr.length; i++){
			if(arr[i] > prev){
				prev = arr[i];
			}else if(deleteCount == 0){
				deleteCount++;
				prev = Math.min(prev, arr[i]);
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void test_1() {
		CheckIfArrayIsIncreasingSquence incrSequence = new CheckIfArrayIsIncreasingSquence();
		int[] arr = new int[]{1, 3, 2, 1};
		System.out.println("Is Increasing Sequence - "+incrSequence.almostIncreasingSequence(arr));
		assertEquals(false, incrSequence.almostIncreasingSequence(arr));
	}
	
	@Test
	public void test_2() {
		CheckIfArrayIsIncreasingSquence incrSequence = new CheckIfArrayIsIncreasingSquence();
		int[] arr = new int[]{1, 3, 2};
		System.out.println("Is Increasing Sequence - "+incrSequence.almostIncreasingSequence(arr));
		assertEquals(true, incrSequence.almostIncreasingSequence(arr));
	}
	
	@Test
	public void test_3() {
		CheckIfArrayIsIncreasingSquence incrSequence = new CheckIfArrayIsIncreasingSquence();
		int[] arr = new int[]{3, 5, 67, 98, 3};
		System.out.println("Is Increasing Sequence - "+incrSequence.almostIncreasingSequence(arr));
		assertEquals(true, incrSequence.almostIncreasingSequence(arr));
	}
	
	@Test
	public void test_4() {
		CheckIfArrayIsIncreasingSquence incrSequence = new CheckIfArrayIsIncreasingSquence();
		int[] arr = new int[]{192, -90, -30, 2, 5, 6, 10, 25, 30};
		System.out.println("Is Increasing Sequence - "+incrSequence.almostIncreasingSequence(arr));
		assertEquals(true, incrSequence.almostIncreasingSequence(arr));
	}
	
	@Test
	public void test_5() {
		CheckIfArrayIsIncreasingSquence incrSequence = new CheckIfArrayIsIncreasingSquence();
		int[] arr = new int[]{1,2,5,9,6,7,4};
		System.out.println("Is Increasing Sequence - "+incrSequence.almostIncreasingSequence(arr));
		assertEquals(false, incrSequence.almostIncreasingSequence(arr));
	}	
}
