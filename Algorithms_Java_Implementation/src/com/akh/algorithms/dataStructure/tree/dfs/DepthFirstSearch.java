package com.akh.algorithms.dataStructure.tree.dfs;

import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.*;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;
import com.akh.algorithms.dataStructure.tree.bst.ConstructBSTFromSortedArray;

/**
 *  @fileName: DepthFirstSearch.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class DepthFirstSearch {
	
	//Clue : Micron SD card - Stack & Depth First Search

	private static boolean doDFS(BinaryTreeNode<Integer> currNode, int searchVal){
		if(currNode == null)
			return false;

		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.push(currNode);

		while(!stack.isEmpty()){
			BinaryTreeNode<Integer> node = stack.pop();
			if(searchNode(node, searchVal)){
				System.out.println("Found the node - "+node.getData());
				return true;
			}
			System.out.println("Visited node - "+node.getData());
			if(node.getLeft() != null)
				stack.push(node.getLeft());
			if(node.getRight() != null)
				stack.push(node.getRight());
		}
		return false;
	}

	private static boolean searchNode(BinaryTreeNode<Integer> node, int searchVal){
		if(node.getData() == searchVal)
			return true;
		return false;
	}

	@Test
	public void test_DFS(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertTrue(doDFS(root, 12));
		assertFalse(doDFS(root, 33));
	}
}
