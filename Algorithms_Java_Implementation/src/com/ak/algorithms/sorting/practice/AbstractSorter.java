/**
 * 
 */
package com.ak.algorithms.sorting.practice;

import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 7:44:26 PM
 * AbstractSorter.java
 */
public abstract class AbstractSorter implements Sorter {
	
	@Override
	public abstract int[] sortArray(int[] array);

	@Override
	public List<Integer> sortList(List<Integer> list) {
		return null;
	}
	
	@Override
	public List<Comparable> sortComparableList(List<Comparable> comparableList) {
		return null;
	}
	
	@Override
	public void printArray(String message, int[] array) {
		System.out.println("Printing "+message);
		for(int i=0; i<array.length; i++){
			if(i==0)
				System.out.print("[ "+array[i]);
			else if(i==array.length-1)
				System.out.println(" "+array[i]+" ]");
			else
				System.out.print(" "+array[i]);
		}
	}
	
}
