/**
 * 
 */
package com.thesaka.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 * Date : July 8 2012
 * 
 * Problem statement: 
 * Given an array of n integers, find the sum of the most common integer.
 * Example: (2,4,5,6,4) – return 8 (as 4+4 = 8) 
 * (1,2,1,3,1) – return 3 (as 1+1+1 = 3)
 *
 */
public class SumOfMostCommonIntInArray {

	
	/**
	 * Method which finds the sum of the most common integer in array in a space complexity optimized way - O(n^2)
	 * @param input  input array
	 * @return sum of the most common integer in the input array
	 */
	public static int spaceComplexityOptimized(int[] input){
		int sum = 0;
		int mostCommonInteger = input[1];			// To store the most common integer
		int highestReoccurrenceCount = 0;   		// To store the repeat count
		
		int noOfComparisons = 0;					// To measure time complexity

		for(int i = 0; i<input.length; i++){		//Runs from 0 to N-1 where N is input size
			int reoccurrenceCount = 0;
			for(int j = i; j<input.length; j++){	//Runs from index of the outer for-loop to N-1
				noOfComparisons++;
				if(input[i] ==  input[j]){			// If a number is repeating in the array then increment its reoccuring count
					reoccurrenceCount++;
					
					// If reoccuring count is higher than any other element the store it has the new highest reoccuring count and its corresponding element
					if(highestReoccurrenceCount < reoccurrenceCount){		
						highestReoccurrenceCount++;
						mostCommonInteger = input[i];
					}
				}
			}
		}
		
		if(highestReoccurrenceCount > 1){
			System.out.println("\n*****************  Space Complexity Optimized O(n^2)***************************************");
			System.out.println("Input Array Size = "+ input.length);
			System.out.println("NoOfComparisons to find the solution = " +noOfComparisons);
			System.out.println("Most Common Integer = " + mostCommonInteger +" with repeating count = "+ highestReoccurrenceCount);
			sum = mostCommonInteger * highestReoccurrenceCount;		// Step to calculate the most common integer's sum
			System.out.println("Sum of Most Common Integer = "+ sum);
		}else
			System.out.println("No re-occuring element in the array");
		return sum;
	}
 

	/**
	 * Method which finds the sum of the most common integer in array in a time complexity optimized way - O(n)
	 * @param input  input array
	 * @return sum of the most common integer in the input array
	 */
	public static int timeComplexityOptimized(int[] input){

		if(input.length <=0){
			System.out.println("Input array contains no elements");
			return 0;
		}

		int sum = 0;
		int mostCommonInteger = input[0];			// To store the most common integer
		int highestReoccurrenceCount = 0;			// To store the repeat count
		
		int noOfComparisons = 0;					// To measure time complexity
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<input.length; i++){		//Runs from 0 to N-1 where N is input size
			noOfComparisons++;
			if(map.containsKey(input[i])){
				int reoccurrenceCount = map.get(input[i]) + 1;			//If element available in the map the increment its reoccurence count stored as its value
				if(highestReoccurrenceCount < reoccurrenceCount){
					highestReoccurrenceCount = reoccurrenceCount;
					mostCommonInteger = input[i];
				}
				map.put(input[i], reoccurrenceCount);
			}else{
				if(highestReoccurrenceCount < 1){
					highestReoccurrenceCount = 1;
					mostCommonInteger = input[i];
				}
				map.put(input[i], 1);
			}
		}

		if(highestReoccurrenceCount > 1){
			System.out.println("\n*****************  Time Complexity Optimized O(n)***************************************");
			System.out.println("Input Array Size = "+ input.length);
			System.out.println("NoOfComparisons to find the solution = " +noOfComparisons);
			System.out.println("Most Common Integer = " + mostCommonInteger +" with repeating count = "+ highestReoccurrenceCount);
			sum = mostCommonInteger * highestReoccurrenceCount;		// Step to calculate the most common integer's sum
			System.out.println("Sum of Most Common Integer = "+ sum);
		}else
			System.out.println("No re-occuring element in the array");
		return sum;
	}


	
	
}
