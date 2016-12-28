/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

import java.util.Scanner;

/**
 * @author akhash
 * Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 )  , 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 * eg: 
 * 1.)  For n = 1 , output: 0       
 * 2.)  For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    
 * 3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 * Approach / Idea: One can think of greedily choosing the step, which makes n as low as possible and conitnue the same, till it reaches  1. 
 * If you observe carefully, the greedy strategy doesn't work here. 
 * Eg: Given n = 10 , Greedy --> 10 /2 = 5  -1 = 4  /2 = 2  /2 = 1  ( 4 steps ).
 * But the optimal way is --> 10  -1 = 9  /3 = 3  /3 = 1 ( 3 steps ). 
 * So, we need to try out all possible steps we can make for each possible value of n we encounter and choose the minimum of these possibilities.
 * It all starts with recursion :).  
 * F(n) =   1 + min{  F(n-1) ,  F(n/2)  ,  F(n/3)  }  if (n>1) , else 0  ( i.e., F(1) = 0 ). 
 * Now that we have our recurrence equation, we can right way start coding the recursion. 
 * Wait.., does it have over-lapping subproblems ?  YES. 
 * Is the optimal solution to a given input depends on the optimal solution of its subproblems ? Yes... Bingo ! its DP :) 
 * So, we just store the solutions  to the subproblems we solve and use them later on, as in memoization.. 
 * or we start from bottom and move up till the given n, as in dp. 
 * As its the very first problem we are looking at here, lets see both the codes.
 */
public class MinimumStepsToOne {

	private static int RECURSION_COUNTER = 0;
	private static int BOTTOM_UP_COUNTER = 0;
	private static final int USE_MEMOIZATION_DP = 1;
	private static final int USE_BOTTOM_UP_DP = 2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter a number :");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println("Min Steps to 1 for (Recursion) "+n+" --> "+getMinStepsToOne(n, USE_MEMOIZATION_DP));
		System.out.println("Loop Count for Memoization DP - "+RECURSION_COUNTER);
		System.out.println("Min Steps to 1 for (BottomUp DP) "+n+" --> "+getMinStepsToOne(n, USE_BOTTOM_UP_DP));
		System.out.println("Loop Count for BottomUp DP - "+BOTTOM_UP_COUNTER);
	}

	public static int getMinStepsToOne(int n, int mode){
		//Memoization - structure to store
		int[] memo = new int[n+1];
		for(int i = 0 ; i < n+1; i++){
			memo[i] = -1;
		}

		if(mode == USE_MEMOIZATION_DP)
			return getMinStepsToOne_Memo(n, memo);
		else
			return getMinStepsToOne_BottomUp(n);
	}

	public static int getMinStepsToOne_Memo(int n, int[] memo){
		RECURSION_COUNTER++;

		//Base case
		if(n==1)
			return 0;

		//Return result if already calculated
		if(memo[n] != -1)
			return memo[n];

		int result = 0;

		//Result from subtracting 1
		result = 1+getMinStepsToOne_Memo(n-1, memo);

		if(n%2 == 0){
			//2nd option - Result from dividing by 2. Compare result of 1st and 2nd options and find min.
			result = Math.min(result, 1+getMinStepsToOne_Memo(n/2, memo));
		}

		if(n%3 == 0){
			//3rd option - Result from dividing by 3. Compare result of 1st, 2nd and 3rd options and find min.
			result = Math.min(result, 1+getMinStepsToOne_Memo(n/3, memo));
		}

		//Store the result - Memoization
		memo[n] = result;

		return result;
	}

	public static int getMinStepsToOne_BottomUp(int n){

		//Create result array for storing results in Bottom Up DP approach
		int[] results = new int[n+1];
		for(int i = 0 ; i < n+1; i++){
			results[i] = -1;
		}

		//Store base case result in the result array
		results[1] = 0;

		//Start from 2nd position and calculate result for every number till n
		for(int i = 2; i <= n; i++){
			BOTTOM_UP_COUNTER++;
			int res = 1 + results[i-1];
			if(i % 2 == 0)
				res = Math.min(res, 1+results[i/2]);
			if(i % 3 == 0)
				res = Math.min(res, 1+results[i/3]);
			results[i] = res;
		}

		//Return the last result from result array
		return results[n];
	}


}
