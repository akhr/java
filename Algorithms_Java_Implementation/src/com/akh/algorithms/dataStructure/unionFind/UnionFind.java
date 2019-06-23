package com.akh.algorithms.dataStructure.unionFind;

/**
 * @fileName: UnionFind.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 21, 2018
 * 
 */
public interface UnionFind {

	public void union(int p, int q);
	
	public boolean isConnected(int p, int q);
	
	public int getComponentsCount();
}
