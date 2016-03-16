/**
 * 
 */
package com.thesaka.algorithms.stringAlgorithms;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Jul 2, 2012
 */
public class ReversingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "123456789";

		System.out.println("Original String = " + s1);
//		System.out.println("REVERSED String = " + myReverseFunc(s1).toString());
		System.out.println("REVERSED String = " + reverseMethod(s1.toCharArray(), 0, s1.length()-1).toString());
	}

	public static String reverse ( String s ) {
		int length = s.length(), last = length - 1;
		System.out.println("Length = " + length);
		System.out.println("Last = " + last);
		char[] chars = s.toCharArray();
		for ( int i = 0; i < length/2; i++ ) {
			System.out.println("i = " + i);
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		return new String(chars);
	}
	
	private static String reverseMethod(char[] input, int start, int end){
		 if((start==end) || start>end)
			 return new String(input);
		 else{
			 char temp = input[end];
			 input[end] = input[start];
			 input[start] = temp;
			 return reverseMethod(input, start+1, end-1);
		 } 
	}




	public static String myReverseFunc(String input){
		char[] cArray = input.toCharArray();
		int lastIndex = cArray.length-1;
		char temp;
		for(int i=0; i<cArray.length/2; i++){
			temp = cArray[i];
			cArray[i]=cArray[lastIndex-i];
			cArray[lastIndex-i]=temp;
		}

		String reversed = String.valueOf(cArray);
		return reversed;
	}

}
