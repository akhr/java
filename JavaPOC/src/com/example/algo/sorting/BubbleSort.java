/**
 * 
 */
package com.example.algo.sorting;

/**
 * @author Akhash
 *
 */
public class BubbleSort {
	
	private static int noOfComparisons =0;
	
	public static int[] bubbleSort(int[] input){
		
		int temp;
		
		for(int i=0; i<input.length; i++){
			for(int j=0; j<input.length-i-1; j++){
				noOfComparisons++;
				if(input[j+1]<input[j]){
					temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
					
			}
		}
		
		System.out.println("*********************************No Of Comparisons = " +noOfComparisons  +"**********************");
		
		int[] output = input;
		return output;
	}

}
