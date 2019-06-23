/**
 * @fileName: Abstract_UF.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Nov 24, 2018
 * 
 */
package com.akh.algorithms.dataStructure.unionFind;

/**
 * @fileName: Abstract_UF.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 24, 2018
 * 
 */
public abstract class Abstract_UF implements UnionFind{

	protected int[] mData;
	protected int size;

	public Abstract_UF() {
		super();
	}

	public void init(int N) {
		mData = new int[N];
		size = N;
		for(int i=0; i<size; i++) {
			mData[i] = i;
		}
	}
}