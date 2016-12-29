/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 */
public class Fibbonaci {
	private static int RECURSION_COUNTER = 0;
	private static int LOOP_COUNTER = 0;

	public static void main(String[] args) {
		System.out.println("Enter a number :");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		printFibonacciUsing3Variables(n);
		printFibStartToEnd(n);
	}

	//Classic recusive approach. Doesnt work for n >= 100
	public static long getFib_Recursive(int n){
		RECURSION_COUNTER++;
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return getFib_Recursive(n-1) + getFib_Recursive(n-2);
	}
	
	//Bottom Up DP approach
	public static void printFibStartToEnd(int n){
		if(n <= 0)
			System.out.println(0);
		else{
			System.out.println(0);
			System.out.println(1);
		}
		long res[] = new long[n+1];
		res[1] = 0;
		res[2] = 1;
		for(int i = 3; i <= n; i++){
			LOOP_COUNTER++;
			res[i] = res[i-1] + res[i-2];
			System.out.println(res[i]);
		}
		System.out.println("Loop Counter - "+LOOP_COUNTER);
	}

	//Using variables approach
	static long n1=0,n2=1,n3=0; 
	static void printFibonacciUsing3Variables(int count){    
		if(count>0){    
			n3 = n1 + n2;    
			n1 = n2;    
			n2 = n3;    
			System.out.print(" "+n3);   
			printFibonacciUsing3Variables(count-1);    
		}    
	}   
}
