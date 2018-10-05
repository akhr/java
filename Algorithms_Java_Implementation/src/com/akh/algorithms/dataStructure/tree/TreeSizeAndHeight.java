package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;
import com.akh.algorithms.dataStructure.tree.bst.ConstructBSTFromSortedArray;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

/**
 *  @fileName: TreeSizeAndHeight.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class TreeSizeAndHeight {
	
	//===================================  Tree Depth or Height ============================
	private static int maxDepth_DFS_Bottom_Up(BinaryTreeNode<Integer> root){
		if(root == null)
			return 0;
		int leftSubTreeHt = maxDepth_DFS_Bottom_Up(root.getLeft());
		int rightSubTreeHt = maxDepth_DFS_Bottom_Up(root.getRight());
		
		int maxSubTreeHt = Math.max(leftSubTreeHt, rightSubTreeHt);
		
		return maxSubTreeHt + 1;
	}
	
	private static int maxDepth_DFS_Top_Down(BinaryTreeNode<Integer> root) {
		int[] maxDepth = {Integer.MIN_VALUE};
		maxDepth_DFS_Top_Down(root, 0, maxDepth);
		return maxDepth[0];
	}
	
	private static void maxDepth_DFS_Top_Down(BinaryTreeNode<Integer> root, int depth, int[] maxDepth){
		if(root == null) {
			maxDepth[0] = Math.max(maxDepth[0], depth); 
			return;
		}
		maxDepth_DFS_Top_Down(root.getLeft(), depth+1, maxDepth);
		maxDepth_DFS_Top_Down(root.getRight(), depth+1, maxDepth);
	}
	
	/*private static int maxDepth_DFS_Iterative(BinaryTreeNode<Integer> root) {
		return maxDepth_DFS_Iterative(root, 1);
	}*/
	
	private static int maxDepth_DFS_Iterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		int maxDepth = Integer.MIN_VALUE;
		int depth = 1;
		
		while(!stack.isEmpty()) {
			maxDepth = Math.max(maxDepth, depth);
			BinaryTreeNode<Integer> node = stack.pop();
			
			if(node.getLeft() != null) stack.push(node.getLeft());
			if(node.getRight() != null) stack.push(node.getRight());
			if(node.getLeft() != null || node.getRight() != null) depth++;
		}
 		return maxDepth;
	}

	private static int getTreeHeight(BinaryTreeNode<Integer> root){
		int treeSize = getTreeSize(root);
		if(treeSize <= 0)
			return 0;
		if(treeSize == 1)
			return 1;
		int depth = (int)Math.ceil((Math.log(treeSize) / Math.log(2)));
		return depth;
	}
	
	//===================================  Tree Size #No of Nodes in a Tree ============================
	private static int getTreeSize(BinaryTreeNode<Integer> root){
		if (root == null)
			return 0;
		return getTreeSize(root.getLeft()) + 1 + getTreeSize(root.getRight());
	}
	
	
	
	//===================================  Test ============================
	@Test 
	public void checkDepth_1(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		
//		assertEquals("Log Approach", 4, getTreeHeight(root));
//		assertEquals("Bottom Up Approach", 4, maxDepth_DFS_Bottom_Up(root));
//		assertEquals("Top Down Approach", 4, maxDepth_DFS_Top_Down(root));
		assertEquals("Iterative Approach", 4, maxDepth_DFS_Iterative(root));
	}
	
	@Test 
	public void checkDepth_2(){
		int[] arr = new int[]{1};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertEquals("Log Approach", 1, getTreeHeight(root));
		assertEquals("Bottom Up Approach", 1, maxDepth_DFS_Bottom_Up(root));
		assertEquals("Top Down Approach", 1, maxDepth_DFS_Top_Down(root));
	}
	
	@Test 
	public void checkDepth_3(){
		int[] arr = new int[]{};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertEquals("Log Approach", 0, getTreeHeight(root));
		assertEquals("Bottom Up Approach", 0, maxDepth_DFS_Bottom_Up(root));
		assertEquals("Top Down Approach", 0, maxDepth_DFS_Top_Down(root));
	}

	
	@Test 
	public void checkTreeSize(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		int treeSize = getTreeSize(root);
		assertEquals(treeSize, 10);
	}
}
