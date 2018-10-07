package com.akh.algorithms.dataStructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  @fileName: Complete_Binary_Tree_Inserter_919.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 6, 2018
 *  
 *  A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

		Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:
		
		CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
		CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
		CBTInserter.get_root() will return the head node of the tree.
		 
		
		Example 1:
		
		Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
		Output: [null,1,[1,2]]
		Example 2:
		
		Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
		Output: [null,3,4,[1,2,3,4,5,6,7,8]]
		 
		
		Note:
		
		The initial given tree is complete and contains between 1 and 1000 nodes.
		CBTInserter.insert is called at most 10000 times per test case.
		Every value of a given or inserted node is between 0 and 5000.
		 */

public class Complete_Binary_Tree_Inserter_919 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public Complete_Binary_Tree_Inserter_919(TreeNode root) {
		if(root == null)
			return;
		this.root = root;
		buildDeque();
		//updateNextInsertParent();
	}

	public TreeNode get_root() {
		return this.root;
	}
	
	//===================================  Using DEQUE Method ========================================
	private void buildDeque(){
		deque = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()){
			TreeNode curr = queue.poll();

			if(curr.left == null || curr.right == null)
				deque.offerLast(curr);
			if(curr.left != null)
				queue.offer(curr.left);
			if(curr.right != null)
				queue.offer(curr.right);
		}
	}

	public int insert(int v) {
		TreeNode newNode = new TreeNode(v);
		deque.offerLast(newNode);
		
		TreeNode parent = deque.peekFirst();
		if(parent.left == null){
			parent.left = newNode;
		}else {
			parent.right = newNode;
			deque.pollFirst();
		}
		return parent.val;
	}

	//===================================  Using Simple BFS Method ========================================
	private void updateNextInsertParent(){
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(this.root);

		while(!q.isEmpty()){
			int size = q.size();
			while(size > 0){
				TreeNode curr = q.poll();
				if(curr.left == null || curr.right == null)
					this.nextInsertParent = curr;
				q.offer(curr.left);
				q.offer(curr.right);
			}
		}
	}
	
	public int insert_1(int v) {
		TreeNode newNode = new TreeNode(v);
		TreeNode parent = nextInsertParent;
		if(nextInsertParent.left == null){
			nextInsertParent.left = newNode;
		}else {
			nextInsertParent.right = newNode;
			updateNextInsertParent();
		}
		return parent.val;
	}

	private TreeNode root;
	private TreeNode nextInsertParent;
	private Deque<TreeNode> deque;
}
