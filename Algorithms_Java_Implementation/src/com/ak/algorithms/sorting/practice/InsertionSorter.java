/**
 * 
 */
package com.ak.algorithms.sorting.practice;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 8:39:30 PM
 * InsertionSorter.java
 */
public class InsertionSorter extends AbstractSorter implements Sorter {

	@Override
	public int[] sortArray(int[] array) {
		printArray("UN-sorted InsertionSort Array: ", array);
		int n = array.length;
		for(int i=1; i<n; i++){
			for(int j=i;j>0;j--){
				if(array[j]<array[j-1]){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		printArray("Sorted InsertionSort Array: ", array);
		return array;
	}



}
