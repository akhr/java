package com.akh.algorithms.stringAlgorithms;

/**
 *  @fileName: StringPermutation.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 28, 2017
 */

public class StringPermutation {

	public static void main(String[] args) {
		String s = "ABC";
		getPermutation(s, "");
	}
	
	private static void getPermutation(String s, String prefix){
		if(s.length() == 0){
			System.out.println(prefix);
		}else{
			for(int i=0; i<s.length(); i++){
				String rem = s.substring(0, i) + s.substring(i+1);
				getPermutation(rem, prefix + s.charAt(i));
			}
		}
			
	}

}
