/**
 * 
 */
package com.akh.algorithms.math.matrix;

/**
 * @author Akhash Ramamurthy
 * Apr 30, 2017
 */
public class Matrix90Rotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 4;
		int[][] matrix = createMatrix(N, N);
		
		System.out.println("Original Matrix :");
		printMatrix(matrix, N);
		System.out.println("\n\n90 Degrees Rotated Matrix :");
		printMatrix(rotate90(matrix, N), N);
		
		System.out.println("\n\n180 Degrees Rotated Matrix :");
		printMatrix(rotate90(matrix, N), N);
		
		System.out.println("\n\n270 Degrees Rotated Matrix :");
		printMatrix(rotate90(matrix, N), N);
		
		System.out.println("\n\n360 Degrees Rotated Matrix :");
		printMatrix(rotate90(matrix, N), N);
	}
	
	private static int[][] createMatrix(int M, int N){
		int index = 1;
		int[][] matrix = new int[M][N];
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				matrix[i][j] = index++;
			}
		}
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix, int N){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	private static int[][] rotate90(int[][] matrix, int N){
		
		for(int layer=0; layer<N-1; layer++){
			int first = layer;
			int last = N-1-layer;
//			System.out.println("\n\nLayer "+layer+" : ");
			
			for(int i=first; i<last; i++){
//				System.out.println("\nRecursion "+i+" : ");
				
				int offset = i-first;  //Required for the layers more than 0.
				/*
                int left = matrix[last-offset][first];
				int top = matrix[first][i];
				int right = matrix[i][last];
				int bottom = matrix[last][last-offset];
				System.out.println("Left: "+left);
				System.out.println("top: "+top);
				System.out.println("right: "+right);
				System.out.println("bottom: "+bottom);
				*/
				
				//Store in temp for swap
				int temp = matrix[first][i];
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				//top -> right
				matrix[i][last] = temp;
			}
		}
		return matrix;
	}

}
