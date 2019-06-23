/**
 * @fileName: BestTimeToBuyAndSellStock_II.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Jun 22, 2019
 * 
 */
package com.akh.algorithms.leetcode.easy.lc122;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @fileName: BestTimeToBuyAndSellStock_II.java
 * @author: Akhash Ramamurthy
 * @Created on: Jun 22, 2019
 * 
 */
public class BestTimeToBuyAndSellStock_II {

	public int maxProfit(int[] prices) {
		if (prices.length < 2) 
			return 0;
		int base = prices[0];
		int profit = 0;
		for(int i=1; i<prices.length; i++) {
			if (prices[i] > base) {
				profit += prices[i] - base;
			}
			base = prices[i];
		}
		return profit;
	}

	@Test
	public void Test_101() {
		int[] in = new int[] {7,1,5,3,6,4};
		assertEquals(7, maxProfit(in));
	}

	@Test
	public void Test_102() {
		int[] in = new int[] {1,2,3,4,5};
		assertEquals(4, maxProfit(in));
	}

	@Test
	public void Test_103() {
		int[] in = new int[] {7,6,4,3,1};
		assertEquals(0, maxProfit(in));
	}

	@Test
	public void Test_104() {
		int[] in = new int[] {2,1,2,0,1};
		assertEquals(2, maxProfit(in));
	}
	
	@Test
	public void Test_105() {
		int[] in = new int[] {5,4,3,2,1,8};
		assertEquals(7, maxProfit(in));
	}
}
