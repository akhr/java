/**
 * 
 */
package com.akh.algorithms.math.matrix;

/**
 * @author Akhash Ramamurthy
 * Apr 30, 2017
 * 
 * Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
 */
public class ResetSpecificRowColumnIfOneElementIsZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int M = 4;
		int N = 3;
		int[][] matrix = createMatrix(M, N);
		System.out.println("Original Matrix :");
		printMatrix(matrix, M, N);
		checkAndResetMatrixRowsAndCols(matrix, M, N);
	}
	
	private static int[][] createMatrix(int M, int N){
		int index = 1;
		int[][] matrix = new int[M][N];
		boolean doneReset = false;
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				matrix[i][j] = index++;
				/*if(doneReset && Math.random()%2==0){
					System.out.println("Done reset during create");
					matrix[i][j] = 0;
					doneReset = true;
				}*/
			}
		}
		matrix[1][1] = 0;
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix, int M, int N){
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	private static void checkAndResetMatrixRowsAndCols(int[][] matrix, int M, int N){
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				if(matrix[i][j] == 0){
					resetRowAndColumn(matrix, M, N, i, j);
					return;
				}
			}
		}
	}
	
	private static void resetRowAndColumn(int[][] matrix, int M, int N, int x, int y){
		 //traverse left and set all row items to 0
		for(int i=0; i<M; i++){
			matrix[i][y] = 0;
		}
		
		for(int j=0; j<N; j++){
			matrix[x][j] = 0;
		}
		System.out.println("Solution Matrix : ");
		printMatrix(matrix, M, N);
	}
	
	//Need to implement - What if multiple items are zero?
	//Use helper matrix 
	//Refer Cracking Coding pg180.

}
