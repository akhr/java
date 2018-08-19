package com.akh.algorithms.dataStructure.array.matrix;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *  @fileName: SearchSortedMatrix_II.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 15, 2018
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

		Integers in each row are sorted in ascending from left to right.
		Integers in each column are sorted in ascending from top to bottom.
		Example:

		Consider the following matrix:

		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		Given target = 5, return true.

		Given target = 20, return false.
 */

public class SearchSortedMatrix_II {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
		
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		
		int rowId = 0;
		int colId = colCount-1;
		
		while(rowId <= rowCount-1 && colId >= 0){
			if(matrix[rowId][colId] == target){
				return true;
			}else if(target < matrix[rowId][colId]){
				colId--;
			}else{
				rowId++;
			}
		}
		return false;
	}
	
	private int[][] getMatrix(){
		int[][] sampleMatrix = new int[5][5];
		sampleMatrix[0] = new int[]{1,   4,  7, 11, 15};
		sampleMatrix[1] = new int[]{2,   5,  8, 12, 19};
		sampleMatrix[2] = new int[]{3,   6,  9, 16, 22};
		sampleMatrix[3] = new int[]{10, 13, 14, 17, 24};
		sampleMatrix[4] = new int[]{18, 21, 23, 26, 30};
		return sampleMatrix;
	}


	@Test
	public void test_1() {
		int[][] matrix = getMatrix();
		assertTrue(searchMatrix(matrix, 3));
	}
	
	@Test
	public void test_2() {
		int[][] matrix = getMatrix();
		assertTrue(searchMatrix(matrix, 13));
	}
	
	@Test
	public void test_3() {
		int[][] matrix = getMatrix();
		assertFalse(searchMatrix(matrix, 20));
	}
	
	@Test
	public void test_4() {
		int[][] matrix = getMatrix();
		assertFalse(searchMatrix(matrix, 33));
	}
	
	
	@Test
	public void test_5() {
		int[][] matrix = getMatrix();
		assertFalse(searchMatrix(matrix, -1));
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
