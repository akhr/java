/**
 * 
 */
package com.example.algo.math;

import java.util.Stack;

/**
 * @author ramamurthy
 *
 */
public class ReplaceElementInArrayWithBiggerRight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[]{7, 5, 6, 3, 4, 1, 2, 9, 11 };
		System.out.println("Result = ");
		for(int element : replace(input)){
			System.out.println(element);
		}
	}

/*	private static int[] replace(int[] input){
		int[] output = new int[input.length];
		int hostIndex = 0;

		for(int outer=0; outer<input.length; outer++){
			if(outer ==  input.length-1){
				output[outer]=input[outer];
			}
			
			for(int inner=outer+1; inner<input.length; inner++){
				hostIndex++;
				System.out.println("hostIndex = "+hostIndex);
				if(input[outer]<input[inner]){
					output[outer]=input[inner];
					break;
				}
			}
		}
		return output;
	}*/
	
	private static int[] replace(int[] input){
		Stack<Integer> output = new Stack<Integer>();
		
		for(int outer=0; outer<input.length; outer++){
			
		}
		
		return null;
	}

}
