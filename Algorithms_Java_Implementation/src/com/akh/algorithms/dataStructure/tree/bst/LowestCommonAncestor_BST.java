package com.akh.algorithms.dataStructure.tree.bst;

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
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

		According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
		
		Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
		
		        _______6______
		       /              \
		    ___2__          ___8__
		   /      \        /      \
		   0      _4       7       9
		         /  \
		         3   5
		Example 1:
		
		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
		Output: 6
		Explanation: The LCA of nodes 2 and 8 is 6.
		Example 2:
		
		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
		Output: 2
		Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
		             according to the LCA definition.
 */

public class LowestCommonAncestor_BST {

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

	//===================  NO Stack Method ==========================================================================================================================
	public TreeNode lowestCommonAncestor_No_Stack(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor_No_Stack(root.left, p, q);
		if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor_No_Stack(root.right, p, q);
		return root;
	}
	
	
	
	
	//===================  2 Stack Method ==========================================================================================================================
	public TreeNode lowestCommonAncestor_2_Stack(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null)
			return null;
		
		Stack<TreeNode> p_Parents = getParents(root, p);
		Stack<TreeNode> q_Parents = getParents(root, q);

		while(p_Parents.size() > q_Parents.size()) {
			p_Parents.pop();
		}

		while(q_Parents.size() > p_Parents.size()) {
			q_Parents.pop();
		}

		while(!p_Parents.isEmpty() && !q_Parents.isEmpty()) {
			if(p_Parents.peek().val == q_Parents.peek().val)
				return p_Parents.pop();
			else {
				p_Parents.pop();
				q_Parents.pop();
			}
		}
		return null;
	}

	public Stack<TreeNode> getParents(TreeNode root, TreeNode target){
		Stack<TreeNode> parents = new Stack<>();
		search(root, target, parents);
		System.out.println(Arrays.deepToString(parents.toArray()));
		return parents;	
	}

	private void search(TreeNode root, TreeNode target, Stack<TreeNode> parents) {
		if(root == null || target == null)
			return;
		if(root.val == target.val) { //descendant of itself
			parents.push(root);
			return;
		}

		parents.push(root);
		if(target.val < root.val) {
			search(root.left, target, parents);
		}else {
			search(root.right, target, parents);
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
		LowestCommonAncestor_BST lowestCommonAncestor = new LowestCommonAncestor_BST();
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		//TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_2_Stack(root, p, q); 
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_No_Stack(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(6, commonAncestor.val);
	}

	@Test
	public void test_2(){
		LowestCommonAncestor_BST lowestCommonAncestor = new LowestCommonAncestor_BST();
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		//TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_2_Stack(root, p, q); 
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_No_Stack(root, p, q);
		System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		assertEquals(2, commonAncestor.val);
	}

	@Test
	public void test_One_Not_Child(){
		LowestCommonAncestor_BST lowestCommonAncestor = new LowestCommonAncestor_BST();
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(-2);
		TreeNode q = new TreeNode(4);
		//TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_2_Stack(root, p, q); 
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_No_Stack(root, p, q);
		if(commonAncestor != null) {
			System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		}
		assertTrue(commonAncestor == null);
	}
	

	@Test
	public void test_Both_Not_Child(){
		LowestCommonAncestor_BST lowestCommonAncestor = new LowestCommonAncestor_BST();
		int[] arr = {6,2,8,0,4,7,9,-1,-1,3,5};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(-2);
		TreeNode q = new TreeNode(40);
		//TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_2_Stack(root, p, q); 
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_No_Stack(root, p, q);
		if(commonAncestor != null) {
			System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		}
		assertTrue(commonAncestor == null);
	}
	
	@Test
	public void test_Empty_Tree(){
		LowestCommonAncestor_BST lowestCommonAncestor = new LowestCommonAncestor_BST();
		int[] arr = {};
		TreeNode root = lowestCommonAncestor.constructTree(arr, 0);
		TreeNode p = new TreeNode(-2);
		TreeNode q = new TreeNode(40);
		//TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_2_Stack(root, p, q); 
		TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor_No_Stack(root, p, q);
		if(commonAncestor != null) {
			System.out.println("LowestCommonAncestor of "+p.val+" & "+q.val+" ==> "+commonAncestor.val);
		}
		assertTrue(commonAncestor == null);
	}


}
