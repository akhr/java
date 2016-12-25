/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

/**
 * @author ramamurthy
 *
 */
public class CountNoOfPathsInAMatrix {

	static int recursionCount_Recur = 0;
	static int recursionCount_Memo = 0;
	static int recursionCount_Bottom = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = createMatrix(8, 8);
		MatrixCell[] blockedCells = createBlockedCellsArray(16);
		matrix = setBlockedCells(matrix, blockedCells);
		//		int totalPathsCount = 0;
		//		totalPathsCount = countNoOfPaths(matrix, 0, 0);
		//		totalPathsCount = countPaths_DP_Memoization(matrix, 0, 0, createMatrix(8, 8));
		//		totalPathsCount = countPaths_DP_Bottom_Up(matrix, createMatrix(8, 8));		
		//		System.out.println("Total Available Paths - "+totalPathsCount);
		System.out.println("Total Available Paths Recursive -"+countPaths_Recursive(matrix, 0, 0));
		System.out.println("Total Available Paths Memoization Dp -"+countPaths_DP_Memoization(matrix, 0, 0, createMatrix(8, 8)));
		System.out.println("Total Available Paths BottomUP DP -"+countPaths_DP_Bottom_Up(matrix, createMatrix(8, 8)));
		System.out.println("No of recusion calls Recursive - "+recursionCount_Recur);
		System.out.println("No of recusion calls Memoization Dp - "+recursionCount_Memo);
		System.out.println("No of recusion calls BottomUP DP - "+recursionCount_Bottom);
	}


	//****************************************** Recursive Solution ******************************************//
	public static int countPaths_Recursive(int[][] matrix, int rowId, int colId){
		recursionCount_Recur++;

		//Invalid square
		if(rowId > matrix.length-1 || colId > matrix[rowId].length-1 || matrix[rowId][colId] == -1)
			return 0;

		//Base case - reached end of matrix (7,7)
		if(rowId == matrix.length-1 && colId == matrix[rowId].length-1)
			return 1;

		return countPaths_Recursive(matrix, rowId+1, colId) + countPaths_Recursive(matrix, rowId, colId+1);
	}



	//******************************* Dynamic Programming - Memoization *******************************//
	public static int countPaths_DP_Memoization(int[][] matrix, int rowId, int colId, int[][] pathMatrix){
		recursionCount_Memo++;

		//Base Case : Return 0 If Invalid square
		if(rowId > matrix.length-1 || colId > matrix[rowId].length-1 || matrix[rowId][colId] == -1)
			return 0;

		//Base case - Return 1 If Reached End of Matrix (7,7)
		if(rowId == matrix.length-1 && colId == matrix[rowId].length-1)
			return 1;

		if(pathMatrix[rowId][colId] == 0){
			pathMatrix[rowId][colId] = 
					countPaths_DP_Memoization(matrix, rowId+1, colId, pathMatrix) + 
					countPaths_DP_Memoization(matrix, rowId, colId+1, pathMatrix);
		}

		return pathMatrix[rowId][colId];
	}



	//******************************* Dynamic Programming - Bottom Up Approach *******************************//
	/**
	 * (Start)[27	17 	12	12	7	4	1	1]
	 * 		 [10	5	/	5	3	3	/	1]
	 * 		 [5		5	2	2	/	3	3	1]
	 * 		 [/		3	/	2	1	/	2	1]
	 * 		 [7		3	/	1	1	1	1	1]
	 * 		 [4		3	3	/	/	0	/	1]
	 * 		 [1		/	3	2	1	/	2	1]
	 * 		 [1		1	1	1	1	1	1	1](End)
	 **/
	public static int countPaths_DP_Bottom_Up(int[][] matrix, int[][] pathMatrix){

		int maxRow = matrix.length - 1;
		int maxCol = matrix[1].length - 1;

		//End cell has value 1 - Definite Value
		pathMatrix[maxRow][maxCol] = 1;

		for(int i = matrix.length-1; i >= 0; i--){
			for(int j = matrix[i].length-1; j >= 0; j--){
				recursionCount_Bottom++;
				if(pathMatrix[i][j] == 0){
					if(i < maxRow && matrix[i][j] != -1){
						pathMatrix[i][j] = pathMatrix[i][j] + pathMatrix[i+1][j];
					}
					if(j < maxCol && matrix[i][j] != -1){
						pathMatrix[i][j] = pathMatrix[i][j] + pathMatrix[i][j+1];
					}
				}
			}
		}

		return pathMatrix[0][0];
	}








	//****************************************** Utility Methods ******************************************//

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
		//		matrixCells[0] = new MatrixCell(1, 2);
		//		matrixCells[1] = new MatrixCell(1, 6);
		//		matrixCells[2] = new MatrixCell(2, 4);
		//		matrixCells[3] = new MatrixCell(3, 0);
		//		matrixCells[4] = new MatrixCell(3, 2);
		//		matrixCells[5] = new MatrixCell(3, 5);
		//		matrixCells[6] = new MatrixCell(4, 2);
		//		matrixCells[7] = new MatrixCell(5, 3);
		//		matrixCells[8] = new MatrixCell(5, 4);
		//		matrixCells[9] = new MatrixCell(5, 6);
		//		matrixCells[10] = new MatrixCell(6, 1);
		//		matrixCells[11] = new MatrixCell(6, 5);
		matrixCells[0] = new MatrixCell(1, 4);
		matrixCells[1] = new MatrixCell(1, 5);
		matrixCells[2] = new MatrixCell(1, 6);
		matrixCells[3] = new MatrixCell(2, 1);
		matrixCells[4] = new MatrixCell(2, 5);
		matrixCells[5] = new MatrixCell(3, 1);
		matrixCells[6] = new MatrixCell(3, 4);
		matrixCells[7] = new MatrixCell(3, 5);
		matrixCells[8] = new MatrixCell(4, 2);
		matrixCells[9] = new MatrixCell(4, 6);
		matrixCells[10] = new MatrixCell(5, 2);
		matrixCells[11] = new MatrixCell(5, 3);
		matrixCells[12] = new MatrixCell(5, 5);
		matrixCells[13] = new MatrixCell(6, 1);
		matrixCells[14] = new MatrixCell(6, 6);
		matrixCells[15] = new MatrixCell(7, 1);
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
