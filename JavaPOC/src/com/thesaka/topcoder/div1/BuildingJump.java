package com.thesaka.topcoder.div1;

import java.util.Arrays;

public class BuildingJump {

	public BuildingJump() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//2 buildings ans 0
		int[] p1 = new int[]{1,2,1,4,3};

		//3 b ans 2
		int[] p2 = new int[]{19,23,9,12};
		
		//4 b and 4
		int[] p4 = new int[]{4,5,8,2,1,9,4,5,7,9};

		//12 b ans 47
		int[] p3 = new int[]{25,18,38,1,42,41,14,16,19,46,42,39,38,31,43,37,26,41,33,37,45,27,19,24,33,11,22,20,36,4,4};

		System.out.println("Input 1 --> Other Expected for 2 buildings = 0 --> My Answer = "+minimum_others(2, p1));
		System.out.println("Input 2 --> Other Expected for 3 buildings = 2 --> My Answer = "+minimum_others(3, p2));
		System.out.println("Input 3 --> Other Expected for 12 buildings = 47 --> My Answer = "+minimum_others(12, p3));
		System.out.println("Input 4 --> Other Expected for 4 buildings = 2 --> My Answer = "+minimum_others(4, p4));
		
		System.out.println("\n");
		System.out.println("Input 1 --> Expected for 2 buildings = 0 --> My Answer = "+minimum_me(2, p1));
		System.out.println("Input 2 --> Expected for 3 buildings = 2 --> My Answer = "+minimum_me(3, p2));
		System.out.println("Input 3 --> Expected for 12 buildings = 47 --> My Answer = "+minimum_me(12, p3));
		System.out.println("Input 4 --> Expected for 4 buildings = 2 --> My Answer = "+minimum_me(4, p4));

	}

	public static int minimum_others(int M, int[] heights) {
		Arrays.sort(heights);

		int min = Integer.MAX_VALUE;
		for(int i=0; i<heights.length-M+1; i++){
			int total = 0;
			int max = -1;
			for (int j = i; j < i+M; j++) {
				total += heights[j];
				max = Math.max(max, heights[j]);
			}
			min = Math.min(min, max * M - total);
		}
		return min;
	}

	public static int minimum_me(int M, int[] heights) {
		Arrays.sort(heights);

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < heights.length-M+1; i++) {
			min = Math.min(min, getGroupDiff(heights, i, i+M, M));
		}
		return min;
	}

	private static int getGroupDiff(int[] input, int start, int end, int M){
		int max = Integer.MIN_VALUE;
		int total = 0;
		for (int i = start; i < end; i++) {
			max = Math.max(input[i], max);
			total += input[i];
		}
		int res = (max * M - total);
		return res;
	}

}
