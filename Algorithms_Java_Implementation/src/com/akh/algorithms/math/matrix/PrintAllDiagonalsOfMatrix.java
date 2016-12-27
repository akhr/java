package com.akh.algorithms.math.matrix;

import java.util.HashMap;
import java.util.Map;

public class PrintAllDiagonalsOfMatrix {

	public static void main(String[] args) {
		int x =4;
		int y =4;
		char[][] resultArray = createMatrix(x, y);	
		printMatrixDiagonals(resultArray);
	}

	public static char[][] createMatrix(int x, int y){
		char[][] resultArray = new char[x][];
		char ch = 'A';
		int inputCalculator=0;
		for(int i=0; i<x; i++){
			resultArray[i] = new char[y];
			for(int j=0; j<y; j++){
				resultArray[i][j] = (char) (inputCalculator + ch);
				inputCalculator++;
			}
		}

		for( int i = 0 ; i < x ; i++ ) {
			for( int j = 0 ; j < y ; j++, ch++ ) {
				System.out.print( resultArray[i][j] + " " );
			}
			System.out.println();
		}
		System.out.println( "============================" );
		return resultArray;
	}
	
	
	//Source : http://stackoverflow.com/questions/20420065/loop-diagonally-through-two-dimensional-array 
	public static void printMatrixDiagonals(char[][] matrix) {

	    int c = 0;
	    int count = matrix.length + matrix[0].length -1;
	    int i = 0, j = 0;
	    //There can be at most  m + n -1 diagonals to be printed
	    while (c < count) {
	        //Start printing diagonals from i and j
	        printDiagonal(i, j, matrix);
	        if (i < matrix.length -1) {
	            //We increment row index until we reach the max number of rows
	            i++;
	        } else if (j < matrix[0].length - 1) {
	            //We are at maximum index of row; so its time to increment col index
	            //We increment column index until we reach the max number of columns
	            j++;
	        }
	        c++;
	    }
	}
	
	private static void printDiagonal(int i, int j, char[][] m) {
	    while (i >=0 && j< m[0].length ) {
	        System.out.print(m[i][j] + " ");
	        i--;
	        j++;
	    }
	    System.out.println("");
	}
	
	
	//_______________________________________
	//Another method
	public static void printUpperDiagonals(char[][] matrix, int x, int y){
		System.out.println("Matrix Length - "+matrix.length);
		for(int k=0; k<x; k++){
			for(int m=0; m<=k; m++){
				int l = k - m;
				System.out.println(matrix[k][m]+" ");
			}
			System.out.println();
		}
	}
	
	public static void printLowerDiagonals(char[][] matrix, int x, int y){
		System.out.println("Matrix Length - "+matrix.length);
		for( int k = x - 2 ; k >= 0 ; k-- ) {
	        for( int m = 0 ; m <= k ; m++ ) {
	            int l = k - m;
	            System.out.print( matrix[x - m - 1][y - l - 1] + " " );
	        }
	        System.out.println();
	    }

	}

}
