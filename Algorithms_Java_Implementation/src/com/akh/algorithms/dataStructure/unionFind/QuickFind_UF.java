package com.akh.algorithms.dataStructure.unionFind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @fileName: QuickFind_UF.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 21, 2018
 * 
 */
public class QuickFind_UF extends Abstract_UF{
	
	Set<Integer> mGrpSet;
	
	public QuickFind_UF() {	
		super();
	}

	@Override
	public void init(int N) {
		mGrpSet = new HashSet<>();
		super.init(N);
	}
	
	@Override
	public void union(int p, int q) {
		int pGrp = mData[p]; //record val. It will change as you walk the arr
		int qGrp = mData[q]; //record val. It will change as you walk the arr
		mGrpSet.clear();
		for(int i=0; i<size; i++) {
			if(mData[i] == pGrp)
				mData[i] = qGrp;
			mGrpSet.add(mData[i]);
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return mData[p] == mData[q];
	}

	@Override
	public int getComponentsCount() {
		return mGrpSet.size();
	}
	
	@Test
	public void test_1() {
		int N = 10;
		QuickFind_UF quickFind_UF = new QuickFind_UF();
		quickFind_UF.init(N);
		quickFind_UF.union(4, 3);
		quickFind_UF.union(3, 8);
		quickFind_UF.union(6, 5);
		quickFind_UF.union(9, 4);
		quickFind_UF.union(2, 1);
		System.out.println("Step 1 : Arr : "+Arrays.toString(quickFind_UF.mData)+" Comp cnt : "+
				quickFind_UF.getComponentsCount());
		assertTrue(quickFind_UF.isConnected(8, 9));
		assertFalse(quickFind_UF.isConnected(5, 0));
		quickFind_UF.union(5, 0);
		quickFind_UF.union(7, 2);
		System.out.println("Step 2 : Arr : "+Arrays.toString(quickFind_UF.mData)+" Comp cnt : "+
				quickFind_UF.getComponentsCount());
		quickFind_UF.union(6, 1);
		System.out.println("Step 3 : Arr : "+Arrays.toString(quickFind_UF.mData)+" Comp cnt : "+
				quickFind_UF.getComponentsCount());
		assertTrue(quickFind_UF.isConnected(7, 0));  
	}
}
