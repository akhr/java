/**
 * 
 */
package com.akh.algorithms.sorting.practice;

/**
 * @author Akhash Ramamurthy
 * Jan 30, 2017
 */
public class QuickSorter_My_Impl extends AbstractSorter implements Sorter {
	
	private static int GET_PARTITION_POINT_COUNTER = 0;
	private static int QUICK_SORT_CALL_COUNTER = 0;
	
	@Override
	public int[] sortArray(int[] array) {
//		array = new int[]{12, 14, 32, 4, 57, 2};
		printArray("UN-sorted QuickSort Array: ", array);
		quickSort(array, 0, array.length-1);
		printArray("Sorted QuickSort Array: ", array);
		System.out.println("Partition Point Counter : "+GET_PARTITION_POINT_COUNTER);
		System.out.println("QuickSort Func Call Counter : "+QUICK_SORT_CALL_COUNTER);
		return array;
	}
	
	public int getPartitionPoint(int[] array, int start, int end){
		GET_PARTITION_POINT_COUNTER++;
		if(start == end)
			return start;
		
		int pivot = array[end];
		int pIndex = start;
		for(int i = start; i <= end; i++){
			if(array[i] < pivot){
				swap(array, i, pIndex);
				pIndex++;
			}
			
			if(i == end){
				swap(array, pIndex, end);
			}
		}
		return pIndex;
	}
	
	public void quickSort(int[] array, int start, int end){
		QUICK_SORT_CALL_COUNTER++;
		
		if(array.length == 1)
			return;
		if(start >= end)
			return;
		int partitionPoint = getPartitionPoint(array, start, end);
		quickSort(array, start, partitionPoint-1);
		quickSort(array, partitionPoint+1, end);
	}
	
	public void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
