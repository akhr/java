/**
 * 
 */
package com.akh.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * May 8, 2016 9:27:13 PM
 * MergeArray.java
 */
public class MergeArray {

	public static void main(String[] args) throws IOException{
		int[] input1 = new int[]{1,5,7,7};
		int[] input2 = new int[]{0,1,2,3};
		int[] res = mergeArrays(input1, input2);

		for(int res_i=0; res_i < res.length; res_i++) {
			System.out.println("Out : "+res[res_i]);
		}
	}

	static int[] mergeArrays(int[] a, int[] b) {
		int[] helperArr = new int[a.length + b.length];
		int helperArrIndex = 0;
		int aIndex = 0;
		int bIndex = 0;

		while(aIndex < a.length && bIndex < b.length){
			if(a[aIndex] < b[bIndex]){
				helperArr[helperArrIndex++] = a[aIndex++];
			}
			else if(b[bIndex] < a[aIndex]){
				helperArr[helperArrIndex++] = b[bIndex++];
			}
			else if(a[aIndex] == b[bIndex]){
				helperArr[helperArrIndex++] = a[aIndex++];
				helperArr[helperArrIndex++] = b[bIndex++];
			}
		}

		while(aIndex < a.length){
			helperArr[helperArrIndex++] = a[aIndex++];
		}

		while(bIndex < b.length){
			helperArr[helperArrIndex++] = b[bIndex++];
		}

		return helperArr;
	}

}
