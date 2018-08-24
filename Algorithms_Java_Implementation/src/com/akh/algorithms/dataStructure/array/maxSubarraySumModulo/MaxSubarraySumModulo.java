/**
 * 
 */
package com.akh.algorithms.dataStructure.array.maxSubarraySumModulo;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 * Jan 8, 2017
 */
public class MaxSubarraySumModulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCaseData[] inputs = getInputs();
		for(TestCaseData input : inputs){
			System.out.println(getMaxSubarraySumModulo(input));
		}

	}
	
	public static long getMaxSubarraySumModulo(TestCaseData input){
		long maxSumModulo = Long.MIN_VALUE;
		long tempSum = 0;
		long tempModulo = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < input.n; i++){
			tempSum = tempSum + input.data[i];
			tempModulo = tempSum % input.m;
			if(tempModulo > maxSumModulo){
				maxSumModulo = tempModulo;
				endIndex = i;
			}else{
				//Do nothing
				//input.data[i] doesn't contribute anything useful.So go to next.
			}
			
		}
		return maxSumModulo;
	}
	
	private static TestCaseData[] getInputs(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of queries : ");
		int queryCount = scanner.nextInt();
		TestCaseData[] testCaseDataCollection = new TestCaseData[queryCount];
		
		for(int index = 0; index < queryCount; index++){
			TestCaseData testCaseData = new TestCaseData();
			System.out.println("Enter n :");
			testCaseData.n = scanner.nextInt();
			System.out.println("Enter m :");
			testCaseData.m = scanner.nextLong();
			testCaseData.data = new long[testCaseData.n];
			System.out.println("Enter array data :");
			for(int i = 0; i < testCaseData.n; i++){
				testCaseData.data[i] = scanner.nextLong();
			}
			testCaseDataCollection[index] = testCaseData;
			queryCount--;
		}
		return testCaseDataCollection;
	}
	
	public static class TestCaseData{
		int n;
		long m;
		long[] data;
	}

}
