package com.akh.algorithms.dataStructure.array.range;

import static org.junit.Assert.assertEquals;

/**
 *  @fileName: Range_Sum_Query_2D_Immutable_304.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 15, 2018
 *  
 *  Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

		Range Sum Query 2D
		The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

		Example:
		Given matrix = [
		  [3, 0, 1, 4, 2],
		  [5, 6, 3, 2, 1],
		  [1, 2, 0, 1, 5],
		  [4, 1, 0, 1, 7],
		  [1, 0, 3, 0, 5]	
		]

		sumRegion(2, 1, 4, 3) -> 8
		sumRegion(1, 1, 2, 2) -> 11
		sumRegion(1, 2, 2, 4) -> 12
		Note:
		You may assume that the matrix does not change.
		There are many calls to sumRegion function.
		You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class Range_Sum_Query_2D_Immutable_304 {
	private int[][] matrix;
	
	public Range_Sum_Query_2D_Immutable_304(int[][] matrix) {
		this.matrix = matrix;
		preProcess();
	}
	
	private void preProcess(){
		for(int i=0; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length; j++){
				matrix[i][j] += matrix[i][j-1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int regionSum = 0;
		for(int i=row1; i<= row2; i++){
			if(col1-1 >= 0)
				regionSum += (matrix[i][col2] - matrix[i][col1-1]);
			else
				regionSum += matrix[i][col2];
		}
		return regionSum;
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
			  {5, 6, 3, 2, 1},
			  {1, 2, 0, 1, 5},
			  {4, 1, 0, 1, 7},
			  {1, 0, 3, 0, 5}};
		
		Range_Sum_Query_2D_Immutable_304 rangeSum = new Range_Sum_Query_2D_Immutable_304(matrix);
		assertEquals(8, rangeSum.sumRegion(2, 1, 4, 3));
		assertEquals(11, rangeSum.sumRegion(1, 1, 2, 2));
		assertEquals(12, rangeSum.sumRegion(1, 2, 2, 4));
		
		int[][] matrix2 = new int[][]{{-1}};
		
		Range_Sum_Query_2D_Immutable_304 rangeSum2 = new Range_Sum_Query_2D_Immutable_304(matrix);
		assertEquals(-1, rangeSum2.sumRegion(0, 0, 0, 0));
	}	
	
}
