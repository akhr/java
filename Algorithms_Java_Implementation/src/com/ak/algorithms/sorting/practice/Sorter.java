/**
 * 
 */
package com.ak.algorithms.sorting.practice;

import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 3, 2016 7:41:32 PM
 * Sorter.java
 */
public interface Sorter {

	int[] sortArray(int[] array);
	List<Integer> sortList(List<Integer> list);
	List<Comparable> sortComparableList(List<Comparable> comparableList);
}

