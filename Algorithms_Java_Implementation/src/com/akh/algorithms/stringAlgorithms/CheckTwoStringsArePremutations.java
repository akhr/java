package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


/**
 *  @fileName: CheckTwoStringsArePremutations.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 12, 2017
 */

public class CheckTwoStringsArePremutations {
	
	@Test
	public void testCase_0(){
		String s1 = "India";
		String s2 = "";
//		assertFalse(arePremutations_UsingMap(s1, s2));
		assertFalse(arePremutations_UsingSort(s1, s2));
	}
	
	@Test
	public void testCase_1(){
		String s1 = "India";
		String s2 = "iandi";
//		assertTrue(arePremutations_UsingMap(s1, s2));
		assertTrue(arePremutations_UsingSort(s1, s2));
	}
	
	@Test
	public void testCase_2(){
		String s1 = "abcdefghijkl";
		String s2 = "lkjihgfedcba";
//		assertTrue(arePremutations_UsingMap(s1, s2));
		assertTrue(arePremutations_UsingSort(s1, s2));
	}
	
	@Test
	public void testCase_3(){
		String s1 = "aaabbb";
		String s2 = "bababa";
//		assertTrue(arePremutations_UsingMap(s1, s2));
		assertTrue(arePremutations_UsingSort(s1, s2));
	}
	
	@Test
	public void testCase_4(){
		String s1 = "ccccc";
		String s2 = "bbbbb";
//		assertFalse(arePremutations_UsingMap(s1, s2));
		assertFalse(arePremutations_UsingSort(s1, s2));
	}
	
	@Test
	public void testCase_5(){
		String s1 = "ccc";
		String s2 = "bbbbb";
//		assertFalse(arePremutations_UsingMap(s1, s2));
		assertFalse(arePremutations_UsingSort(s1, s2));
	}

	public static boolean arePremutations(String s1, String s2){
		return false;
	}
	
	public static boolean arePremutations_UsingMap(String s1, String s2){
		
		if(s1 == null || s2 == null)
			return false;
		
		if(s1.length() == 0 || s2.length() == 0)
			return false;
		
		if(s1.length() != s2.length())
			return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s1.length(); i++){
			char c = s1.charAt(i);
			if(!charMap.containsKey(c)){
				charMap.put(c, 1);
			}else{
				charMap.put(c, charMap.get(c)+1);
			}
		}
		
		for(int j = 0; j < s2.length(); j++){
			char d = s2.charAt(j);
			if(!charMap.containsKey(d)){
				return false;
			}else{
				if(charMap.get(d) <= 0)
					return false;
				else
					charMap.put(d, charMap.get(d)-1);
			}
		}
		return true;
	}
	
	public static boolean arePremutations_UsingSort(String s1, String s2){
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);
		s1 = new String(s1Arr);
		s2 = new String(s2Arr);
		return s1.equals(s2);
	}
}
