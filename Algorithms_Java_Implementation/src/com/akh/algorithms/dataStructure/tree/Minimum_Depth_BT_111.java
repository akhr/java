package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class Minimum_Depth_BT_111 {

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

	
	//*******************************  DFS Recursive Pre and Post **********************************
	public int minDepth_DFS_Recursive_Post(TreeNode root){
		//Post_order
		if(root == null)
			return 0;

		if(root.left == null && root.right == null)
			return 1;

		int min = Integer.MAX_VALUE;
		if(root.left != null)
			min = Math.min(min, minDepth_DFS_Recursive_Post(root.left));

		if(root.right != null)
			min = Math.min(min, minDepth_DFS_Recursive_Post(root.right));

		return min+1;
	}

	public int minDepth_DFS_Recursive_Pre(TreeNode root){
		int[] minDepth = {Integer.MAX_VALUE};
		minDepth_DFS_Recursive_Pre_Helper(root, 1, minDepth);
		return minDepth[0] == Integer.MAX_VALUE ? 0 : minDepth[0];
	}

	public void minDepth_DFS_Recursive_Pre_Helper(TreeNode root, int depth, int[] minDepth){
		if(root == null) {
			return;
		}

		if(root.left == null && root.right == null)
			minDepth[0] = Math.min(minDepth[0], depth);

		if(root.left != null)
			minDepth_DFS_Recursive_Pre_Helper(root.left, depth+1, minDepth);

		if(root.right != null)
			minDepth_DFS_Recursive_Pre_Helper(root.right, depth+1, minDepth);
	}
	
	

	//*******************************  DFS Iterative  **********************************
	public int minDepth_DFS_Iterative_1_Stack(TreeNode root) {
		if(root == null)
			return 0;

		Stack<TreeNode> nodeStack = new Stack<>();
		int depth = 1;
		int minDepth = Integer.MAX_VALUE;
		nodeStack.push(root);

		while(!nodeStack.isEmpty()) {
			TreeNode peeked = nodeStack.peek();
			
			if(peeked.left != null) { //Not a leaf
				nodeStack.push(peeked.left); 
			}
			
			if(peeked.right != null) { //Not a leaf
				nodeStack.push(peeked.right);
			}	
			
			if(peeked.left == null && peeked.right == null) { //leaf
				minDepth = Math.min(minDepth, depth);
				TreeNode poped = nodeStack.pop();
				while(poped != null && !nodeStack.isEmpty()) {
					peeked = nodeStack.peek();
					if(isParentChild(peeked, poped)) {
						depth--;
						poped = nodeStack.pop();
					}else {
						break;
					}
				} 
			}else { //Not a leaf
				depth++;
			}

		}
		return minDepth;
	}

	private boolean isParentChild(TreeNode parent, TreeNode child) {
		return (child == parent.left || child == parent.right);
	}

	public int minDepth_DFS_Iterative_2_Stack(TreeNode root) {
		if(root == null)
			return 0;

		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<Integer> depthStack = new Stack<>();
		int minDepth = Integer.MAX_VALUE;
		nodeStack.push(root);
		depthStack.push(1);

		while(!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			int depth = depthStack.pop();

			if(node.left == null && node.right == null)
				minDepth = Math.min(minDepth, depth);

			if(node.left != null) {
				nodeStack.push(node.left);
				depthStack.push(depth+1);
			}
			if(node.right != null) {
				nodeStack.push(node.right);
				depthStack.push(depth+1);
			}
		}
		return minDepth;
	}
	
	
	//*******************************  BFS **********************************
	public int minDepth_BFS(TreeNode root) {
		if(root == null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int minDepth = Integer.MAX_VALUE;
		int depth = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode curr = queue.poll();
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
				if(curr.left == null && curr.right == null) minDepth = Math.min(minDepth, depth); //Leaf
				size--;
			}
			depth++;
		}
		return minDepth;
	}
	


	//*******************************  Test **********************************
	@Test
	public void test_DFS_Post_1() {
		int[] arr = {3,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Recursive_Post(root));
	}

	@Test
	public void test_DFS_Post_2() {
		int[] arr = {1,2};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Recursive_Post(root));
	}

	@Test
	public void test_DFS_Pre_1() {
		int[] arr = {3,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Recursive_Pre(root));
	}

	@Test
	public void test_DFS_Pre_2() {
		int[] arr = {1,2};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Recursive_Pre(root));
	}


	@Test
	public void test_DFS_It_1Stack_1() {
		int[] arr = {3,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}

	@Test
	public void test_DFS_It_1Stack_2() {
		int[] arr = {1,2};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_DFS_It_1Stack_3() {
		int[] arr = {0};
		TreeNode root = constructTree(arr, 0);
		assertEquals(1, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_DFS_It_1Stack_4() {
		int[] arr = {1,2,3,4,5};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_DFS_It_2Stack_1() {
		int[] arr = {3,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}

	@Test
	public void test_DFS_It_2Stack_2() {
		int[] arr = {1,2};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_DFS_It_2Stack_3() {
		int[] arr = {0};
		TreeNode root = constructTree(arr, 0);
		assertEquals(1, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_DFS_It_2Stack_4() {
		int[] arr = {1,2,3,4,5};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}

	@Test
	public void test_BFS_1() {
		int[] arr = {3,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}

	@Test
	public void test_BFS_2() {
		int[] arr = {1,2};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_BFS_3() {
		int[] arr = {0};
		TreeNode root = constructTree(arr, 0);
		assertEquals(1, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	@Test
	public void test_BFS_4() {
		int[] arr = {1,2,3,4,5};
		TreeNode root = constructTree(arr, 0);
		assertEquals(2, minDepth_DFS_Iterative_1_Stack(root));
	}
	
	//*******************************  Tree Construction **********************************
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


}
