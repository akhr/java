/**
 * 
 */
package com.akh.topcoder.div2_lower;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 17, 2016 3:04:06 PM
 * Factorial.java
 */
public class Factorial {

	public static void main(String[] args){
		System.out.println("Factorial 0 = "+factorial(0));
		System.out.println("Factorial 1 = "+factorial(1));
		System.out.println("Factorial 3 = "+factorial(3));
		System.out.println("Factorial 5 = "+factorial(5));
	}
	
	public static int factorial(int n){
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		return n*factorial(n-1);
	}

}
