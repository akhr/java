/*
 *  IsArray1RotatedVersionOfArray2.java
 *  Author: Akhash Ramamurthy
 *  Created on: Aug 15, 2017
 */

package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.akh.algorithms.stringAlgorithms.IsPatternASubString;

/**
 *  @fileName: IsArray1RotatedVersionOfArray2.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 15, 2017
 */

public class IsArray1RotatedVersionOfArray2 {

	public static void main(String[] args) {

		//test case 1:
		//		int[] a = new int[]{1,2,3,5,6,7,8};
		//		int[] b = new int[]{5,6,7,8,1,2,3};

		//test case 2:
		//		int[] a = new int[]{1,2,3,5,6,7,8};
		//		int[] b = new int[]{2,3,5,6,7,8,1};

		//test case 3
		int [] a = { 0, 1, 2, 3, 0 };
		int [] b = { 0, 1, 1, 2, 3 };
		System.out.println("Is Rotated Array - "+isRotatedVersionUsingKMP(a, b));
	}

	public static boolean isRotatedVersionUsingKMP(int[] a, int[] b){
		//Concatenate a[] twice - {1,2,3}  becomes {1,2,3,1,2,3}
		//Also convert to String since out KMP impl can work only on Strings
		StringBuilder sB = new StringBuilder();
		int i=0;
		for(int j=0; j<2; j++){
			while(i<a.length){
				sB.append(a[i++]);
			}
			i=0;
		}
		String s = sB.toString();
		
		//Convert to b[] to string
		sB.setLength(0);
		i=0;
		while(i<b.length){
			sB.append(b[i++]);
		}
		String p = sB.toString();
		System.out.println("s = "+s);
		System.out.println("b = "+p);
		return IsPatternASubString.isSubString(s, p);
	}



	/*
	 * This method only works for forward rotation. i.e., left to right
	 * Fails for right to left rotation. Test case 4
	 * So another reliable method is recommended using Knuth Morris Pratt Algorithm
	 */
	public static boolean isRotatedVersion(int[] a, int[] b){
		//Check length of arrays
		if(a.length != b.length)
			return false;

		//Declare two pointers. One for each array
		int aPointer = 0;
		int bPointer = 0;

		//This flag will prevent us walking through the 2nd array in a loop only once
		//Helps avoid going into infinite walk loop
		boolean isFirstTimeWalk = true;
		boolean hasArrayMatchingStarted = false;

		//This loop will run from 0 to n of array 1
		while(aPointer < a.length){

			//If elements at position aPointer and bPointer are equal then incr both pointer 
			// to move to the element in both array
			if(a[aPointer] == b[bPointer]){
				hasArrayMatchingStarted = true;
				aPointer++;
				if(bPointer < b.length-1)
					bPointer++;
				else{ //If reached end of second array then it reset pointer to 0 to rotate
					//Once rotated done mark is1stTimeWalked to false so avoid future loops
					isFirstTimeWalk = false;
					bPointer = 0;
				}
			}else if(!hasArrayMatchingStarted && isFirstTimeWalk && bPointer < b.length-1){
				//Move bPointer until a match is found
				bPointer++;
			}else {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test_1(){
		int[] a = new int[]{1,2,3,5,6,7,8};
		int[] b = new int[]{5,6,7,8,1,2,3};
		System.out.println("Is Rotated Array - "+isRotatedVersion(a, b));
		assertTrue(isRotatedVersionUsingKMP(a, b));
	}

	@Test
	public void test_2(){
		int[] a = new int[]{1,2,3,5,6,7,8};
		int[] b = new int[]{2,3,5,6,7,8,1};
		System.out.println("Is Rotated Array - "+isRotatedVersion(a, b));
		assertTrue(isRotatedVersionUsingKMP(a, b));
	}

	@Test
	public void test_3(){
		int [] a = { 0, 1, 2, 3, 0 };
		int [] b = { 0, 1, 1, 2, 3 };
		System.out.println("Is Rotated Array - "+isRotatedVersion(a, b));
		assertFalse(isRotatedVersionUsingKMP(a, b));
	}

	@Test
	public void test_4(){
		int[] a = new int[]{ 0, 0, 1, 2, 0 };
		int[] b = new int[]{ 0, 0, 0, 1, 2 };
		System.out.println("Is Rotated Array - "+isRotatedVersion(a, b));
		assertTrue(isRotatedVersionUsingKMP(a, b));
	}

}
