/*
 *  FindCenturyOfAYear.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jun 10, 2017
 */

package com.akh.algorithms.dataStructure.array.range;

import com.akh.utils.Utils;

/**
 *  @fileName: FindCenturyOfAYear.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 10, 2017
 */

public class FindCenturyOfAYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int year = 2016;
		System.out.println("dCount  - "+getDigitCount(year));
		getDigits(year, getDigitCount(year));
		System.out.println("Century - "+centuryFromYear(year));
		System.out.println("Century_2 - "+centuryFromYear_2(year));
	}


	static int centuryFromYear(int year) {
		if(year >= 1 && year <=100)
			return 1;
		else{
			int digitCount = getDigitCount(year);
			int[] digits = getDigits(year, digitCount);
			int century = getCentury(year, digitCount, digits);
			return century;
		}
	}

	static int getDigitCount(int year){
		int dCount = 0;
		while(year > 0){
			year = year/10;
			dCount++;
		}
		return dCount;
	}

	static int[] getDigits(int year, int dCount){
		int[] digits = new int[dCount];
		int i = 0;
		while(dCount > 0){
			digits[i] = (int) (year/(Math.pow(10, dCount-1)));
			year = (int) (year - digits[i]*(Math.pow(10, dCount-1)));
			i++;
			dCount--;
		}
		Utils.printArray("Digits in a year", digits);
		return digits;
	}

	static int getCentury(int year, int dCount, int[] digits){
		int century;
		if(dCount == 3){
			century = digits[0] + 1;
		}else{
			century = digits[0]*10 + digits[1] + 1;
		}
		
		if(year == (century-1) * 100)
			century--;
		
		return century;
	}
	
	/*====================================*/
	static int centuryFromYear_2(int year){
		return 1+((year-1)/100);
	}
}
