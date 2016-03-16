/**
 * 
 */
package com.thesaka.algorithms;

import java.util.Scanner;

/**
 * @author akhashr
 *
 */
public class PrintAllPrimeUptoN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = getValidInputType(); 
		printAllPrimes(limit);
	}

	private static  int getValidInputType(){
		int input = 1; // default choice
		System.out.println("Limit : ");
	 	Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		input = Integer.parseInt(type);
		return input;
	}
	
	/**
	 * @param limit
	 */
	private static void printAllPrimes(int limit){
		if(limit<=1)
			System.out.println("No Primes");
		else if(limit==2)
			System.out.println("Primes : 2");
		else{
			
			for(int dividend=3; dividend<limit; dividend++){
				if(dividend%2==0)
					continue;
				
				boolean isPrime = true;
				int loopCounter = 0;
				for(int divisor=3; divisor<dividend/2; divisor++){
					
					loopCounter++;
					if(dividend%divisor == 0){
						isPrime=false;
						break;
					}
				}
				if(isPrime)
					System.out.println(dividend +" and loopCounter is "+ loopCounter);
			}
		}
			
			
	}
}
