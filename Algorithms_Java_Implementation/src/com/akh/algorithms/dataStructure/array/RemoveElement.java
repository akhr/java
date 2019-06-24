package com.akh.algorithms.dataStructure.array;

/**
 *  @fileName: RemoveElement.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 7, 2018
 */

public class RemoveElement {

	public static void main(String[] args) {

//		int[] input = {3,2,2,1,2};
//		int[] input = {3,5,6};
		int[] input = {2,8,7,2,2,};
		int target = 2;

		int low = 0;
		int high = input.length -1;

		while(low < high){
			if(input[low] == target && input[high] != target){
				int t = input[low];
				input[low] = input[high];
				input[high] = t;
			}
			
			if( input[low] != target ) {
				++low;
			}else if(input[high]== target) {
				--high;
			}
		}
		
/*		while(low < high){
			if( input[low] != target ) {
	            ++low;
	            continue;
	        }
	        if(input[high]== target) {
	            --high;
	            continue;
	        }
	        int t = input[low];
	        input[low] = input[high];
	        input[high] = t;
		}*/


		for(int x=0;x<input.length;++x) {
			System.out.println(input[x]);
		}
	}
}