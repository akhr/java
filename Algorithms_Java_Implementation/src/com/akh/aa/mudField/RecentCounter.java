package com.akh.aa.mudField;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 *  @fileName: RecentCounter.java
 *  @author: Akhash Ramamurthy
 *  Created on: Nov 3, 2018
 */

public class RecentCounter {
	List<Integer> mData;
	Queue<Integer> mQueue;

	public RecentCounter() {
		mData = new ArrayList<Integer>();
		mQueue = new LinkedList<>();
	}

	public int ping(int t) {
		int left = Arrays.binarySearch(mData.toArray(), t);
		if(left < 0){
			left = -(left)-1;
		}
		int right = t+3000;
		int res = mData.size() - left + 1;
		mData.add(right);
		return res;
	}

	public int ping_2(int t) {
		while(!mQueue.isEmpty()) {
			if(mQueue.peek() < t-3000) 
				mQueue.poll();
			else
				break;
		}
		mQueue.offer(t);
		return mQueue.size();
	}

	@Test
	public void test_1() {
		RecentCounter rC = new RecentCounter();
		assertEquals(1, rC.ping(1));
		assertEquals(2, rC.ping(100));
		assertEquals(3, rC.ping(3001));
		assertEquals(3, rC.ping(3002));
	}
	
	@Test
	public void test_2() {
		RecentCounter rC = new RecentCounter();
		assertEquals(1, rC.ping_2(1));
		assertEquals(2, rC.ping_2(100));
		assertEquals(3, rC.ping_2(3001));
		assertEquals(3, rC.ping_2(3002));
	}
}
