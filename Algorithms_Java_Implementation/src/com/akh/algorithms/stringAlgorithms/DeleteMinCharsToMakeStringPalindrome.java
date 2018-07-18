package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: DeleteMinCharsToMakeStringPalindrome.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 18, 2018
 */

public class DeleteMinCharsToMakeStringPalindrome {

	public static int getMinDelete(String s) throws IllegalArgumentException{
		if(s == null || s.length()==0)
			throw new IllegalArgumentException();

		if(s.length() == 1)
			return 0;

		return getMinDelete(s.toLowerCase(), 0, s.length()-1);
	}

	public static int getMinDelete(String s, int start, int end){
		if(start >= end)
			return 0;

		if(s.charAt(start) == s.charAt(end)){
			return getMinDelete(s, start+1, end-1);
		}else {
			int removeStartChar = getMinDelete(s, start+1, end);
			int removeEndChar = getMinDelete(s, start, end-1);
			int minDeleteChar = 1;
			minDeleteChar += Math.min(removeStartChar, removeEndChar);
			return minDeleteChar;
		}
	}
	
	
	//===========================================================================================================================

	@Test(expected = IllegalArgumentException.class)
	public void testNullString(){
		String s = null;
		getMinDelete(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyString(){
		String s = null;
		getMinDelete(s);
	}
	
	@Test
	public void testZeroCharDelete(){
		String s = "malayalam";
		assertEquals(0, getMinDelete(s));
	}
	
	@Test
	public void testOneCharDelete(){
		String s = "madame";
		assertEquals(1, getMinDelete(s));
	}
	
	@Test
	public void testSevenCharDelete(){
		String s = "GGABZXVYCCDBA";
		assertEquals(7, getMinDelete(s));
	}
}

