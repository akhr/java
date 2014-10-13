/**
 * 
 */
package com.thesaka.algorithms;

import com.thesaka.algorithms.sorting.MergeSort;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Jul 2, 2012
 */
public class BiggestInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] input = new int[]{2, 45, 1, 0, 6, 87, 23, 98, -32, 65, 12, 78, 3, 100, 255, 31};

		
		System.out.println("********* PRIMARY INPUT Array ===  " +input.toString());

		int[] sorted = sort(input);
		for(int printCount=0; printCount<input.length; printCount++)
			System.out.println("********* SORTED OUTPUT Array === " + sorted[printCount]);
		
		System.out.println("Largest in the Array = "+largest(input));
	}

	public static int largest ( int[] input ) {
		/*		int max = 0;
		for(int i=0; i<input.length; i++){
			if(input[i]>max)
				max = input[i];
		}
		return max;*/

		return sort(input)[input.length-1];
	}

	public static int[] sort(int[] input){
		return MergeSort.mergeSort(input);
	}


}
