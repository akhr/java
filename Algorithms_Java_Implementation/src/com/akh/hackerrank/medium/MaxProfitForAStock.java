/**
 * 
 */
package com.akh.hackerrank.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Akhash Ramamurthy
 * Jan 28, 2017
 */
public class MaxProfitForAStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Day d1 = new Day(1, 10, 20, 10);
		Day d2 = new Day(2, 24, 15, 21);
		Day d3 = new Day(3, 19, 10, 15);
		Day d4 = new Day(4, 30, 18, 19);
		Day d5 = new Day(5, 28, 12, 81);
		Day d6 = new Day(6, 28, 12, 16);
		Day d7 = new Day(7, 28, 12, 42);
		Day d8 = new Day(8, 28, 12, 44);
		
		Day[] days = new Day[]{d1, d2, d3, d4, d5, d6, d7, d8};
		
		printData(days);
		int max = findMaxProfit(days);
		System.out.println("Max Profit - "+max);
	}
	
	private static int findMaxProfit(Day[] days){
		int maxProfit = Integer.MIN_VALUE;
		int minStartPrice = Integer.MAX_VALUE;
		for(Day day : days){
			minStartPrice = Math.min(minStartPrice, day.open);
			maxProfit = Math.max(maxProfit, day.open - minStartPrice);
		}
		return maxProfit;
	}
	
	private static void printData(Day[] days){
		System.out.println("Printing Days: ");
		for(Day day : days){
			System.out.println("Day : "+day.dayIndex+" open : "+day.open);
		}
	}
	
	private static class Day implements Comparable<Day>{
		int dayIndex;
		int hi;
		int low;
		int open;
		
		Day(int dayIndex, int hi, int low, int open){
			this.dayIndex = dayIndex;
			this.hi = hi;
			this.low = low;
			this.open = open;
		}

		@Override
		public int compareTo(Day o) {
			if(this.open == o.open)
				return 0;
			else if(this.open > o.open)
				return 1;
			else
				return -1;
		}
	}

}
