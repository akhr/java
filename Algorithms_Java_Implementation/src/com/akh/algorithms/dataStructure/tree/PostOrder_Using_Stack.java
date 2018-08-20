package com.akh.algorithms.dataStructure.tree;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 *  @fileName: PostOrder_Using_Stack.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 17, 2018
 */

public class PostOrder_Using_Stack {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	//=======================================================================================

	//root- left - right
	public void postOrder_iterative_2_stack(TreeNode root) {
		if(root == null)
			return;

		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);

		while(!s1.isEmpty()) {
			TreeNode s1Poped = s1.pop();
			s2.push(s1Poped);
			if(s1Poped.left != null)
				s1.push(s1Poped.left);
			if(s1Poped.right != null)
				s1.push(s1Poped.right);
		}

		while(!s2.isEmpty()) {
			System.out.println("Visiting Node (I 2 stack) - "+s2.pop().val);
		}

	}

	
	//Needs understanding
	public void postOrder_iterative_1_stack(TreeNode head) {
		if (head == null) {
			return;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(head);
		TreeNode lastPoped = head;

		while (!stack.isEmpty()) {
			TreeNode next = stack.peek();

			boolean finishedSubtrees = (next.right == lastPoped || next.left == lastPoped);
			boolean isLeaf = (next.left == null && next.right == null);
			if (finishedSubtrees || isLeaf) {
				stack.pop();
				System.out.println(next.val);
				lastPoped = next;
			}
			else {
				if (next.right != null) {
					stack.push(next.right);
				}
				if (next.left != null) {
					stack.push(next.left);
				}
			}
		}
	}

	public void postOrder_recursive(TreeNode root) {
		if(root == null)
			return;

		postOrder_recursive(root.left);
		postOrder_recursive(root.right);
		System.out.println("Visiting Node (R) - "+root.val);
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
		PostOrder_Using_Stack postOrder = new PostOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = postOrder.constructTree(arr, 0);
		System.out.println("Recursive");
		postOrder.postOrder_recursive(root);
	}

	@Test
	public void test_iterative_1_stack() {
		PostOrder_Using_Stack postOrder = new PostOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,7,-1,-1,6,-1,-1,-1,-1,8};
		TreeNode root = postOrder.constructTree(arr, 0);
		System.out.println("Iterative 1 Stack");
		postOrder.postOrder_iterative_1_stack(root);
	}
	
	@Test
	public void test_iterative_2_stack() {
		PostOrder_Using_Stack postOrder = new PostOrder_Using_Stack();
		int[] arr = {1,2,3,4,5,-1,-1,-1,-1,6};
		TreeNode root = postOrder.constructTree(arr, 0);
		System.out.println("Iterative 2 Stack");
		postOrder.postOrder_iterative_2_stack(root);
	}
}
