/**
 * 
 */
package com.akh.algorithms.sorting.practice;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 8:12:25 PM
 * BubbleSorter.java
 */
public class BubbleSorter extends AbstractSorter implements Sorter {
	
	@Override
	public int[] sortArray(int[] array) {
		printArray("UN-sorted BubbleSort Array: ", array);
		int n = array.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n-i-1; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		printArray("Sorted BubbleSort Array: ", array);
		return array;
	}

}
