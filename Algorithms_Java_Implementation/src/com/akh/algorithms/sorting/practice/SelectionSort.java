package com.akh.algorithms.sorting.practice;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class SelectionSort extends AbstractSorter implements Sorter {

    @Override
    public int[] sortArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void Test_101(){
        int[] in = new int[] {7,1,5,3,6,4};
		assertArrayEquals(new int[]{1,3,4,5,6,7}, sortArray(in));
		System.out.println("Sorted Arr : "+Arrays.toString(in));
    } 
    @Test
    public void Test_102(){
        int[] in = new int[] {};
		assertArrayEquals(new int[]{}, sortArray(in));
		System.out.println("Sorted Arr : "+Arrays.toString(in));
    } 
    @Test
    public void Test_103(){
        int[] in = new int[] {200, 300, -100, -243, -453, 3, 387, 1093, 2};
        int[] sorted = new int[]{200, 300, -100, -243, -453, 3, 387, 1093, 2};
        Arrays.sort(sorted);
		assertArrayEquals(sorted, sortArray(in));
		System.out.println("Sorted Arr : "+Arrays.toString(in));
    } 

}
