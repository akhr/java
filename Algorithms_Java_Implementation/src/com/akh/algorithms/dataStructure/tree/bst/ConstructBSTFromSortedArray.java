package com.akh.algorithms.dataStructure.tree.bst;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.dfs.FindDeepestNode;

/**
 *  @fileName: ConstructBSTFromSortedArray.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 15, 2017
 */

public class ConstructBSTFromSortedArray {

	public static BinaryTreeNode<Integer> constructBST(int[] dataArr, int start, int end){
		if(start > end)
			return null;

		int mid = (start + end)/2;
		BinaryTreeNode<Integer> newNode = createNewNode(dataArr[mid]);

		newNode.setLeft(constructBST(dataArr, start, mid-1));
		newNode.setRight(constructBST(dataArr, mid+1, end));
		return newNode;
	}

	private static BinaryTreeNode<Integer> createNewNode(int data){
		return new BinaryTreeNode<Integer>(data);
	}

	
	//============================================  TEST  ============================================ //
	@Test
	public void checkBSTConstruction_1(){
		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
		BinaryTreeNode<Integer> root = constructBST(arr, 0, arr.length-1);
		assertEquals(4, root.getData().intValue());
		assertEquals(3, FindDeepestNode.getDeepestNodeUsingDFS(root).getData().intValue());
	}

	@Test
	public void checkBSTConstruction_2(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = constructBST(arr, 0, arr.length-1);
		assertEquals(14, root.getData().intValue());
		assertEquals(90, FindDeepestNode.getDeepestNodeUsingDFS(root).getData().intValue());
	}
	
}
