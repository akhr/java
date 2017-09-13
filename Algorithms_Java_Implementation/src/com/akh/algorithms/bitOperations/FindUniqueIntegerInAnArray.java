package com.akh.algorithms.bitOperations;

/**
 *  @fileName: FindUniqueIntegerInAnArray.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 16, 2017
 */

public class FindUniqueIntegerInAnArray {

	public static void main(String[] args) {
		int B[] = {3,3,2,3};
		int    ones = 0 ;
		int    twos = 0 ;
		int not_threes;
		int x ;

		for(int i=0; i< 10; i++ )
		{
			x =  B[i];
			int step1 = ones & x;
			twos = twos | step1;
			ones ^= x ;
			int oneAndTwo = ones & twos;
			not_threes = ~(oneAndTwo) ;
			ones &= not_threes ;
			twos &= not_threes ;
		}

		System.out.println("unique element = "+ones);
	}
}
