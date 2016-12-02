/**
 * 
 */
package com.akh.algorithms.sorting.practice;

import java.util.List;

import com.akh.utils.Utils;

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
	
	
	void printArray(String message, int[] array){
		Utils.printArray(message, array);
	}
	
}
