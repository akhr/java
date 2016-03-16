package com.thesaka.algorithms.math.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation2 {

	public static void main(String args[]) throws IOException{
		String str;
		System.out.println("Enter the initial string");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		str=br.readLine();
		System.out.println("Permutations are :");
		permute("", str);
	}

	public static void permute(String beginningString, String endingString) {
		if (endingString.length() <= 1)
			System.out.println(beginningString + endingString);
		else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString1 = endingString.substring(0, i); 
					String newString2 = endingString.substring(i + 1);
					String newString = newString1 + newString2;

					permute(beginningString + endingString.charAt(i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}
}
