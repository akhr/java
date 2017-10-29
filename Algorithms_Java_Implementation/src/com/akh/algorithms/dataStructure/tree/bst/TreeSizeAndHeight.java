package com.akh.algorithms.dataStructure.tree.bst;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/**
 *  @fileName: TreeSizeAndHeight.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class TreeSizeAndHeight {
	
	private static int getTreeHeight(BinaryTreeNode<Integer> currNode){
		int treeSize = getTreeSize(currNode);
		int depth = (int)Math.ceil((Math.log(treeSize) / Math.log(2)));
		return depth;
	}

	private static int getTreeHeight_Better(BinaryTreeNode<Integer> currNode){
		if(currNode == null)
			return 0;
		int leftSubTreeHt = getTreeHeight_Better(currNode.getLeft());
		int rightSubTreeHt = getTreeHeight_Better(currNode.getRight());
		
		int maxSubTreeHt = Math.max(leftSubTreeHt, rightSubTreeHt);
		
		return maxSubTreeHt + 1;
	}

	private static int getTreeSize(BinaryTreeNode<Integer> currNode){
		if (currNode == null)
			return 0;
		return getTreeSize(currNode.getLeft()) + 1 + getTreeSize(currNode.getRight());
	}
	
	@Test 
	public void checkDepth(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		int depth = getTreeHeight(root);
		assertEquals(depth, 4);
	}
	
	@Test 
	public void checkDepth_Better(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		int depth = getTreeHeight_Better(root);
		assertEquals(depth, 4);
	}

	@Test 
	public void checkTreeSize(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		int treeSize = getTreeSize(root);
		assertEquals(treeSize, 10);
	}
}
