/**
 * 
 */
package com.akh.algorithms;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Jul 2, 2012
 */
public class PrintOdds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printOdds(100);
	}
	
	public static void printOdds(int maxUpto){
		
//		for(int i=1; i<=maxUpto; i+=2) //Print Evens
		for(int i=1; i<=maxUpto; i+=2) // Print Odds
			System.out.println("i = "+i);
	}

}
