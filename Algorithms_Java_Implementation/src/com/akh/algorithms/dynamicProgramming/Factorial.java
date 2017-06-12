package com.akh.algorithms.dynamicProgramming;

/**
 *  @fileName: Factorial.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 11, 2017
 */

public class Factorial {

	public static void main(String[] args) {
		int in = 6;
		System.out.println("Fatorial of "+in+" = "+getFactorial(in));
	}

	static int getFactorial(int n){
		int[] memo = new int[n+1];
		memo[1] = 1;
		memo[2] = 2;
		for(int i=3; i<=n; i++){
			memo[i] = memo[i-1]*i;
		}
		return memo[n];
	}

}
