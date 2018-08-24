package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert.*;

/**
 *  @fileName: MaxProfitFromAStock.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 5, 2018
 *  
 *  Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */

public class MaxProfitFromAStock {
	
	public class MaxProfitTransaction{
		int buyDay, sellDay, maxProfit;
		public MaxProfitTransaction() {
			buyDay = -1;
			sellDay = -1;
			maxProfit = 0;
		}
	}
	
	public MaxProfitTransaction findMaxProfit(int[] arr){
		MaxProfitTransaction maxProfitTransaction = new MaxProfitTransaction();
		int minPrice = arr[0];
		int minDay = 1;
		for(int i=1; i<arr.length; i++){
			if(arr[i] < minPrice){
				minPrice = arr[i];
				minDay = i;
			}else{
				int profit = arr[i] - minPrice;
				if(profit > maxProfitTransaction.maxProfit){
					maxProfitTransaction.buyDay = minDay;
					maxProfitTransaction.sellDay = i;
					maxProfitTransaction.maxProfit = profit;
				}
			}
		}
		return maxProfitTransaction;
	}
	
	@Test
	public void test_1(){
		int[] arr = new int[]{7,1,5,3,6,4};
		MaxProfitFromAStock maxProfitFromAStock = new MaxProfitFromAStock();
		MaxProfitTransaction maxProfitTransaction = maxProfitFromAStock.findMaxProfit(arr);
		System.out.println("BuyDay - "+maxProfitTransaction.buyDay+", sellDay - "+maxProfitTransaction.sellDay+", maxProfit - "+maxProfitTransaction.maxProfit);
		assertEquals(5, maxProfitTransaction.maxProfit);
	}
	
	@Test
	public void test_2(){
		int[] arr = new int[]{7,6,4,3,1};
		MaxProfitFromAStock maxProfitFromAStock = new MaxProfitFromAStock();
		MaxProfitTransaction maxProfitTransaction = maxProfitFromAStock.findMaxProfit(arr);
		System.out.println("BuyDay - "+maxProfitTransaction.buyDay+", sellDay - "+maxProfitTransaction.sellDay+", maxProfit - "+maxProfitTransaction.maxProfit);
		assertEquals(0, maxProfitTransaction.maxProfit);
	}

}
