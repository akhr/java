package com.akh.algorithms.dataStructure.tree.bst;

import static org.junit.Assert.*;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.PrintTree;

/**
 *  @fileName: CheckIfBSTIsBalanced.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 28, 2017
 */

public class CheckIfBSTIsBalanced {
	
	//While getting the height itself will check for the balanced nature of the tree
	public static boolean isBalancedBSTTree(BinaryTreeNode<Integer> root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	private static int checkHeight(BinaryTreeNode<Integer> currNode){
		if(currNode == null)
			return -1;
		
		int lHgt = getHeight(currNode.getLeft());
		if(lHgt == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rHgt = getHeight(currNode.getRight());
		if(rHgt == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int hgtDifference = Math.abs(lHgt - rHgt);
		if(hgtDifference > 1)
			return Integer.MIN_VALUE;
		else
			return  Math.max(lHgt, rHgt) + 1;
	}
	
	//Will visit every single node for every node above it. So visits each node multiple times.
	public static boolean isBalancedBSTTree_NotEfficient(BinaryTreeNode<Integer> root){
		if(root == null)
			return true; //base case
		int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
		if(Math.abs(heightDiff) > 1){
			return false;
		}else{
			return isBalancedBSTTree_NotEfficient(root.getLeft()) && isBalancedBSTTree_NotEfficient(root.getRight());
		}
	}
	
	private static int getHeight(BinaryTreeNode<Integer> currNode){
		if(currNode == null)
			return -1;
		int lHgt = getHeight(currNode.getLeft());
		int rHgt = getHeight(currNode.getRight());
		int maxHgt = Math.max(lHgt, rHgt);
//		System.out.println("For currNode "+currNode.getData()+" lHgt = "+lHgt+" rHgt = "+rHgt);
		return  maxHgt + 1;
	}
	
	@Test
	public void checkIsBalanced_1(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90, 200, 201, 220, 230, 240, 250};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		PrintTree.printTree_BST(root);
		assertTrue(isBalancedBSTTree(root));
	}
	
	@Test
	public void checkIsBalanced_2(){
		int[] arr = new int[]{-10, -8, -6, -4, 1, 5, 7, 12, 14, 15, 16, 17, 27, 33, 64, 78, 90, 200, 201, 220, 230, 240, 250};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		PrintTree.printTree_BST(root);
		assertTrue(isBalancedBSTTree(root));
	}
	
}
