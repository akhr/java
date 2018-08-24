package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *  @fileName: SearchBinaryTree.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 24, 2018
 */

public class SearchBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }

		@Override
		public String toString() {
			return ("Node val = "+val);
		}
	}

	
	
	
	public boolean search(TreeNode root, int search) {
		String printVal = (root == null) ? "NULL" : String.valueOf(root.val);
		System.out.println("Searching Node - "+printVal);	

		if(root == null)
			return false;

		if(root.val == search)
			return true;

		//This will optimize. You can also do "return search(root.left, search) || search(root.right, search)
		boolean leftRes = false, rightRes = false;
		if(root.left != null)
			leftRes = search(root.left, search);
		if(root.right != null)
			rightRes = search(root.right, search);
		
		return  leftRes || rightRes;
	}
	
	
	

	private TreeNode constructTree(int[] data, int index) {
		if(index > data.length-1)
			return null;

		if(data[index] == -1) {
			return null;
		}

		TreeNode node = new TreeNode(data[index]);
		node.left = constructTree(data, getLeftChildIndex(index));
		node.right = constructTree(data, getRightChildIndex(index));
		return node;
	}

	private int getParentIndex(int childIndex) {
		return ((childIndex - 1) / 2);
	}

	private int getLeftChildIndex(int parentIndex) {
		return ((parentIndex * 2) + 1);
	}

	private int getRightChildIndex(int parentIndex) {
		return ((parentIndex * 2) + 2);
	}

	@Test
	public void test_1(){
		SearchBinaryTree searchBinaryTree = new SearchBinaryTree();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = searchBinaryTree.constructTree(arr, 0);
		int searchVal = 6;
		System.out.println("\nSearch Started for "+searchVal);
		boolean res = searchBinaryTree.search(root, searchVal);
		System.out.println("Tree contains -  ==> "+res);
		assertTrue(res);
	}

	@Test
	public void test_2(){
		SearchBinaryTree searchBinaryTree = new SearchBinaryTree();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = searchBinaryTree.constructTree(arr, 0);
		int searchVal = 8;
		System.out.println("\nSearch Started for "+searchVal);
		boolean res = searchBinaryTree.search(root, searchVal);
		System.out.println("Tree contains -  ==> "+res);
		assertTrue(res);
	}


	@Test
	public void test_Not_Found(){
		SearchBinaryTree searchBinaryTree = new SearchBinaryTree();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = searchBinaryTree.constructTree(arr, 0);
		int searchVal = 80;
		System.out.println("\nSearch Started for "+searchVal);
		boolean res = searchBinaryTree.search(root, searchVal);
		System.out.println("Tree contains -  ==> "+res);
		assertFalse(res);
	}

}
