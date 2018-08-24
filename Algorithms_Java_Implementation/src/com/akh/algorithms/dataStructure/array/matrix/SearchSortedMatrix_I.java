package com.akh.algorithms.dataStructure.array.matrix;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 *  @fileName: SearchSortedMatrix.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 15, 2018
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.
		Example 1:

		Input:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 3
		Output: true
		Example 2:

		Input:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 13
		Output: false
 */

public class SearchSortedMatrix_I {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		//m * n matrix
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		for(int rowIndex = 0; rowIndex<rowCount; rowIndex++) {
			int lastElementInRow = matrix[rowIndex][colCount-1];
			if(lastElementInRow == target) {
				return true;
			}else if(target > lastElementInRow) {
				continue;
			}else {
				//This row might contain the target
				int searchResult = Arrays.binarySearch(matrix[rowIndex], target);
				return (searchResult >= 0);
			}
		}
		return false;
	}
	
	private int[][] getMatrix(int rows, int cols){
		int[][] sampleMatrix = new int[rows][cols];
		sampleMatrix[0] = new int[]{1,   3,  5,  7};
		sampleMatrix[1] = new int[]{10, 11, 16, 20};
		sampleMatrix[2] = new int[]{23, 30, 34, 50};
		return sampleMatrix;
	}


	@Test
	public void test_1() {
		int[][] matrix = getMatrix(3, 4);
		assertTrue(searchMatrix(matrix, 3));
	}
	
	@Test
	public void test_2() {
		int[][] matrix = getMatrix(3, 4);
		assertFalse(searchMatrix(matrix, 13));
	}
	
	@Test
	public void test_3() {
		int[][] matrix = getMatrix(3, 4);
		assertTrue(searchMatrix(matrix, 7));
	}
	
	@Test
	public void test_4() {
		int[][] matrix = getMatrix(3, 4);
		assertTrue(searchMatrix(matrix, 23));
	}
	
	
	@Test
	public void test_5() {
		int[][] matrix = getMatrix(3, 4);
		assertFalse(searchMatrix(matrix, 55));
	}
	
	@Test
	public void test_No_Rows() {
		int[][] matrix = {};
		assertFalse(searchMatrix(matrix, 55));
	}
	
	@Test
	public void test_No_Cols() {
		int[][] matrix = {{}};
		assertFalse(searchMatrix(matrix, 55));
	}
}
