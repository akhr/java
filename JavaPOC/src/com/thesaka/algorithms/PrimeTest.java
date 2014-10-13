package com.thesaka.algorithms;

public class PrimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*System.out.println(" 37 isPrime = " + isPrime(37));
		System.out.println(" 103 isPrime = " + isPrime(103));
		System.out.println(" 79 isPrime = " + isPrime(79));
		System.out.println(" 83 isPrime = " + isPrime(83));
		System.out.println(" 81 isPrime = " + isPrime(81));*/
		System.out.println(" 709 isPrime = " + isPrime(709));
//		System.out.println(" 37 isPrime = " + isPrime(37));
//		System.out.println(" 37 isPrime = " + isPrime(37));
	}
	
	private static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
