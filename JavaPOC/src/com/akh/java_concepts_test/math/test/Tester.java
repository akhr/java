/**
 * 
 */
package com.akh.java_concepts_test.math.test;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 22, 2012
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Double Min = " + Double.MIN_VALUE);
		System.out.println("Double Max = " + Double.MAX_VALUE);
		System.out.println("Double Min_exp = " + Double.MIN_EXPONENT);
		System.out.println("Double Max_exp = " + Double.MAX_EXPONENT);
		System.out.println("Double Min_nor = " + Double.MIN_NORMAL);
		System.out.println("Double Neg Infi = " + Double.NEGATIVE_INFINITY);
		System.out.println("Double Pos Infi = " + Double.POSITIVE_INFINITY);
		
		System.out.println("Min of = " + Math.max(Double.NEGATIVE_INFINITY, -0.000312));
		String text = "-0.00%";
		System.out.println("String Length -0.00% = "+ text.length());
	}

}
