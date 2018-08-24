/**
 * 
 */
package com.akh.algorithms.dynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

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
		System.out.println("-----  DP 3 vars Method");
		printFibonacciUsing3Variables(n);
		System.out.println("\n-----  DP Method");
		printFibStartToEnd(n);
		System.out.println("-----  Iterative Method");
		printFibIterative(n);
		System.out.println("-----  Return Array - Iterative Method");
		int[] resultArray = returnFibIterative(n);
		for(int item : resultArray)
			System.out.println(item);
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
		if(count==0){
			System.out.print(0); 
			return;
		}
		if(count==1){
			System.out.print(1);
			return;
		}
		n3 = n1 + n2;    
		System.out.print(" "+n3); 
		n1 = n2;    
		n2 = n3;     
		printFibonacciUsing3Variables(count-1);    
	}   

	public static int printFibIterative(int n){
		if(n == 0){
			System.out.println(0);
			return 0;
		}
		if(n == 1){
			System.out.println(0);
			return 1;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(1);
		for(int i=2; i<=n; i++){
			int temp = stack.pop();
			int newItem = temp + stack.peek();
			System.out.println(newItem);
			stack.push(temp);
			stack.push(newItem);
		}
		return stack.peek();
	}

	public static int[] returnFibIterative(int n){

		if(n == 0)
			return new int[0];
		if(n == 1)
			return new int[]{0,1};

		int grandParent;
		int parent;
		int child;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		for(int i=2; i<=n; i++){
			parent = stack.pop();
			grandParent = stack.pop();
			child = parent + grandParent;
			stack.push(grandParent);
			stack.push(parent);
			stack.push(child);
		}

		int[] result = new int[stack.size()];
		for(int i = stack.size()-1; i>=0; i--){
			result[i] = stack.pop().intValue();
		}
		return result;
	}
}

