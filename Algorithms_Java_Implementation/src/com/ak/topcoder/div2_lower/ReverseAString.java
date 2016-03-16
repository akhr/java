/**
 * 
 */
package com.thesaka.topcoder.div2_lower;

/**
 * @author Akhash Ramamurthy
 *
 *         Feb 16, 2016 11:05:01 PM ReverseAString.java
 */
public class ReverseAString {

	public static void main(String[] args) {
		String input1 = "ABCDEF";
		String input2 = "1234567890";
		System.out.println("ABCDEF = "+reverse(input1.toCharArray(), 0, input1.length()-1));
		System.out.println("1234567890 = "+reverse(input2.toCharArray(), 0, input2.length()-1));

	}

	public static String reverse(char[] cArr, int start, int end) {
		if (start != end) {
			char temp = cArr[start];
			cArr[start] = cArr[end];
			cArr[end] = temp;
		}
		if (start + 1 < end - 1)
			reverse(cArr, start + 1, end - 1);
		return new String(cArr);
	}

}
