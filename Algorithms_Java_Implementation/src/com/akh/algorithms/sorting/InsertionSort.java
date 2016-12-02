/**
 * 
 */
package com.akh.algorithms.sorting;

/**
 * @author Akhash
 *
 */
public class InsertionSort {

	private static int noOfComparisons =0;

	public static int[] insertionSort(int[] input){

		int length = input.length;
		int temp;

		for(int i=1; i<length; i++){
			for(int j=i; j>0; j--){
				noOfComparisons++;
				if(input[j]<input[j-1]){
					temp = input[j];
					input[j]= input[j-1];
					input[j-1] = temp;
				}else
					break;

			}
		}


		System.out.println("*********************************No Of Comparisons = " +noOfComparisons  +"**********************");
		int[] output = input;
		return output;
	}


	public static int[] insertionSort2(int[] input){

		for(int keyIndex=1; keyIndex<input.length; keyIndex++){
			for(int subArrayIndex=keyIndex; subArrayIndex>0; subArrayIndex--){
				noOfComparisons++;
				if(input[subArrayIndex] < input[subArrayIndex-1]){
					int temp = input[subArrayIndex];
					input[subArrayIndex] = input[subArrayIndex-1];
					input[subArrayIndex-1] = temp;
				}else
					break;

			}

		}
		System.out.println("*********************************No Of Comparisons = " +noOfComparisons  +"**********************");
		int[] output = input;
		return output;

	}

}
