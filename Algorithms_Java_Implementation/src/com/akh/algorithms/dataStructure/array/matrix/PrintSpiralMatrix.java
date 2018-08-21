package com.akh.algorithms.dataStructure.array.matrix;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *  @fileName: PrintSpiralMatrix.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 21, 2018
 *  
 *  Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
		
		Example 1:
		
		Input:
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
		Output: [1,2,3,6,9,8,7,4,5]
		Example 2:
		
		Input:
		[
		  [1, 2, 3, 4],
		  [5, 6, 7, 8],
		  [9,10,11,12]
		]
		Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class PrintSpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();

		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		int m = matrix.length;
		int n = matrix[0].length;

		int top = 0;
		int bottom = m-1;
		int left = 0;
		int right = n-1;

		// 0 - LTR, 1 - TTB, 2 - LTR, 3 - BTT
		int dir = 0; 

		while(top <= bottom && left <= right) {

			if(dir == 0) {
				//left to right
				for(int j=left; j<=right; j++) {
					result.add(matrix[top][j]);
				}
				top++;
				dir = 1;
			}else if(dir == 1) {
				//top to bottom
				for(int i=top; i<=bottom; i++) {
					result.add(matrix[i][right]);
				}
				right--;
				dir = 2;
			}else if(dir == 2) {
				//right to left
				for(int j=right; j>=left; j--) {
					result.add(matrix[bottom][j]);
				}
				bottom--;
				dir = 3;
			}else {
				//bottom to top
				for(int i=bottom; i>=top; i--) {
					result.add(matrix[i][left]);
				}
				left++;
				dir = 0;
			}

		}
		
		return result;
	} 
	
	@Test
	public void test_1() {
		int[][] matrix = new int[3][4];
		matrix[0] = new int[]{1, 2, 3, 4};
		matrix[1] = new int[]{5, 6, 7, 8};
		matrix[2] = new int[]{9,10,11,12};

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\nTest 1");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {1,2,3,4,8,12,11,10,9,5,6,7};
		assertArrayEquals(expectedRes, resArr);
		
	}
	
	@Test
	public void test_2() {
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1,2,3};
		matrix[1] = new int[]{4,5,6};
		matrix[2] = new int[]{7,8,9};

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\nTest 2");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {1,2,3,6,9,8,7,4,5};
		assertArrayEquals(expectedRes, resArr);
		
	}
	
	@Test
	public void test_No_Cols() {
		int[][] matrix = new int[3][0];
		matrix[0] = new int[]{};
		matrix[1] = new int[]{};
		matrix[2] = new int[]{};

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\ntest_No_Cols");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {};
		assertArrayEquals(expectedRes, resArr);
		
	}
	
	@Test
	public void test_No_Rows() {
		int[][] matrix = new int[0][0];

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\ntest_No_Rows");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {};
		assertArrayEquals(expectedRes, resArr);
		
	}
	
	@Test
	public void test_Single_Col() {
		int[][] matrix = new int[4][1];
		matrix[0] = new int[]{1};
		matrix[1] = new int[]{2};
		matrix[2] = new int[]{3};
		matrix[3] = new int[]{4};
		

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\ntest_Single_Col");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {1,2,3,4};
		assertArrayEquals(expectedRes, resArr);
		
	}
	
	
	@Test
	public void test_one_item() {
		int[][] matrix = new int[1][1];
		matrix[0] = new int[]{100};

		List<Integer> res = spiralOrder(matrix);
		Integer[] resArr = res.toArray(new Integer[res.size()]);
		
		System.out.println("\ntest_one_item");
		System.out.println("Output - "+Arrays.toString(resArr));
		
		Integer[] expectedRes = {100};
		assertArrayEquals(expectedRes, resArr);
		
	}
}
