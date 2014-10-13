package com.example.algo.dataStructure.tree.dfs;

public class GraphMaskProb {
		
	/**
	 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=graphsDataStrucs2 
	 * 
	 * 
	 * In one mode of the grafix software package, 
	 * the user blocks off portions of a masking layer using opaque rectangles. 
	 * The bitmap used as the masking layer is 400 pixels tall and 600 pixels wide. 
	 * Once the rectangles have been blocked off, the user can perform painting actions through the remaining areas of the masking layer, known as holes. 
	 * To be precise, each hole is a maximal collection of contiguous pixels that are not covered by any of the opaque rectangles. 
	 * Two pixels are contiguous if they share an edge, and contiguity is transitive.

	 * You are given a String[] named rectangles, the elements of which specify the rectangles that have been blocked off in the masking layer. 
	 * Each String in rectangles consists of four integers separated by single spaces, with no additional spaces in the string. 
	 * The first two integers are the window coordinates of the top left pixel in the given rectangle, and the last two integers are the window coordinates of its bottom right pixel. 
	 * The window coordinates of a pixel are a pair of integers specifying the row number and column number of the pixel, in that order. 
	 * Rows are numbered from top to bottom, starting with 0 and ending with 399. Columns are numbered from left to right, starting with 0 and ending with 599. 
	 * Every pixel within and along the border of the rectangle defined by these opposing corners is blocked off.
	 * Return a int[] containing the area, in pixels, of every hole in the resulting masking area, sorted from smallest area to greatest.
	 * 
	 * 
	 * 
	 * Class:	grafixMask
	 * Method:	sortedAreas
	 * Parameters:	String[]
	 * Returns:	int[]
	 * Method signature:	int[] sortedAreas(String[] rectangles)
	 * 
	 * {"0 292 399 307"}
	 * Returns: { 116800,  116800 }
	 * The masking layer is depicted below in a 1:4 scale diagram.
	 * 
	 * {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"}
	 * Returns: { 22816,  192608 }


	 */
	

	public GraphMaskProb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = new String[1];
		input[0] = "0 0 599 399";
		String[] input1 = new String[]{"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
		sortedAreas(400, 600, input1);

	}
	
	private static boolean[][] buildBooleanMatrix(int row, int col){
		boolean [][] matrix = new boolean[600][400];
		for(int i=0; i<600; i++){
			for (int j=0; j<400; j++) {
				matrix[i][j] = false;
			}
		}
		return matrix;
	}
	
	private static boolean[][] fillRect(Coordinate start, Coordinate end, boolean[][] matrix){
		for(int i=start.x; i<end.x; i++){
			for (int j=start.y; j<end.y; j++) {
				matrix[i][j] = true;
			}
		}
//		printMatrix(600, 400, matrix);
		return matrix;
	}
	
	public static int[] sortedAreas(int row, int col, String[] rectangles){
		
		boolean[][] matrix = buildBooleanMatrix(row, col);
		
		for(int i=0; i<=rectangles.length-1; i++){
			String[] sArray = rectangles[i].split(" ");
			Coordinate start = new Coordinate(Integer.parseInt(sArray[0]), Integer.parseInt(sArray[1]));
			Coordinate end = new Coordinate(Integer.parseInt(sArray[2]), Integer.parseInt(sArray[3]));
			fillRect(start, end, matrix);
		}
		
		printMatrix(row, col, matrix);
		
		return new int[1];
	}
	
	public static void printMatrix(int row, int col, boolean[][] matrix){
		
		int r= matrix.length;
		for(int x=0; x<row; x++){
			for(int y=0; y<col; y++){
				if(y==0)
					System.out.print("\t|   ");
				if(matrix[x][y] == true){
					System.out.print("*T*"+"   ");
				}else{
					System.out.print("F"+"   ");
				}
				if(y==col-1)
					System.out.print(" |\t");
			}
			System.out.print("\n");
		}
	}
	
	private static class Coordinate{
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
