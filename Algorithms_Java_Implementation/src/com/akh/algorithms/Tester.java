/**
 * 
 */
package com.akh.algorithms;

import java.util.Scanner;

/**
 * @author Akhash
 *
 */
public class Tester {

	public static void main(String[] args) {

		int[] input1 = new int[]{2,4,5,6,4};
		int[] input2 = new int[]{1,2,1,3,1};
		int[] input3 = new int[]{12,0,-3,34,23,9,10,34,23,3/2};
		int[] input4 = new int[]{};
		int[] input5 = new int[]{1,3,4,7,23,77,32,23,90,0,1,0,23,56,3,1,23,90,67,54,34,12,0,1,23,54,34,75,12,23};

		System.out.print(" Type 1: Input Array 1 given in problem statement \n");
		System.out.print(" Type 2: Input Array 2 given in problem statement \n");
		System.out.print(" Type 3: Input Array with rational numbers \n");
		System.out.print(" Type 4: Input Array containing no elements \n");
		System.out.print(" Type 5: Input Array where n is large \n");
		System.out.print("Please choose any one type of input array : \n");

		switch (getValidInputType()) {
		case 1:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input1);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input1);
			break;
		case 2:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input2);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input2);
			break;
		case 3:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input3);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input3);
			break;
		case 4:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input4);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input4);
			break;
		case 5:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input5);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input5);
			break;

		default:
			SumOfMostCommonIntInArray.spaceComplexityOptimized(input1);
			SumOfMostCommonIntInArray.timeComplexityOptimized(input1);
			break;
		}

	}

	
	
	/**
	 * Valides user selection
	 * @return int - user selection
	 */
	private static  int getValidInputType(){
		int inputType = 1; // default choice
	 	Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		inputType = Integer.parseInt(type);
		if(inputType > 6 || inputType < 0){
			System.out.println("Please enter a valid chose :");
			getValidInputType();
		}
		return inputType;
	}
	
}
