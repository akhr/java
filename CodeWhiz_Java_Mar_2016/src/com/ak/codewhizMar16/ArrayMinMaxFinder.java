/**
 * 
 */
package com.ak.codewhizMar16;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 9, 2016 10:38:07 AM
 * ArrayMinMaxFinder.java
 */
import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayMinMaxFinder {    

	public static void print(int A[],int i){
		try{
			System.out.println(A[i]);
		}finally{
			int[] range = getRange(A);
			System.out.println(range[0]+" "+range[1]);
		}
	}
	
	private static int[] getRange(int[] A){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<A.length; i++){
			if(A[i] < min){
				min = A[i];
			}
			if(A[i] > max){
				max = A[i];
			}
		}
		
		return new int[]{max, min};
	}
	
	public static void main(String[] args) {
		int N;
		Scanner st=new Scanner(System.in);
		N=st.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]=st.nextInt();
		}
		int i=st.nextInt();
		try
		{
			print(A,i);

		}
		catch(Exception e){
			System.out.println(e.getClass().getName());
		}

	}// end of main
}// end of Solution



/*public class ArrayMinMaxFinder {s

	public static void print(int A[],int i) throws ArrayIndexOutOfBoundsException{
		try{
			System.out.println(A[i]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Caught AOBExcep in print()");
			throw e;
		}
	}


	public static void main(String[] args) {
		int N;
		Scanner st=new Scanner(System.in);
		N=st.nextInt();
		int A[]=new int[N];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
			A[i]=st.nextInt();
			if(A[i] < min){
				min = A[i];
			}
			if(A[i] > max){
				max = A[i];
			}
		}
		int i=st.nextInt();
		try
		{
			print(A,i);
		}
		catch(Exception e){
			System.out.println("Caught AOBExcep in main()");
			System.out.println(e.getClass().getName());
		}finally{
			System.out.println(max+" "+min);
		}

	}// end of main
}// end of Solution
 */

