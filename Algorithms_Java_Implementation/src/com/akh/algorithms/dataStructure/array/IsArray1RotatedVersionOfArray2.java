/*
 *  IsArray1RotatedVersionOfArray2.java
 *  Author: Akhash Ramamurthy
 *  Created on: Aug 15, 2017
 */

package com.akh.algorithms.dataStructure.array;

/**
 *  @fileName: IsArray1RotatedVersionOfArray2.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 15, 2017
 */

public class IsArray1RotatedVersionOfArray2 {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,5,6,7,8};
		int[] b = new int[]{5,6,7,8,1,2,3};
//		int[] b = new int[]{2,3,5,6,7,8,1};
		System.out.println("Is Rotated Array - "+isRotatedVersion(a, b));
	}
	
	public static boolean isRotatedVersion(int[] a, int[] b){
		//Check length of arrays
		if(a.length != b.length)
			return false;
		
		int aPointer = 0;
		int bPointer = 0;
		boolean isFirstLoop = true;
		
		while(aPointer < a.length){
			if(a[aPointer] == b[bPointer]){
				aPointer++;
				if(bPointer < b.length-1)
					bPointer++;
				else{
					isFirstLoop = false;
					bPointer = 0;
				}
			}else if(isFirstLoop && bPointer < b.length-1){
				bPointer++;
			}else {
				return false;
			}
		}
		return true;
	}

}
