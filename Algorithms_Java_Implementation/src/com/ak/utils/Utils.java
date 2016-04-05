/**
 * 
 */
package com.ak.utils;

import java.util.Random;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 5, 2016 11:44:38 AM
 * Utils.java
 */
public class Utils {

	public static int[] intGenerator(int size, int min, int max){
		int[] array = new int[size];
		Random random = new Random();
		for(int i=0; i<size-1; i++){
			array[i] = random.nextInt((max - min) + 1) + min;
		}
		return array;
	}
	
	public static void printArray(String message, int[] array) {
		System.out.println("Printing "+message);
		for(int i=0; i<array.length; i++){
			if(i==0)
				System.out.print("[ "+array[i]);
			else if(i==array.length-1)
				System.out.println(" "+array[i]+" ]");
			else
				System.out.print(" "+array[i]);
		}
	}

}
