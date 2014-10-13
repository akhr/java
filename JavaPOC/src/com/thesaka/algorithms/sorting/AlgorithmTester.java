package com.thesaka.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] input = new int[]{2, 45, 1, 0, 6, 87, 23, 98, -32, 65, 12, 78, 3, 100, 255, 31};
//		int[] input = new int[]{2, 45, 1, 0};
		int[] input = new int[]{2,0};


		System.out.println("********* PRIMARY INPUT Array ===  " +input.toString());

//		int[] sorted = BubbleSort.bubbleSort(input);
//		int[] sorted = MergeSort.mergeSort(input);
		MergeSort_Adv.sort(input); int[] sorted = input;
//		int[] sorted = InsertionSort.insertionSort2(input);
//		int[] sorted = SelectionSort.selectionSort(input);
		
		for(int printCount=0; printCount<input.length; printCount++)
			System.out.println("********* SORTED OUTPUT Array === " + sorted[printCount]);

//		System.out.println("Index of the Linear searched element = "+ LinearSearch.linearSearch(input, 65));
		
//		System.out.println("Index of the Binary searched element = "+ BinarySearch.binarySearch(MergeSort.mergeSort(input), 65, 0, input.length-1));
		
	}

}
