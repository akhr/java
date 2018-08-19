package com.akh.algorithms.dataStructure.tree;

import java.util.Stack;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.InOrder_Using_Stack.TreeNode;

/**
 *  @fileName: PreOrder_Using_Stack.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 17, 2018
 */

public class PreOrder_Using_Stack {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	//=======================================================================================
	
	//root- left - right
	public void preOrder_iterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.println("Visiting Node (I) - "+curr.val);
			
			if(curr.right != null)
				stack.push(curr.right);

			if(curr.left != null)
				stack.push(curr.left);
		}
	}
	
	public void preOrder_recursive(TreeNode root) {
		if(root == null)
			return;
		System.out.println("Visiting Node (R) - "+root.val);
		preOrder_recursive(root.left);
		preOrder_recursive(root.right);
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
		PreOrder_Using_Stack preOrder = new PreOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = preOrder.constructTree(arr, 0);
		System.out.println("Recursive");
		preOrder.preOrder_recursive(root);
	}
	
	@Test
	public void test_iterative() {
		PreOrder_Using_Stack preOrder = new PreOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = preOrder.constructTree(arr, 0);
		System.out.println("Iterative");
		preOrder.preOrder_iterative(root);
	}

}
