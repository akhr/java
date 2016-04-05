package com.ak.algorithms.searching;

import com.ak.algorithms.sorting.practice.MergeSorter;

public class BinarySearch {
	/**
	 * searches for a value in sorted array
	 *
	 * @param array
	 *            array to search in
	 * @param value
	 *            searched value
	 * @param left
	 *            index of left boundary
	 * @param right
	 *            index of right boundary
	 * @return position of searched value, if it presents in the array or -1, if
	 *         it is absent
	 */
	public static boolean binarySearch(int[] array, int value, int left, int right) {
		System.out.println("************************************************");
		System.out.println("left = " +left);
		System.out.println("right = " +right);
		for(int i=left; i<=right; i++)
			System.out.println("Searching on the sub array = " + array[i]);
		int middle = (left + right) / 2;
		System.out.println("MIDDLE Element = "+ array[middle]);
		System.out.println("************************************************");
	      if (left > right)
	            return false;
	      
//	      int middle = (left + right) / 2;
	      if (array[middle] == value)
	            return true;
	      else if (array[middle] > value)
	            return binarySearch(array, value, left, middle - 1);
	      else
	            return binarySearch(array, value, middle + 1, right);           
	}
	
	public static void main(String[] args){
//		int[] input = new int[]{2, 7, 14, 22, 29, 31, 37, 38, 42, 46, 48, 52,53, 55, 61};
//		System.out.println("Index of the searched item = " + binarySearch(input, 41, 0, input.length-1));
		
		int[] unSortedInput = new int[]{2, 100, 140, 3, 9, 21, 18, 564, 91, 54, 22, 904, 356, 1};
		int[] sorted = new MergeSorter().sortArray(unSortedInput);
		System.out.println("Is searched item in the list ???  " + binarySearch(sorted, 91, 0, sorted.length-1));
	}
}
