package com.akh.algorithms.dataStructure.tree;

import java.util.Stack;

import org.junit.Test;

/**
 *  @fileName: TreeTraversal.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 26, 2018
 */

public class TreeTraversal_Iterative {
	public static class TreeNode {
		String val;
		TreeNode left;
		TreeNode right;
		public TreeNode(String x) { this.val = x;}
		@Override
		public String toString() {
			return val;
		}
	}

	public TreeNode constructTree(String[] arr, int currIndx){
		if(currIndx > arr.length-1)
			return null;

		if(arr[currIndx] == null)
			return null;

		TreeNode currNode = new TreeNode(arr[currIndx]);
		currNode.left = constructTree(arr, getLftChdIndx(currIndx));
		currNode.right = constructTree(arr, getRghtChdIndx(currIndx));
		return currNode;
	}

	private int getLftChdIndx(int parentIndx) {
		return (parentIndx*2)+1;
	}

	private int getRghtChdIndx(int parentIndx) {
		return (parentIndx*2)+2;
	}

	private int getParentIndx(int chldIndx) {
		return (chldIndx-1)/2;
	}

	/**=================== Visiting a Node ===================*/
	private String visitNode(TreeNode node) {
		System.out.println("Visiting Node - "+node.val);
		return node.val;
	}

	/**===================  PRE ORDER ========================*/
	public void preOrder_Itr(TreeNode root) {
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode poped;

		while(!stack.isEmpty()) {
			poped = stack.pop();
			visitNode(poped);
			if(poped.right != null)
				stack.push(poped.right);
			if(poped.left != null)
				stack.push(poped.left);
		}
	}

	/**===================  IN ORDER ========================*/
	public void inOrder_Itr(TreeNode root) {
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;

		while(curr != null || !stack.isEmpty()) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else {
				curr = stack.pop();
				visitNode(curr);
				curr = curr.right;
			}
		}
	}


	/**===================  POST ORDER ========================*/
	public void postOrder_Itr(TreeNode root) {
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		TreeNode temp;

		while(curr != null || !stack.isEmpty()) {
			if(curr != null) {
				if(curr.right != null) {
					stack.push(curr.right);
				}
				stack.push(curr);
				curr = curr.left;
				//System.out.println("curr != null - Stack "+stack.toString());
			}else {
				curr = stack.pop();
				if(!stack.isEmpty() && curr.right == stack.peek()) {
					//System.out.println("curr = "+curr+" --- curr.right == stack.peek() - Stack "+stack.toString());
					temp = stack.pop();
					stack.push(curr);
					curr = temp;
				}else {
					//System.out.println("curr = "+curr+" --- curr.right != stack.peek() - Stack "+stack.toString());
					visitNode(curr);
					curr = null;
				}
			}
		}
	}

	/**=================== TEST  ===================*/
	@Test
	public void test_PreOrder() {
		TreeTraversal_Iterative treeTraversal = new TreeTraversal_Iterative();
		String[] arr = {"F", "B", "G", "A", "D", null, "I", null, null,"C", "E", null, null, "H", null};
		TreeNode root = treeTraversal.constructTree(arr, 0);
		System.out.println("PreOrder Iterative - Expected : FBADCEGIH");
		treeTraversal.preOrder_Itr(root);
	}

	@Test
	public void test_InOrder() {
		TreeTraversal_Iterative treeTraversal = new TreeTraversal_Iterative();
		String[] arr = {"F", "B", "G", "A", "D", null, "I", null, null,"C", "E", null, null, "H", null};
		TreeNode root = treeTraversal.constructTree(arr, 0);
		System.out.println("InOrder Iterative - Expected : ABCDEFGHI");
		treeTraversal.inOrder_Itr(root);
	}

	@Test
	public void test_PostOrder() {
		TreeTraversal_Iterative treeTraversal = new TreeTraversal_Iterative();
		String[] arr = {"F", "B", "G", "A", "D", null, "I", null, null,"C", "E", null, null, "H", null};
		TreeNode root = treeTraversal.constructTree(arr, 0);
		System.out.println("PostOrder Iterative - Expected : ACEDBHIGF");
		treeTraversal.postOrder_Itr(root);
	}

}
