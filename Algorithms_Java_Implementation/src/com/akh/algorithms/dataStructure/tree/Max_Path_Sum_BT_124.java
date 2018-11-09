package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Max_Path_Sum_BT_124 {

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
	
    public int maxPathSum_LC(TreeNode root) { 
    	int[] maxSum = {Integer.MIN_VALUE};
        helper(root, maxSum, 0);
        return maxSum[0];
    }
    
    // helper returns the max branch 
    // plus current node's value
    int helper(TreeNode root, int[] maxSum, int tabs) {
		if(root == null) {
			return 0;
		}

		System.out.println(getTabs(tabs)+"Entering with Node : "+root.val+" with maxSum = "+maxSum[0]);

		//If left branch is positive take it in OR 0
		int leftS = Math.max(0, helper(root.left, maxSum, tabs+1));
		print(tabs, root.val, "leftS", leftS);

		//If right branch is positive take it in OR 0
		int rightS = Math.max(0, helper(root.right, maxSum, tabs+1));
		print(tabs, root.val, "rightS", leftS);

		//If maxLeft + maxRight + root.val is the new MAX?
		maxSum[0] = Math.max(maxSum[0], leftS + root.val + rightS);
		print(tabs, root.val, "maxSum", maxSum[0]);

		//Return max for this node considering its children as well
		//Its upto parent to decide whether to consider or not consider this branch
		print(tabs, root.val, "Returning", Math.max(leftS, rightS) + root.val);
		return Math.max(leftS, rightS) + root.val;
    }
	
	private String getTabs(int count) {
		String tabs = "";
		while(count > 0) {
			tabs += "\t";
			count--;
		}
		return tabs;
	}
	
	private void print(int tabs, int rootVal, String msg, int sum) {
		System.out.println(getTabs(tabs)+"Node : "+rootVal+" "+msg+" ---> "+sum);
	}

	//*******************************  Test **********************************
	@Test
	public void test_DFS_LC_1() {
		int[] arr = {-10,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(42, maxPathSum_LC(root));
	}

	@Test
	public void test_DFS_LC_2() {
		int[] arr = {1,2,3};
		TreeNode root = constructTree(arr, 0);
		assertEquals(6, maxPathSum_LC(root));
	}

	@Test
	public void test_DFS_LC_3() {
		int[] arr = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		TreeNode root = constructTree(arr, 0);
		assertEquals(6, maxPathSum_LC(root));
	}
	
	@Test
	public void test_DFS_Post_1() {
		int[] arr = {-10,9,20,-1,-1,15,7};
		TreeNode root = constructTree(arr, 0);
		assertEquals(42, maxPathSum_DFS(root));
	}

	@Test
	public void test_DFS_Post_2() {
		int[] arr = {1,2,3};
		TreeNode root = constructTree(arr, 0);
		assertEquals(6, maxPathSum_DFS(root));
	}

	@Test
	public void test_DFS_Post_3() {
		int[] arr = {5,4,8,11,-1,13,4,7,2,-1,-1,-1,1};
		TreeNode root = constructTree(arr, 0);
		assertEquals(6, maxPathSum_DFS(root));
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
	
	//***************************** Convulted ********************************
	public int maxPathSum_DFS(TreeNode root) {
		if(root == null)
			return 0;
		int[] maxSum = {Integer.MIN_VALUE};
		maxPathSum_DFS(root, maxSum, 0);
		return maxSum[0];
	}

	public int maxPathSum_DFS(TreeNode root, int[] maxSum, int tabs) {
		if(root == null) {
			return 0;
		}

		System.out.println(getTabs(tabs)+"Entering with Node : "+root.val+" with maxSum = "+maxSum[0]);

		int leftSum = maxPathSum_DFS(root.left, maxSum, tabs+1);
		print(tabs, root.val, "LeftSum", leftSum);

		int rightSum = maxPathSum_DFS(root.right, maxSum, tabs+1);
		print(tabs, root.val, "RightSum", rightSum);

		int currSum = Math.max(root.val, Math.max(root.val+leftSum, root.val+rightSum));
		print(tabs, root.val, "Max(L,R)", currSum);

		currSum = Math.max(currSum, Math.max(root.val, leftSum + root.val + rightSum));
		print(tabs, root.val, "Max(root, Max(L,R))", currSum);

		maxSum[0] = Math.max(maxSum[0], currSum);
		print(tabs, root.val, "New maxSum", maxSum[0]);

		print(tabs, root.val, "Returning", currSum);
		return currSum;
	}
}
