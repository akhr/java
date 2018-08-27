package com.akh.algorithms.dataStructure.array.matrix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/**
 *  @fileName: SetMatrixZeros.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 20, 2018
 *  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
		Example 1:
		Input: 
		[
		  [1,1,1],
		  [1,0,1],
		  [1,1,1]
		]
		Output: 
		[
		  [1,0,1],
		  [0,0,0],
		  [1,0,1]
		]

		Example 2:
		Input: 
		[
		  [0,1,2,0],
		  [3,4,5,2],
		  [1,3,1,5]
		]
		Output: 
		[
		  [0,0,0,0],
		  [0,4,5,0],
		  [0,3,1,0]
		]
		Follow up:

		A straight forward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution?
 */

public class SetMatrixZeros {

	public void setZeroes_1(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		Set<Integer> rowResetter = new HashSet<>();
		Set<Integer> colResetter = new HashSet<>();

		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				if(matrix[i][j] == 0) {
					if(!rowResetter.contains(i))
						rowResetter.add(i);
					if(!colResetter.contains(j))
						colResetter.add(j);
				}
			}
		}

		if(rowResetter.size() == 0 || colResetter.size() == 0) {
			return;
		}

		Iterator<Integer> rowIterator = rowResetter.iterator(); 
		while(rowIterator.hasNext()) {
			int rowId = rowIterator.next();
			int j = 0;
			while(j < colCount) {
				matrix[rowId][j] = 0;
				j++;
			}
		}

		Iterator<Integer> colIterator = colResetter.iterator(); 
		while(colIterator.hasNext()) {
			int colId = colIterator.next();
			int i = 0;
			while(i < rowCount) {
				matrix[i][colId] = 0;
				i++;
			}
		}
	}
	
	public void setZeroes_2(int[][] matrix) {
		int rowCount = matrix.length;
		int colCount = matrix[0].length;
		int newVal = Integer.MIN_VALUE;

		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				if(matrix[i][j] == 0) {
					replaceRowsAndCols(matrix, i, j, newVal);
				}
			}
		}
		
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				if(matrix[i][j] == newVal) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public void replaceRowsAndCols(int[][] matrix, int rowId, int colId, int newVal){
		int j=0;
		while(j<matrix[0].length){
			if(matrix[rowId][j] != 0)
				matrix[rowId][j] = newVal;
			j++;
		}
		
		int i=0;
		while(i<matrix.length){
			if(matrix[i][colId] != 0)
				matrix[i][colId] = newVal;
			i++;
		}
	}

	@Test
	public void test_1() {
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1,1,1};
		matrix[1] = new int[]{1,0,1};
		matrix[2] = new int[]{1,1,1};

		setZeroes_1(matrix);
		
		System.out.println("Test 1");
		for(int i=0; i<3; i++) {
			System.out.print("\n");
			for(int j=0; j<3; j++) {
				System.out.print("\t"+matrix[i][j]);
			}
		}
	}
	
	@Test
	public void test_2() {
		int[][] matrix = new int[3][4];
		matrix[0] = new int[]{0,1,2,0};
		matrix[1] = new int[]{3,4,5,2};
		matrix[2] = new int[]{1,3,1,5};

		setZeroes_1(matrix);

		System.out.println("\nTest 2");
		for(int i=0; i<3; i++) {
			System.out.print("\n");
			for(int j=0; j<4; j++) {
				System.out.print("\t"+matrix[i][j]);
			}
		}
	}
	
	@Test
	public void test_3() {
		int[][] matrix = new int[3][3];
		matrix[0] = new int[]{1,1,1};
		matrix[1] = new int[]{1,0,1};
		matrix[2] = new int[]{1,1,1};

		setZeroes_2(matrix);
		
		System.out.println("\nTest 3");
		for(int i=0; i<3; i++) {
			System.out.print("\n");
			for(int j=0; j<3; j++) {
				System.out.print("\t"+matrix[i][j]);
			}
		}
	}
	
	@Test
	public void test_4() {
		int[][] matrix = new int[3][4];
		matrix[0] = new int[]{0,1,2,0};
		matrix[1] = new int[]{3,4,5,2};
		matrix[2] = new int[]{1,3,1,5};

		setZeroes_2(matrix);

		System.out.println("\nTest 4");
		for(int i=0; i<3; i++) {
			System.out.print("\n");
			for(int j=0; j<4; j++) {
				System.out.print("\t"+matrix[i][j]);
			}
		}
	}
}
