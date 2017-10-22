package com.akh.algorithms.dataStructure.tree.dfs;

import java.util.Stack;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;

public class FindDeepestNode<T extends Comparable<T>> {

	public void getDeepestNode(BinaryTreeNode<T> currNode) {
		getDeepestNodeUsingDFS(currNode);
	}

	public static <T extends Comparable<T>> BinaryTreeNode<T> getDeepestNodeUsingDFS(BinaryTreeNode<T> currNode) {
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		stack.push(currNode);
		while (!stack.isEmpty()) {
			BinaryTreeNode<T> node = stack.pop();
			System.out.println(node.getData());
			if (node.getLeft() != null)
				stack.push(node.getLeft());
			if (node.getRight() != null)
				stack.push(node.getRight());
			if (node.getLeft() == null && node.getRight() == null) {
				System.out.println("Deepest Node = " + node.getData());
				return node;
			}
		}
		return null;
	}

}
