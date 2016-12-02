package com.akh.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	 
	 
	public static int[] mergeSort(int[] input){

		System.out.println("MergeSort Called with length =" + input.length);
		for(int printCount=0; printCount<input.length; printCount++)
			System.out.println("Elements are == > "+input[printCount]);

		if(input.length<=1)
			return input;

		int middle = (input.length)/2;
		int[] left = new int[middle];
		int[] right;
		if(input.length%2==0)
			right = new int[middle];
		else
			right = new int[middle+1];
		int index =0;

		for(int i=0; i< middle;i++,index++){
			left[index]=input[i];
		}

		index=0;

		for(int j=middle; j<input.length ;j++,index++){
			right[index]=input[j];
		}

		int[] sortedleft = mergeSort(left);
		int[] sortedRight = mergeSort(right);

		return merge(sortedleft, sortedRight);

	}

	public static int[] merge(int[] left, int[] right){

		System.out.println("Merge STEP Called with LEFT Array with length =" + left.length);
		for(int printCount=0; printCount<left.length; printCount++)
			System.out.println("Elements in LeftArray == > "+left[printCount]);

		System.out.println("Merge STEP Called with RIGHT Array with length =" + right.length);
		for(int printCount=0; printCount<right.length; printCount++)
			System.out.println("Elements in RightArray == > "+right[printCount]);

		int[] merged = new int[left.length+right.length];
		int leftIndex=0;
		int rightIndex=0;
		int mergedArrayIndex = 0;

		while(leftIndex<left.length && rightIndex<right.length){

			if(left[leftIndex]<right[rightIndex]){
				merged[mergedArrayIndex] = left[leftIndex];
				leftIndex++;
			}else {
				merged[mergedArrayIndex] = right[rightIndex];
				rightIndex++;
			}
			mergedArrayIndex++;

		}


		if(leftIndex<left.length){
			while(leftIndex < left.length){
				merged[mergedArrayIndex] = left[leftIndex];
				leftIndex++;
				mergedArrayIndex++;
			}
		}

		if(rightIndex<right.length){
			while(rightIndex < right.length){
				merged[mergedArrayIndex] = right[rightIndex];
				rightIndex++;
				mergedArrayIndex++;
			}
		}

		System.out.println("Merge STEP COMPLETED MERGED Array == > ");
		for(int printCount=0; printCount<merged.length; printCount++)
			System.out.println(merged[printCount]);

		return merged;
	}

}