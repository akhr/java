/**
 * 
 */
package com.akh.algorithms.sorting.practice;

import com.akh.utils.Utils;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 7:40:59 PM
 * Tester.java
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Code to provide info for the randomIntGenerator
		int[][] randArrayInfo = new int[2][3];
		randArrayInfo[0] = new int[]{20, 0, 100};
		randArrayInfo[1] = new int[]{10, -200, 700};
		
		//Initialize and add Sorters to list
		int noOfSorters = 0;
		Sorter[] sorterArr = new Sorter[10];
		Sorter bubbleSorter = new BubbleSorter();
		Sorter insertionSorter = new InsertionSorter();
		Sorter quickSorter = new QuickSorter_My_Impl();
		Sorter mergerSorter = new MergeSorter();
		sorterArr[noOfSorters++] = bubbleSorter;
		sorterArr[noOfSorters++] = insertionSorter;
		sorterArr[noOfSorters++] = quickSorter;
		sorterArr[noOfSorters++] = mergerSorter;
		
		for(int type = 0; type<noOfSorters; type++){
			
			String className = sorterArr[type].getClass().getSimpleName();
			System.out.println(" ** "+className+" ** ");
			
			for(int j=0; j<randArrayInfo.length; j++){
				int[] input = Utils.intGenerator(randArrayInfo[j][0], randArrayInfo[j][1], randArrayInfo[j][2]);
				sorterArr[type].sortArray(input);
			}
			
			System.out.println("");
		}

	}
	
	

}
