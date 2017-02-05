/**
 * 
 */
package com.akh.algorithms.bitOperations;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 * Jan 29, 2017
 */
public class FindBitsSetToOneInInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Integer: ");
		int input = sc.nextInt();
//		int input = Integer.MAX_VALUE;
		for(int i = 0; i < 34; i++){
			System.out.println("LS "+i+" :  = "+"Deci: "+(input << i)+" Bin: "+Integer.toBinaryString((input << i)));
		}
		
		/**
		 * The << left shift operator will bring in zeros just as you want to.
		 * The reason why there are 2 right shift operators (>> and >>>) is because in 2's complement 
		 * form negative numbers have a bit value of 1 in the left-most bit position. 
		 * The right shift operator >> will add the sign bit (1 in case of negative numbers, 
		 * and 0 in case of positive numbers or zero) on the left side while the other (>>>) will always add zeros.
		 * 
		 * Both right shift operators have their use.
		 * The language specification states that if bit shifting operators are applied on 
		 * int since it is 32-bit long, only the 5 lowest bit is used to determine how many times to shift the number.
		 * So if you shift by 32 which is 100000 in binary, it is equivalent to shift by 0 
		 * which means not to shift! And if you want to shift a 64-bit long, 
		 * the 6 lowest bit is used only to tell how many times to shift.
		 */
		
		int bitCounter = 0;
		while(input > 0){
			bitCounter += (input & 1);
			input >>>= 1;
		}
		System.out.println("No of 1's in the integer = "+bitCounter);
	}

}
