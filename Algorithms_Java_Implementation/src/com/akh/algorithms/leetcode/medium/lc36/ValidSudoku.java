/**
 * @fileName: ValidSudoku.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 30, 2019
 * 
 */
package com.akh.algorithms.leetcode.medium.lc36;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: ValidSudoku.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 30, 2019
 * 
 */
public class ValidSudoku {

	//Time: O(N*M) + O(N) + O(M) Space: O(1)
	public boolean isValidSudoku(char[][] board) {
	
		int[] bucket = new int[9];
		
		//Check block - Time: O(N*M) Space:O(1)
		for(int i= 0 ; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				Arrays.fill(bucket, 0);
				if(!isValidSudokuBlock(board, bucket, i, j)) {
					return false;
				}
			}
		}
		
		//Check row & col - Time: O(N) + O(M) Space:O(1)
		for(int i = 0; i < 9; i++) {
			Arrays.fill(bucket, 0);
			if(!isValidCol(board, bucket, i))
				return false;
			
			Arrays.fill(bucket, 0);
			if(!isValidRow(board, bucket, i))
				return false;
		}
		return true;
	}
	
	// Time: O(N*M) Space:O(1)
	private boolean isValidSudokuBlock(char[][] block, int[] nums, int row, int col) {
		for(int i = row; i < (row+3); i++) {
			for(int j = col; j < (col+3); j++) {
				int val = block[i][j];
				if(val == '.') 
					continue;
				if(nums[val - '1'] == -1) 
					return false;
				nums[val - '1'] = -1;
			}
		}
		return true;
	}
	
	// Time: O(N) Space:O(1)
	private boolean isValidRow(char[][] board, int[] nums, int rowIndx) {
		for(int i=0; i<board[0].length; i++) {
			int val = board[rowIndx][i];
			if(val == '.') 
				continue;
			if(nums[val - '1'] == -1) 
				return false;
			nums[val - '1'] = -1;
		}
		return true;
	}
	
	// Time: O(M) Space:O(1)
	private boolean isValidCol(char[][] board, int[] nums, int colIndx) {
		for(int i=0; i<board.length; i++) {
			int val = board[i][colIndx];
			if(val == '.') 
				continue;
			if(nums[val - '1'] == -1) 
				return false;
			nums[val - '1'] = -1;
		}
		return true;
	}
	
	@Test
	public void Test_101() {
		char[][] board = {
		  {'5','3','.','.','7','.','.','.','.'},
		  {'6','.','.','1','9','5','.','.','.'},
		  {'.','9','8','.','.','.','.','6','.'},
		  {'8','.','.','.','6','.','.','.','3'},
		  {'4','.','.','8','.','3','.','.','1'},
		  {'7','.','.','.','2','.','.','.','6'},
		  {'.','6','.','.','.','.','2','8','.'},
		  {'.','.','.','4','1','9','.','.','5'},
		  {'.','.','.','.','8','.','.','7','9'}
		};
		assertTrue(isValidSudoku(board));
	}
	
	@Test
	public void Test_102() {
		char[][] board = {
		  {'8','3','.','.','7','.','.','.','.'},
		  {'6','.','.','1','9','5','.','.','.'},
		  {'.','9','8','.','.','.','.','6','.'},
		  {'8','.','.','.','6','.','.','.','3'},
		  {'4','.','.','8','.','3','.','.','1'},
		  {'7','.','.','.','2','.','.','.','6'},
		  {'.','6','.','.','.','.','2','8','.'},
		  {'.','.','.','4','1','9','.','.','5'},
		  {'.','.','.','.','8','.','.','7','9'}
		};
		assertFalse(isValidSudoku(board));
	}
	
	@Test
	public void Test_103() {
		char[][] board = {
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','9','.'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','5','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'}};
		assertFalse(isValidSudoku(board));
	}
	
	
}
