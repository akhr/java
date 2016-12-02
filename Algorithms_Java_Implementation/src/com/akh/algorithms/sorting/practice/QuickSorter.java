/**
 * 
 */
package com.akh.algorithms.sorting.practice;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 11:42:56 PM
 * QuickSorter.java
 */
public class QuickSorter extends AbstractSorter implements Sorter {
	
	/*public static void main(String[] args){
		QuickSorter sorter = new QuickSorter();
		int[] input = new int[]{7,2,1,6,8,5,3,4};
		sorter.sortArray(input);
	}*/
	
	@Override
	public int[] sortArray(int[] array) {
		array = new int[]{12, 14, 32, 4, 57, 2};
		printArray("UN-sorted QuickSort Array: ", array);
		quickSort(array, 0, array.length-1);
		printArray("Sorted QuickSort Array: ", array);
		return array;
	}
	
	private int partitionPoint(int[] array, int start, int end){
		int pivot = array[end];
		int pIndex = start;
		for(int i=start; i<end; i++){
			if(array[i] < pivot){
				int temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex++;
			}	
		}
		
		if(pIndex != end){
			int temp = array[end]; //pivot
			array[end] = array[pIndex];
			array[pIndex] = temp;
		}
		return pIndex;
	}
	
	private void quickSort(int[] array, int start, int end){
		if(start < end){
			int partitionPoint = partitionPoint(array, start, end);
			quickSort(array, start, partitionPoint-1);
			quickSort(array, partitionPoint+1, end);
		}
	}

}
