package com.example.algo;

import java.util.Arrays;

public class FindMaxWhichIsSumOfTwoNosInArray {

	/**
	 * Given an array consists of n positive integers, find the largest C which makes C=A+B. A,B,C are all in the given array.
	 * Example:
	 * 1 1 1 4 5 5 6 6 10 9 C=10
	 * 1 3 6 C=-1, This means the largest C does not exist
	 * I'm looking for an algorithm which is less than O(n^3), Can anyone give me some directions?
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int[] nums = {-1,2,3,5,-2};
		
		int[] input2 = {1,4,15,25,6,6,3};
		//		int[] nums = new int[10];
		//		java.util.Random myRandom = new java.util.Random();
		//		for(int i=0; i<nums.length;i++)
		//		{
		//			nums[i] = myRandom.nextInt(20)-10;//each number ranges from -10 to 10
		//			System.out.print(""+nums[i]+" ");
		//		}
		System.out.println("\nMax sum is in a Subarray "+maxSubsetSum(nums));
		
		System.out.println("\nMax sum of 2 elements  "+maxSumOfTwoElements(input2));
	}

	public static int maxSubsetSum(int[] nums)
	{
		//we need define two key variables before loop
		//firstly we need a temp sum to keep track of the sum of numbers we processed so far
		//also we need a maxSum to keep track of the currently max sum so far for return purpose
		int tempSum = 0;
		int maxSum = 0;
		//we define the following three index variables to keep track of the sum's start and end indexes.
		int tempSumStartIndex = 0;
		int maxSumStart = 0;
		int maxSumEnd = 0;
		for(int i=0; i<nums.length;i++)
		{
			//as discussed in slides, the key is to decide if tempSum+nums[i]>0
			tempSum = tempSum + nums[i];
			if(tempSum>0)//which means this can still be part of our final subset for max sum
			{
				//				tempSum = futureSum;
				//also check if the tempSum is larger than our maxSum recorded so far
				if(tempSum>maxSum)	
				{
					maxSum = tempSum;
					//whenver we update maxSum, we also update maxSum's indexes
					maxSumStart = tempSumStartIndex;
					maxSumEnd = i;//notice i in this closure is the end index
				}
			}
			else//which means the sum so far is negative or zero, which may not be a part of final subset for max sum
			{
				//thus we need reset tempSum
				tempSum = 0;
				//we made one error as we reset the sum that means we ignore the current index, so tempSum = i+1!
				tempSumStartIndex = i+1;//whenever we reset tempsum, we also reset tempSum's start index
			}
		}
		//finally return the maxSum
		//as we cannot return the index values to the method we print out before return in this method
		System.out.print("\n Max Start: "+maxSumStart+"\tEnd: "+maxSumEnd);

		return maxSum;
	}

	public static int maxSumOfTwoElements(int[] a){
		Arrays.sort(a);

		int n = a.length-1;
		int maxSum = -1;
		int startIndex = 0;
		int endIndex = n-1;
		
		int loopCount = 0;
		
		for(int i=n; i>=0; i--){
			startIndex = 0;
			endIndex = i-1;
			loopCount++;
			while(startIndex < endIndex){
				loopCount++;
				if(a[startIndex]+a[endIndex] == a[i]){
					System.out.println("LoopCount = "+loopCount);
					return a[i];
				}else if(a[startIndex]+a[endIndex] < a[i]){
					startIndex++;
				}else{
					endIndex--;
				}
			}
		}
		System.out.println("LoopCount = "+loopCount);
		return maxSum;
	}
}

