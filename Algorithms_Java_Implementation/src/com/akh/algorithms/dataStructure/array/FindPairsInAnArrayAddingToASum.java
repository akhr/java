/*
 *  FindPairsInAnArrayAddingToASum.java
 *  Author: Akhash Ramamurthy
 *  Created on: Aug 13, 2017
 */

package com.akh.algorithms.dataStructure.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  @fileName: FindPairsInAnArrayAddingToASum.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 13, 2017
 */

public class FindPairsInAnArrayAddingToASum {
	
	public static class ResultPair{
		int a;
		int b;
		
		public ResultPair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {
		int[] items = new int[]{1,2,3,4,5,5,6,7,4,5,9,6};
		System.out.println("Pairs: ");
		LinkedList<ResultPair> list = getPairsAddingToSum(items, 10);
		for(ResultPair resultItem : list){
			System.out.println("--> "+resultItem.a+", "+resultItem.b);
		}
	}
	
	
	//BigO = O(N) --> No item in the array gets revisted. At max only once.
	public static LinkedList<ResultPair> getPairsAddingToSum(int[] items, int prescribedSum){
		LinkedList<ResultPair> list = new LinkedList<>();
		
		//Sort the array 
		Arrays.sort(items);
		
		//Introduce left and right pointers
		int left = 0;
		int right = items.length-1;
		
		//Navigate from both directions
		while(left < right){
			if(items[left] + items[right] == prescribedSum){
				addThePair(items[left], items[right], list);
				//Increment left and decrement right
				left++;
				right--;
			}else if(items[left] + items[right] < prescribedSum){
				left++;
			}else{
				right--;
			}
		}
		
		return list;
	}
	
	public static ResultPair addThePair(int a, int b, LinkedList<ResultPair> list){
		ResultPair newNode = new ResultPair(a, b);
		list.add(newNode);
		return newNode;
	}

}
