package com.example.algo.stringAlgorithms;

import java.io.ObjectOutputStream.PutField;
import java.util.Scanner;
import java.util.Stack;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter String to compress : \t");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("Input - "+input);
		System.out.println("Compressed - "+compress(input));

	}

	/**
	 * Input: OriginalString = "aabcccccaaa"
	 * Output: "a2b1c5a3"
	 * if(compressed string longer than original string then return original string)
	 * 
	 */
	public static String compress(String str){
		int repeatCount = 0;
		int size = 0;
		char last = str.charAt(0);
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i) == last)
				repeatCount++;
			else{
				last = str.charAt(i);
				size = size + 1 + String.valueOf(repeatCount).length();
				repeatCount = 1;
			}
		}
		
		size = size + 1 + String.valueOf(repeatCount).length();
		if(size>= str.length())
			return str;
		
		StringBuffer buf = new StringBuffer(size);
		repeatCount = 1;
		last = str.charAt(0);
		for(int i=1; i<str.length();i++){
			if(str.charAt(i) == last)
				repeatCount++;
			else{
				buf.append(last);
				buf.append(repeatCount);
				last = str.charAt(i);
				repeatCount = 1;
			}
		}
		
		buf.append(last);
		buf.append(repeatCount);
		return buf.toString();
		
	}

}
