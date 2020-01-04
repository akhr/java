/**
 * 
 */
package com.akh.algorithms.sorting.practice;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author Akhash Ramamurthy
 *
 *         Apr 3, 2016 11:42:56 PM QuickSorter.java
 */
public class QuickSorter extends AbstractSorter implements Sorter {
	
	@Override
	public int[] sortArray(int[] array) {
		quickSort(array, 0, array.length-1);
		return array;
	}

	private void quickSort(int[] a, int s, int e){
		if (s >= e) {
			return;
		}
		int p = getPIndex(a, s, e);
		quickSort(a, s, p-1) ;
		quickSort(a, p+1, e);
	}

	private int getPIndex(int[] a, int s, int e){
		int p = s;
		int pivot = a[e];
		for (int i=s; i<e; i++) {
			if (a[i] < pivot) {
				swap(a, i, p);
				p++;
			}
		}
		swap(a, p, e);
		return p;
	} 

	private void swap(int[] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	@Test
	public void Test_101() {
		int[] in = new int[] {7,1,5,3,6,4};
		assertArrayEquals(new int[]{1,3,4,5,6,7}, sortArray(in));
		System.out.println("Sorted Arr : "+Arrays.toString(in));
	}
}


