package com.akh.algorithms.dataStructure.tree;

import java.util.Stack;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.TreeZigZagLevelOrder.TreeNode;

/**
 *  @fileName: InOrder_Using_Stack.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 16, 2018
 */

public class InOrder_Using_Stack {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	//=======================================================================================
	
	public void inOrder_iterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		
		while(curr != null || !stack.isEmpty()) {
			 while(curr != null) {
				 stack.push(curr);
				 curr = curr.left;
			 }
			 curr = stack.pop();
			 System.out.println("Visiting node (I) - "+curr.val);
			 curr = curr.right;
		}
	}
	
	public void inOrder_recursive(TreeNode root) {
		if(root == null)
			return;
		inOrder_recursive(root.left);
		System.out.println("Visiting Node (R) - "+root.val);
		inOrder_recursive(root.right);
	}
	
	//=======================================================================================
	
	
	
	
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
	
	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex*2)+1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return (parentIndex*2)+2;
	}
	
	@Test
	public void test_recursive() {
		InOrder_Using_Stack inOrder = new InOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = inOrder.constructTree(arr, 0);
		System.out.println("Recursive");
		inOrder_recursive(root);
	}
	
	@Test
	public void test_iterative() {
		InOrder_Using_Stack inOrder = new InOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = inOrder.constructTree(arr, 0);
		System.out.println("Iterative");
		inOrder_iterative(root);
	}

}
