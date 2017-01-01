/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

/**
 * @author Akhash Ramamurthy
 * Dec 29, 2016
 */
public class MaxSubarraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{-10, 30, -5, 4, 6, -1, 2, -7, 1, -3};
		int[] res = getMaximumSubarraySum(arr);
		System.out.println("Max sum = "+res[2]);
		System.out.println("Max sum start index = "+res[0]);
		System.out.println("Max sum end index = "+res[1]);
		for(int i = res[0]; i<=res[1]; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static int[] getMaximumSubarraySum(int[] arr){
		int[] res = new int[3];
		int tempSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < arr.length; i++){
			tempSum = tempSum + arr[i];
			//If tempSum is goes negative then reset the value and move startIndex to next location
			if(tempSum < 0){
				tempSum = 0;
				startIndex = i+1;
				//If tempSum goes > maxSum then this is the new maxSum and also extend the endIndex to this position
			}else if(tempSum > maxSum){
				maxSum = tempSum;
				endIndex = i;
			}else{
				//Do Nothing - Go to the next location and investigate
			}
		}
		res[0] = startIndex;
		res[1] = endIndex;
		res[2] = maxSum;
		return res;
	}

}
