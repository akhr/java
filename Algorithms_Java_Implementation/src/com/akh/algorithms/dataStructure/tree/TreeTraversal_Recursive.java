package com.akh.algorithms.dataStructure.tree;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;

/**
 *  @fileName: TreeTraversal.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class TreeTraversal_Recursive {
	
	public static void preOrder(BinaryTreeNode<Integer> currNode){
		//root,left,right
		if(currNode == null)
			return;
		visitNode(currNode);
		preOrder(currNode.getLeft());
		preOrder(currNode.getRight());
	}
	public static void inOrder(BinaryTreeNode<Integer> currNode){
		//left,root,right
		if(currNode == null)
			return;
		inOrder(currNode.getLeft());
		visitNode(currNode);
		inOrder(currNode.getRight());
	}
	public static void postOrder(BinaryTreeNode<Integer> currNode){
		//left,right,root
		if(currNode == null)
			return;
		postOrder(currNode.getLeft());
		postOrder(currNode.getRight());
		visitNode(currNode);
	}

	private static void visitNode(BinaryTreeNode<Integer> node){
		System.out.println(node.getData());
	}
}
