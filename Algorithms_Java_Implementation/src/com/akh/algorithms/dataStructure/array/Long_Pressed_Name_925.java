package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *  @fileName: Long_Pressed_Name_925.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 20, 2018
 *  
 *  Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
		
		You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed
		Example 1:
		
		Input: name = "alex", typed = "aaleex"
		Output: true
		Explanation: 'a' and 'e' in 'alex' were long pressed.
		Example 2:
		
		Input: name = "saeed", typed = "ssaaedd"
		Output: false
		Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
		Example 3:
		
		Input: name = "leelee", typed = "lleeelee"
		Output: true
		Example 4:
		
		Input: name = "laiden", typed = "laiden"
		Output: true
		Explanation: It's not necessary to long press any character.
 */

public class Long_Pressed_Name_925 {
	public boolean isLongPressedName(String name, String typed) {
		if(name == null || typed == null || name.length() <= 0 || typed.length() <= 0)
			return true;
		if(typed.length() < name.length())
			return false;

		int namePtr = 0;
		int typedPtr = 0;
		char[] nameChars = name.toCharArray();
		char[] typedChars = typed.toCharArray();

		
		//Kind of similar to MergeSort comparing two arrays and handling residue of each array.
		while(namePtr < nameChars.length && typedPtr < typedChars.length){
			if(typedChars[typedPtr] == nameChars[namePtr]){
				typedPtr++;
				namePtr++;
			}else if(namePtr>0 && typedChars[typedPtr] == nameChars[namePtr-1]){
				typedPtr++;
			}else{
				return false;
			}
		}

		//Residue in name Chars - No While required. If residue available then required chars not found.
		if(namePtr != nameChars.length)
			return false;

		//Residue in typed Chars
		while(typedPtr < typedChars.length){
			if(typedChars[typedPtr] != nameChars[nameChars.length-1]) {
				return false;
			} 
			typedPtr++;
		}

		return true;
	}

	@Test 
	public void test_1(){
		String n = "alex";
		String t = "aaleex";
		assertTrue(isLongPressedName(n, t));
	}

	@Test 
	public void test_2(){
		String n = "saeed";
		String t = "ssaaedd";
		assertFalse(isLongPressedName(n, t));
	}

	@Test 
	public void test_3(){
		String n = "leelee";
		String t = "lleeelee";
		assertTrue(isLongPressedName(n, t));
	}

	@Test 
	public void test_4(){
		String n = "laiden";
		String t = "laiden";
		assertTrue(isLongPressedName(n, t));
	}

	@Test 
	public void test_5(){
		String n = "dfuyalc";
		String t = "fuuyallc";
		assertFalse(isLongPressedName(n, t));
	}

	@Test 
	public void test_6(){
		String n = "pyplrz";
		String t = "ppyypllr";
		assertFalse(isLongPressedName(n, t));
	}

	@Test 
	public void test_7(){
		String n = "vtkgn";
		String t = "vttkgnn";
		assertTrue(isLongPressedName(n, t));
	}
}
