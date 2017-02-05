/**
 * 
 */
package com.akh.algorithms.stringAlgorithms;

/**
 * @author Akhash Ramamurthy
 * Jan 31, 2017
 */
public class StringToIntegerConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Res for 478651212 : "+convertToInt("-4qewrewrtw;aodnkjsdblvoierug7865rrr1212t"));
	}
	
	public static int convertToInt(String str){
		int len = str.length()-1;
		int result = 0;
		boolean isNegative = false;
		
		if(str.charAt(0) == '-')
			isNegative = true;
		int end = isNegative ? 1 : 0;
		
		// pow variable is required to keep the power increment correct by avoiding non-numeric chars. 
		// i cant be used since its gets incremented even of it encounters a non-numeric.
		int pow = 0;
		
		// We are starting from behind. 
		// If started from beginning of str then len value will include non-numeric chars count as well
		for(int i = len; i >= end; i--){
			char c = str.charAt(i);
			int digit = c - 48; //as per ascii table ascii(48) = 0. So use 48 as offset.
			if(digit >= 0 && digit <= 9){
				//Only add the digit to result when its a valid char.
				result += digit * Math.pow(10, pow);
				pow++;
			}
		}
		result = isNegative ? -result : result;
		return result;
	}

}
