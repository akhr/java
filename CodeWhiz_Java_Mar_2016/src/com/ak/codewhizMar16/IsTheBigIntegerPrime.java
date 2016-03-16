/**
 * 
 */
package com.ak.codewhizMar16;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 9, 2016 10:51:18 AM
 * IsTheBigIntegerPrime.java
 */
public class IsTheBigIntegerPrime {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();
		in.close();
		if(n.isProbablePrime(100))
			System.out.println("prime");
		else
			System.out.println("not prime");
	}
}
