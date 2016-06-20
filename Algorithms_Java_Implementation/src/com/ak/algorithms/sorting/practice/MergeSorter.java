package com.ak.algorithms.sorting.practice;

public class MergeSorter extends AbstractSorter implements Sorter {
	
	private int[] mHelperArray;

	@Override
	public int[] sortArray(int[] array) {
		printArray("UN-sorted MergeSort Array: ", array);
		mHelperArray = new int[array.length];
		mergeSort(array, 0, array.length-1);
		printArray("Sorted MergeSort Array: ", array);
		return array;
	}
	
	private void mergeSort(int[] array, int start, int end){
		if(start >= end)
			return;
		int mid = (int)(start+end)/2;
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		merge(array, start, mid, end);
	}

	private void merge(int[] array, int start, int mid, int end){
		int leftIndex = start;
		int rightIndex = mid+1;
		int helperIndex = start;
		
		//Compare and add elements in sorted manner to helper array
		while(leftIndex <= mid && rightIndex <= end){
			if(array[leftIndex] < array[rightIndex]){
				mHelperArray[helperIndex++] = array[leftIndex++];
			}else if(array[rightIndex] < array[leftIndex]){
				mHelperArray[helperIndex++] = array[rightIndex++];
			}else if(array[leftIndex] == array[rightIndex]){
				mHelperArray[helperIndex++] = array[leftIndex++];
				mHelperArray[helperIndex++] = array[rightIndex++];
			}
		}
		
		//Copy leftover items from left array to helperArray
		while(leftIndex <= mid){
			mHelperArray[helperIndex++] = array[leftIndex++];
		}
		
		//Copy leftover items from right array to helperArray
		while(rightIndex <= end){
			mHelperArray[helperIndex++] = array[rightIndex++];
		}
		
		//Copy helper to input array
		int i=start;
		while(i<=end){
			array[i] = mHelperArray[i];
			i++;
		}
	}

}
