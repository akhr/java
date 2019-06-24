package com.akh.algorithms.dataStructure.tree.bst;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class RangeSumOfBST_938 {

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
	
	public int rangeSumBST_DFS_I_Pre(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int sum = 0;
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(L <= node.val && node.val <= R)
				sum += node.val;
			if(node.left != null && node.val > L)
				stack.push(node.left);
			if(node.right != null && node.val < R)
				stack.push(node.right);
		}
		return sum;
	}
	

	public int rangeSumBST_DFS_R_In(TreeNode root, int L, int R) {
		return helper_DFS_R_In(root, L, R);
	}

	private int helper_DFS_R_In(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		
		int sum = 0;
		if(root.val > L)
			sum += helper_DFS_R_In(root.left, L, R);
		if(root.val >= L && root.val <= R)
			sum += root.val;
		if(root.val < R)
			sum += helper_DFS_R_In(root.right, L, R);	
		return sum;
	}
	
	
	public int rangeSumBST_DFS_R_Pre(TreeNode root, int L, int R) {
		return helper_DFS_R_Pre(root, L, R);
	}

	private int helper_DFS_R_Pre(TreeNode root, int L, int R) {
		if(root == null)
			return 0;
		
		int sum = 0;
		if(root.val >= L && root.val <= R)
			sum += root.val;
		if(root.val > L)
			sum += helper_DFS_R_Pre(root.left, L, R);
		if(root.val < R)
			sum += helper_DFS_R_Pre(root.right, L, R);	
		return sum;
	}
	
	
	@Test
	public void test_DFS_R_In_1() {
		int[] arr = {10,5,15,3,7,-1,18};
		int L = 7; 
		int R = 15;
		int expected = 32;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_R_In(root, L , R));
	}	
	
	@Test
	public void test_DFS_R_In_2() {
		int[] arr = {10,5,15,3,7,13,18,1,-1,6};
		int L = 6; 
		int R = 10;
		int expected = 23;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_R_In(root, L , R));
	}	
	
	@Test
	public void test_DFS_R_Pre_1() {
		int[] arr = {10,5,15,3,7,-1,18};
		int L = 7; 
		int R = 15;
		int expected = 32;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_R_Pre(root, L , R));
	}	
	
	@Test
	public void test_DFS_R_Pre_2() {
		int[] arr = {10,5,15,3,7,13,18,1,-1,6};
		int L = 6; 
		int R = 10;
		int expected = 23;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_R_Pre(root, L , R));
	}
	
	@Test
	public void test_DFS_I_Pre_1() {
		int[] arr = {10,5,15,3,7,-1,18};
		int L = 7; 
		int R = 15;
		int expected = 32;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_I_Pre(root, L , R));
	}	
	
	@Test
	public void test_DFS_I_Pre_2() {
		int[] arr = {10,5,15,3,7,13,18,1,-1,6};
		int L = 6; 
		int R = 10;
		int expected = 23;
		TreeNode root = constructTree(arr, 0);
		assertEquals(expected, rangeSumBST_DFS_I_Pre(root, L , R));
	}
	
	//*******************************  Tree Construction **********************************
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

}
