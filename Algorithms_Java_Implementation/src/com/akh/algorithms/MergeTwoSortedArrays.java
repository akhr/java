/**
 * 
 */
package com.akh.algorithms;

import com.akh.algorithms.sorting.practice.QuickSorter;
import com.akh.utils.Utils;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 5, 2016 11:41:13 AM
 * MergeTwoSortedArrays.java
 */
public class MergeTwoSortedArrays {


	public static void main(String[] args){
		int[] input_1 = Utils.intGenerator(10, -80, 2000);
		int[] input_2 = Utils.intGenerator(6, 70, 999);
		
		QuickSorter quickSorter = new QuickSorter();
		input_1 = quickSorter.sortArray(input_1);
		input_2 = quickSorter.sortArray(input_2);
		
		int[] resultArr = merge(input_1, input_2);
		Utils.printArray("resultArr : Sorted ", resultArr);
	}

	public static int[] merge(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		int aIndex = 0, bIndex = 0, resIndex = 0;

		while(aIndex < a.length && bIndex < b.length){
			if(a[aIndex] == b[bIndex]){
				result[resIndex++] = a[aIndex++];
				result[resIndex++] = b[bIndex++];
			}
			if(a[aIndex] < b[bIndex]){
				result[resIndex] = a[aIndex];
				aIndex++;
				resIndex++;
			}
			if(a[aIndex] > b[bIndex]){
				result[resIndex] = b[bIndex];
				bIndex++;
				resIndex++;
			}
		}

		while(aIndex < a.length){
			result[resIndex++] = a[aIndex++];
		}

		while(bIndex < b.length){
			result[resIndex++] = b[bIndex++];
		}

		return result;
	}

}
