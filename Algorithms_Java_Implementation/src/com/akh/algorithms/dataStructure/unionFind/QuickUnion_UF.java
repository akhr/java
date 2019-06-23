/**
 * @fileName: QuickUnion_UF.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Nov 24, 2018
 * 
 */
package com.akh.algorithms.dataStructure.unionFind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * @fileName: QuickUnion_UF.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 24, 2018
 * 
 */
public class QuickUnion_UF extends Abstract_UF{

	@Override
	public void union(int p, int q) {
		int pRoot = getRoot(p);
		int qRoot = getRoot(q);
		mData[pRoot] = qRoot;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}

	@Override
	public int getComponentsCount() {
		return 0;
	}
	
	private int getRoot(int i) {
		while(mData[i] != i) {
			i = mData[i];
		}
		return i;
	}
	
	@Test
	public void test_1() {
		int N = 10;
		QuickUnion_UF uf = new QuickUnion_UF();
		uf.init(N);
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		System.out.println("Step 1 : Arr : "+Arrays.toString(uf.mData)+" Comp cnt : "+
				uf.getComponentsCount());
		assertTrue(uf.isConnected(8, 9));
		assertFalse(uf.isConnected(5, 4));
		uf.union(5, 0);
		uf.union(7, 2);
		System.out.println("Step 2 : Arr : "+Arrays.toString(uf.mData)+" Comp cnt : "+
				uf.getComponentsCount());
		uf.union(6, 1);
		uf.union(7, 3);
		System.out.println("Step 3 : Arr : "+Arrays.toString(uf.mData)+" Comp cnt : "+
				uf.getComponentsCount());
		assertTrue(uf.isConnected(7, 0));  
	}

}
