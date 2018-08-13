package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;
import com.akh.algorithms.dataStructure.tree.bst.ConstructBSTFromSortedArray;

/**
 *  @fileName: PrintTree.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class PrintTree {

	public static void printTree_BST(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		int nodeCount = 0;

		queue.add(root);

		while(true){

			nodeCount = queue.size();
			if(nodeCount == 0)
				break;

			while(nodeCount > 0){
				BinaryTreeNode<Integer> node = queue.poll();
				System.out.print(node.getData()+" ");
				nodeCount--;
				if(node.getLeft() != null)
					queue.add(node.getLeft());
				if(node.getRight() != null)
					queue.add(node.getRight());
			}
			System.out.print("\n");
		}
	}
	
	@Test
	public void test_print(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		printTree_BST(root);
	}
	
}
