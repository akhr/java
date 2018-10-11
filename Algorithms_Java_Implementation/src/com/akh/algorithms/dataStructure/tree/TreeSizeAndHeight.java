package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

import com.akh.algorithms.dataStructure.tree.bst.BinaryTreeNode;
import com.akh.algorithms.dataStructure.tree.bst.ConstructBSTFromSortedArray;

/**
 *  @fileName: TreeSizeAndHeight.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class TreeSizeAndHeight {
	
	//===================================  Tree Depth or Height ============================
	private static int maxDepth_DFS_PostOrder(BinaryTreeNode<Integer> root){
		if(root == null)
			return 0;
		int leftSubTreeHt = maxDepth_DFS_PostOrder(root.getLeft());
		int rightSubTreeHt = maxDepth_DFS_PostOrder(root.getRight());
		
		int maxSubTreeHt = Math.max(leftSubTreeHt, rightSubTreeHt);
		
		return maxSubTreeHt + 1;
	}
	
	private static int maxDepth_DFS_PreOrder(BinaryTreeNode<Integer> root) {
		int[] maxDepth = {Integer.MIN_VALUE};
		maxDepth_DFS_PreOrder(root, 0, maxDepth);
		return maxDepth[0];
	}
	
	private static void maxDepth_DFS_PreOrder(BinaryTreeNode<Integer> root, int depth, int[] maxDepth){
		if(root == null) {
			maxDepth[0] = Math.max(maxDepth[0], depth); 
			return;
		}
		maxDepth_DFS_PreOrder(root.getLeft(), depth+1, maxDepth);
		maxDepth_DFS_PreOrder(root.getRight(), depth+1, maxDepth);
	}
	
	private static int maxDepth_DFS_Iterative(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		
		Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<>();
		Stack<Integer> levelStack = new Stack<>();
		
		nodeStack.push(root);
		levelStack.push(1);
		
		int maxDepth = Integer.MIN_VALUE;
		
		while(!nodeStack.isEmpty()) {
			
			BinaryTreeNode<Integer> poped = nodeStack.pop();
			int depth = levelStack.pop();
			maxDepth = Math.max(maxDepth, depth);
			
			if(poped.getRight() != null){
				nodeStack.push(poped.getRight());
				levelStack.push(depth+1);
			}
			
			if(poped.getLeft() != null) {
				nodeStack.push(poped.getLeft());
				levelStack.push(depth+1);
			}
		}
 		return maxDepth;
	}
	
	private static int maxDepth_BFS(BinaryTreeNode<Integer> root) {
		if(root == null)
			return 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int neighborsCount = 0;
		int depth = 0;
		
		while(!queue.isEmpty()){
			neighborsCount = queue.size();
			
			while(neighborsCount > 0){
				BinaryTreeNode<Integer> curr = queue.poll();
				if(curr.getLeft() != null) queue.offer(curr.getLeft());
				if(curr.getRight() != null) queue.offer(curr.getRight());
				neighborsCount--;
			}
			depth++;
		}
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
		assertEquals("DFS Post Order", 4, maxDepth_DFS_PostOrder(root));
		assertEquals("DFS Pre Order", 4, maxDepth_DFS_PreOrder(root));
		assertEquals("DFS Iterative", 4, maxDepth_DFS_Iterative(root));
		assertEquals("BFS", 4, maxDepth_BFS(root));
	}
	
	@Test 
	public void checkDepth_2(){
		int[] arr = new int[]{1};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertEquals("DFS Post Order", 1, maxDepth_DFS_PostOrder(root));
		assertEquals("DFS Pre Order", 1, maxDepth_DFS_PreOrder(root));
		assertEquals("DFS Iterative", 1, maxDepth_DFS_Iterative(root));
		assertEquals("BFS", 1, maxDepth_BFS(root));
	}
	
	@Test 
	public void checkDepth_3(){
		int[] arr = new int[]{};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertEquals("DFS Post Order", 0, maxDepth_DFS_PostOrder(root));
		assertEquals("DFS Pre Order", 0, maxDepth_DFS_PreOrder(root));
		assertEquals("DFS Iterative", 0, maxDepth_DFS_Iterative(root));
		assertEquals("BFS", 0, maxDepth_BFS(root));
	}
	
	@Test 
	public void checkDepth_4(){
		int[] arr = new int[]{1,2,3,4};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertEquals("DFS Post Order", 3, maxDepth_DFS_PostOrder(root));
		assertEquals("DFS Pre Order", 3, maxDepth_DFS_PreOrder(root));
		assertEquals("DFS Iterative", 3, maxDepth_DFS_Iterative(root));
		assertEquals("BFS", 3, maxDepth_BFS(root));
	}

	
	@Test 
	public void checkTreeSize(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		int treeSize = getTreeSize(root);
		assertEquals(treeSize, 10);
	}
}
