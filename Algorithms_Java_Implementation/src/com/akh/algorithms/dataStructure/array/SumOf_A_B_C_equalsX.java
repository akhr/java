package com.akh.algorithms.dataStructure.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  @fileName: SumOf_A_B_C_equalsX.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 17, 2018
 */

public class SumOf_A_B_C_equalsX {

	public static class Result{
		int a, b, c;

		Result (int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}


	//Brute force O(N^3)
	public static LinkedList<Result> getTriplets_Brute(int[] arr, int sum){
		LinkedList<Result> resultList = new LinkedList<>();
		int counter = 0;
		
		for(int a=0; a<=arr.length-3; a++){
			for(int b=a+1; b<=arr.length-2; b++){
				for(int c=b+1; c<=arr.length-1; c++){
					counter++;
					if((arr[a] + arr[b] + arr[c]) == sum){
						resultList.add(new Result(arr[a], arr[b], arr[c]));
					}
				}
			}
		}
		System.out.println("No of iterations : Brute Force = "+counter);
		return resultList;
	}

	//Optimized O(N^2)
	public static LinkedList<Result> getTriplets_Optimized_1(int[] arr, int sum){
		LinkedList<Result> resultList = new LinkedList<>();
		int counter = 0;

		//Sort array
		Arrays.sort(arr);

		//Fix variable 'a'
		for(int i=0; i<=arr.length-2; i++){
			int SUM = sum - arr[i]; //calculate sum';

			int left = i+1;
			int right = arr.length-1;

			//Check b and c
			while(left < right){
				counter++;
				if(arr[left] + arr[right] == SUM){
					resultList.add(new Result(arr[i], arr[left], arr[right]));
					left++;
					right--;
				}else if(arr[left] + arr[right] < SUM){
					left++;
				}else{
					right--;
				}
			}
		}
		System.out.println("No of iterations : Optimized_1 = "+counter);
		return resultList;
	}

	public static void main(String[] args) {
		int[] input = new int[]{-2,9,2,3,5,0,7,6,8,1,-5,16};
		int sum = 16;
		
		System.out.println("\n\nBrute Force - Required sum = "+sum);
		LinkedList<Result> resultList = getTriplets_Brute(input, sum);
		for(Result item : resultList){
			System.out.println("a="+item.a+" b="+item.b+" c="+item.c);
		}

		System.out.println("\n\n\nOptimized_1 Required sum = "+sum);
		LinkedList<Result> resultList_1 = getTriplets_Optimized_1(input, sum);
		for(Result item : resultList_1){
			System.out.println("a="+item.a+" b="+item.b+" c="+item.c);
		}
	}

}
