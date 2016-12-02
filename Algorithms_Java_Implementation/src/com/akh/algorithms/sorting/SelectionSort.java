/**
 * 
 */
package com.akh.algorithms.sorting;

/**
 * @author Akhash
 *
 */
public class SelectionSort {
	
	public static int[] selectionSort(int[] input){
		int[] output = new int[input.length];
		int min;
		int temp;
		int counter =0 ;
		for(int i=0; i<input.length; i++){
			min = i;
			
			// This loop is to find the least element's index in array
			for(int j=i+1; j<input.length; j++){
				counter++;
				if(input[j]<input[min])
					min=j;
			}
			
			//Once least element's index is found swap to front of the array
			temp =input[i];
			input[i]=input[min];
			input[min]=temp;
		}
		 output = input;
		 System.out.println("No of Comparisons Selection Sort : "+ counter);
		return output;
	}
}
