package com.akh.aa.mudField;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  @fileName: Contest.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 13, 2018
 */

public class Contest {

	public int[] sortArrayByParityII(int[] A) {
		int ePtr = 0;
		int oPtr = 1;
		int len = A.length;

		if(len == 2){
			if(!isEven(A[0]))
				swap(A, 0, 1);
			return A;
		}

		boolean isEStruck = false;
		boolean isOStuck = false;

		while(ePtr < len && oPtr <= len-1){
			if(ePtr < len-1){
				if(isEven(ePtr) && isEven(A[ePtr])){
					ePtr += 2;
				}else{
					if(isOStuck){
						swap(A, ePtr, oPtr);
						ePtr += 2;
						oPtr += 2;
						isEStruck = false;
						isOStuck = false;
					}else{
						isEStruck = true;
					}
				}
			}

			if(oPtr <= len-1){
				if(isOdd(oPtr) && isOdd(A[oPtr])){
					oPtr += 2;
				}else{
					if(isEStruck){
						swap(A, ePtr, oPtr);
						ePtr += 2;
						oPtr += 2;
						isEStruck = false;
						isOStuck = false;
					}else{
						isOStuck = true;
					}
				}
			}
		}
		return A;
	}

	private boolean isEven(int i){
		return i%2 == 0;
	}

	private boolean isOdd(int i){
		return i%2 == 1;
	}

	private void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	@Test public void test_1(){
		int[] a = {4,2,5,7};
		System.out.println("Out - "+Arrays.toString(sortArrayByParityII(a)));
	}

	@Test public void test_2(){
		int[] a = {3,4};
		System.out.println("Out - "+Arrays.toString(sortArrayByParityII(a)));
	}

	@Test public void test_3(){
		int[] a = {3,1,3,2,2,1,1,1,2,0,0,4,0,1,0,1,1,1,2,2};
		System.out.println("Out - "+Arrays.toString(sortArrayByParityII(a)));
	}

	public int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<>();
		char[] chars = S.toCharArray();
		int i = 0;
		int nonPairCnt = 0;

		while(i < S.length()){
			if(chars[i] == '('){
				stack.push('(');
			}else{
				if(stack.isEmpty()){
					nonPairCnt++;
				}else if(stack.peek() != '('){
					nonPairCnt++;
					stack.pop();
				}else{
					stack.pop();
				}
			}
			i++;
		}
		return nonPairCnt + stack.size();
	}
	
	@Test
	public void test_101(){
		String S = "()";
		assertEquals(0, minAddToMakeValid(S));
	}
	
	@Test
	public void test_102(){
		String S = "()))((";
		assertEquals(4, minAddToMakeValid(S));
	}
}
