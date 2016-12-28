/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

import java.util.Scanner;

/**
 * @author akhash
 *
 */
public class Fibbonaci {
	private static int RECURSION_COUNTER = 0;

	public static void main(String[] args) {
		System.out.println("Enter a number :");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println("Fib - Recursive - "+fibonacciRecusion(n)+" --> RecursionCount - "+RECURSION_COUNTER);
//		printFibonacci(n);

	}

	public static long getFib_Recursive(int n){
		RECURSION_COUNTER++;
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return getFib_Recursive(n-1) + getFib_Recursive(n-2);
	}

	static long n1=0,n2=1,n3=0; 
	static void printFibonacci(int count){    
		if(count>0){    
			n3 = n1 + n2;    
			n1 = n2;    
			n2 = n3;    
			System.out.print(" "+n3);   
			printFibonacci(count-1);    
		}    
	}    

	public static int fibonacciRecusion(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		RECURSION_COUNTER++;
		return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2); // tail recursion
	}

}
