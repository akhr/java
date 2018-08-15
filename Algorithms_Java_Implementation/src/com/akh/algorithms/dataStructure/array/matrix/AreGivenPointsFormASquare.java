package com.akh.algorithms.dataStructure.array.matrix;

import java.util.Scanner;

public class AreGivenPointsFormASquare {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int testCaseCount=scanner.nextInt();
		for(int testCaseIndex=0; testCaseIndex<testCaseCount; testCaseIndex++)
		{
			int[] in = new int[8];
			for(int i=0; i<8; i++){
				in[i] = scanner.nextInt();
			}
			Coordinate[] input = new Coordinate[]{
					new Coordinate(in[0], in[1]),
					new Coordinate(in[2], in[3]),
					new Coordinate(in[4], in[5]),
					new Coordinate(in[6], in[7])
					};
			System.out.println(isSquare(input)?1:0);
		}
	}
	
	private static boolean isSquare(Coordinate[] coordinates){
		int base1 = Math.abs((coordinates[0].x - coordinates[1].x));
		int base2 = Math.abs((coordinates[2].x - coordinates[3].x));
		int height1 = Math.abs((coordinates[0].y - coordinates[1].y));
		int height2 = Math.abs((coordinates[2].y - coordinates[3].y));
		return (base1 == base2) && (height1 == height2);
	}

	
	private static class Coordinate {
		int x;
		int y;
		
		public Coordinate(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}

}
