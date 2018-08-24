package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 *  @fileName: LowestCommonAncestor_BST.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 23, 2018
 *  
		Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
		
		According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
		
		Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
		
		        _______3______
		       /              \
		    ___5__          ___1__
		   /      \        /      \
		   6      _2       0       8
		         /  \
		         7   4
		Example 1:
		
		Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
		Output: 3
		Explanation: The LCA of of nodes 5 and 1 is 3.
		Example 2:
		
		Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
		Output: 5
		Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
		             according to the LCA definition.
		Note:
		
		All of the nodes' values will be unique.
		p and q are different and both values will exist in the binary tree.
 */


public class LowestCommonAncestor_BT {

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

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		
		TreeNode left = null, right = null;
		if(p.val == root.val || q.val == root.val) {
			return root;
		}else {
			left = lowestCommonAncestor(root.left, p, q);
			right = lowestCommonAncestor(root.right, p, q);
		}
		
		if(left == null && right == null) {
			return null;
		}else if(left == null) {
			return right;
		}else if(right == null) {
			return left;
		}else {
			return root;
		}
	}
	
	
	
	
	
	//=============================================================================================================================================

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
		LowestCommonAncestor_BT lowestCommonAncestor = new LowestCommonAncestor_BT();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(3, commonAncestor.val);
	}

	@Test
	public void test_2(){
		LowestCommonAncestor_BT lowestCommonAncestor = new LowestCommonAncestor_BT();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(5, commonAncestor.val);
	}
	
	@Test
	public void test_3(){
		LowestCommonAncestor_BT lowestCommonAncestor = new LowestCommonAncestor_BT();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(7);
		TreeNode q = new TreeNode(8);
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(3, commonAncestor.val);
	}

	@Test
	public void test_4(){
		LowestCommonAncestor_BT lowestCommonAncestor = new LowestCommonAncestor_BT();
		int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(6);
		TreeNode q = new TreeNode(4);
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(5, commonAncestor.val);
	}
}
