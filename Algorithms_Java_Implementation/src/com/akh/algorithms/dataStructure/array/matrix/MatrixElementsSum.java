package com.akh.algorithms.dataStructure.array.matrix;

/**
 *  @fileName: MatrixElementsSum.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 13, 2017
 *  
 *  After becoming famous, CodeBots decided to move to a new building and live together. The building is represented by a rectangular matrix of rooms, each cell containing an integer - the price of the room. Some rooms are free (their cost is 0), but that's probably because they are haunted, so all the bots are afraid of them. That is why any room that is free or is located anywhere below a free room in the same column is not considered suitable for the bots.

Help the bots calculate the total price of all the rooms that are suitable for them.

Example

For

matrix = [[0, 1, 1, 2], 
          [0, 5, 0, 0], 
          [2, 0, 3, 3]]
the output should be
matrixElementsSum(matrix) = 9.

Here's the rooms matrix with unsuitable rooms marked with 'x':

[[x, 1, 1, 2], 
 [x, 5, x, x], 
 [x, x, x, x]]
Thus, the answer is 1 + 5 + 1 + 2 = 9.
 */

public class MatrixElementsSum {

	public static void main(String[] args) {
		int[][] matrix = new int[3][4];
		matrix[0] = new int[]{1,1,1,0};
		matrix[1] = new int[]{0,5,0,1};
		matrix[2] = new int[]{2,1,3,10};
		System.out.println("Total Rent : "+matrixElementsSum(matrix));
	}

	static int matrixElementsSum(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		int totalRent = 0;
		boolean[] columnHauntStatus = new boolean[colCount];

		for(int i=0; i<rowCount; i++){
			for(int j=0; j<colCount; j++){
				if(!columnHauntStatus[j])
					totalRent += matrix[i][j];
				updateColHauntStatus(j, matrix[i][j], columnHauntStatus);
			}
		}
		return totalRent;
	}

	static void updateColHauntStatus(int j, int val, boolean[] columnHauntStatus){
		columnHauntStatus[j] = columnHauntStatus[j] ? columnHauntStatus[j] : (val == 0);
	}

}
