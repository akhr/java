package com.akh.algorithms.math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 *  @fileName: X_Of_A_Kind_In_A_Deck_914.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 6, 2018
 *In a deck of cards, each card has an integer written on it.

		Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
		
		Each group has exactly X cards.
		All the cards in each group have the same integer.
		
		
		Example 1:
		
		Input: [1,2,3,4,4,3,2,1]
		Output: true
		Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
		Example 2:
		
		Input: [1,1,1,2,2,2,3,3]
		Output: false
		Explanation: No possible partition.
		Example 3:
		
		Input: [1]
		Output: false
		Explanation: No possible partition.
		Example 4:
		
		Input: [1,1]
		Output: true
		Explanation: Possible partition [1,1]
		Example 5:
		
		Input: [1,1,2,2,2,2]
		Output: true
		Explanation: Possible partition [1,1],[2,2],[2,2]
 */


public class X_Of_A_Kind_In_A_Deck_914 {

	public boolean hasGroupsSizeX(int[] deck) {
		if(deck == null || deck.length <= 0)
			return false;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int item : deck){
			map.put(item, map.getOrDefault(item, 0)+1);	
		}
		
		int res = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			res = gcd(entry.getValue(), res);
		}
		return res > 1;
	}
	
	private int gcd(int a, int b){
		if(a < b)
			return gcd(b,a);
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}


	@Test 
	public void test_1(){
		int[] a = {1,2,3,4,4,3,2,1};
		assertTrue(hasGroupsSizeX(a));
	}

	@Test 
	public void test_2(){
		int[] a = {1,1,1,2,2,2,3,3};
		assertFalse(hasGroupsSizeX(a));
	}

	@Test 
	public void test_3(){
		int[] a = {1,1};
		assertTrue(hasGroupsSizeX(a));
	}

	@Test 
	public void test_4(){
		int[] a = {1,1,2,2,2,2};
		assertTrue(hasGroupsSizeX(a));
	}

	@Test 
	public void test_5(){
		int[] a = {0,0,0,1,1,1,2,2,2};
		assertTrue(hasGroupsSizeX(a));
	}
}
