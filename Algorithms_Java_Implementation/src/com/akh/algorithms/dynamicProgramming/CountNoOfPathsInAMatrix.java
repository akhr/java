/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

/**
 * @author ramamurthy
 *
 */
public class CountNoOfPathsInAMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = createMatrix(8, 8);
		MatrixCell[] blockedCells = createBlockedCellsArray(12);
		matrix = setBlockedCells(matrix, blockedCells);
	}
	
	public static int countNoOfPaths(int[][] matrix){
		int noOfPaths = 0;
		
		return noOfPaths;
	}
	
	public static int[][] createMatrix(int row, int col){
		int[][] matrix = new int[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				matrix[i][j] = 0;
			}
		}
		return matrix;
	}
	
	public static int[][] setBlockedCells(int[][] matrix, MatrixCell[] blockedCells){
		for(MatrixCell blockedCell : blockedCells){
			matrix[blockedCell.rowId][blockedCell.colId] = -1;
		}
		return matrix;
	}
	
	public static MatrixCell[] createBlockedCellsArray(int noOfBlockedCells){
		MatrixCell[] matrixCells = new MatrixCell[noOfBlockedCells];
		matrixCells[0] = new MatrixCell(1, 2);
		matrixCells[1] = new MatrixCell(1, 6);
		matrixCells[2] = new MatrixCell(2, 4);
		matrixCells[3] = new MatrixCell(3, 0);
		matrixCells[4] = new MatrixCell(3, 2);
		matrixCells[5] = new MatrixCell(3, 5);
		matrixCells[6] = new MatrixCell(4, 2);
		matrixCells[7] = new MatrixCell(5, 3);
		matrixCells[8] = new MatrixCell(5, 4);
		matrixCells[9] = new MatrixCell(5, 6);
		matrixCells[10] = new MatrixCell(6, 1);
		matrixCells[11] = new MatrixCell(6, 5);
		return matrixCells;
	}
	
	private static class MatrixCell {
		int rowId;
		int colId;
		public MatrixCell(int r, int c) {
			this.rowId = r;
			this.colId = c;
		}
	}

}
