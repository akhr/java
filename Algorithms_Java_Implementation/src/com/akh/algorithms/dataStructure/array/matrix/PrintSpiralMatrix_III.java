package com.akh.algorithms.dataStructure.array.matrix;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 *  @fileName: PrintSpiralMatrix_III.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 27, 2018
 *  
 *  https://leetcode.com/problems/spiral-matrix-iii/description/ 
 *  
 *  On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

		Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

		Now, we walk in a clockwise spiral shape to visit every position in this grid. 

		Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.) 

		Eventually, we reach all R * C spaces of the grid.

		Return a list of coordinates representing the positions of the grid in the order they were visited.



		Example 1:

		Input: R = 1, C = 4, r0 = 0, c0 = 0
		Output: [[0,0],[0,1],[0,2],[0,3]]




		Example 2:

		Input: R = 5, C = 6, r0 = 1, c0 = 4
		Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]




		Note:

		1 <= R <= 100
		1 <= C <= 100
		0 <= r0 < R
		0 <= c0 < C

 */

public class PrintSpiralMatrix_III {

	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] res = new int[R*C][2];
		int resIndex = 0;

		int dir = 0;
		int noOfSteps = 1; 
		int totalSteps = 0;
		int noOfStepsIncr = 1;
		int cR = r0;
		int cC = c0;
		
		while(totalSteps < R*C) {
			if(dir == 0) { //LTR
				int i = 1;
				while(i <= noOfSteps) {
					if((cR>=0 && cR<R) && (cC>=0 && cC<C)) {
						res[resIndex++] = new int[] {cR, cC};
						totalSteps++;
					}
					i++;
					cC++;
				}
				dir = 1;
			}else if(dir == 1) { //TTB
				int i = 1;
				while(i <= noOfSteps) {
					if((cR>=0 && cR<R) && (cC>=0 && cC<C)) {
						res[resIndex++] = new int[] {cR, cC};
						totalSteps++;
					}
					i++;
					cR++;
				}
				dir = 2;
			}else if(dir == 2) { //RTL
				int i = 1;
				while(i <= noOfSteps) {
					if((cR>=0 && cR<R) && (cC>=0 && cC<C)) {
						res[resIndex++] = new int[] {cR, cC};
						totalSteps++;
					}
					i++;
					cC--;
				}
				dir = 3;
			}else {	//BTT		
				int i = 1;
				while(i <= noOfSteps) {
					if((cR>=0 && cR<R) && (cC>=0 && cC<C)) {
						res[resIndex++] = new int[] {cR, cC};
						totalSteps++;
					}
					i++;
					cR--;
				}
				dir = 0;
			}

			if(noOfStepsIncr == 2) {
				noOfSteps++;
				noOfStepsIncr = 1;
			}else {
				noOfStepsIncr++;
			}
		}
		return res;
	}
	
	@Test
	public void test_1_4_Matrix() {
		int R = 1, C = 4;
		int[][] output = {{0,0}, {0,1}, {0,2}, {0,3}};
		
		PrintSpiralMatrix_III printSpiralMatrix = new PrintSpiralMatrix_III();
		int r0 = 0, c0 = 0;
		int[][] actual= printSpiralMatrix.spiralMatrixIII(R, C, r0, c0);
		
		System.out.println("Output for "+R+"*"+C+" starting @ "+r0+","+c0+" ==>");
		for(int i=0; i<output.length; i++) {
			System.out.println(Arrays.toString(actual[i]));
			assertArrayEquals(output[i], actual[i]);
		}
		
	}
	
	@Test
	public void test_5_6_Matrix() {
		int R = 5, C = 6;
		int[][] output = {{1,4},{1,5},{2,5},{2,4},{2,3},{1,3},{0,3},{0,4},{0,5},{3,5},{3,4},{3,3},{3,2},{2,2},{1,2},{0,2},{4,5},{4,4},{4,3},{4,2},{4,1},{3,1},{2,1},{1,1},{0,1},{4,0},{3,0},{2,0},{1,0},{0,0}};
		
		PrintSpiralMatrix_III printSpiralMatrix = new PrintSpiralMatrix_III();
		int r0 = 1, c0 = 4;
		int[][] actual= printSpiralMatrix.spiralMatrixIII(R, C, r0, c0);
		
		System.out.println("Output for "+R+"*"+C+" starting @ "+r0+","+c0+" ==>");
		for(int i=0; i<output.length; i++) {
			System.out.println(Arrays.toString(actual[i]));
			assertArrayEquals(output[i], actual[i]);
		}
		
		
	}
}
