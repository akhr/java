package com.akh.algorithms.searching;
/**
 * @author Akhash
 *
 */
public class LinearSearch {
	
	public static int linearSearch(int[] input, int target){
		
		for(int i=0; i<input.length-1; i++){
			if(input[i] == target)
				return i;
		}
		return -1;
	}
}
