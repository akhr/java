package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 *  @fileName: CheckBinaryTreeIsSymmetric.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 8, 2018
 *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

public class CheckBinaryTreeIsSymmetric {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}

	/**
	 * My algorithm
	 * 1. Using BFS
	 * 2. Uses a Queue
	 * 3. Collects items in each level in a array from left to right
	 * 4. Then checks if the count is even and if yes, then checks if the list is a palindrome
	 * 5. 				1
	 *		 	2				2
	 *		3		4		4		3
	 * 6. Level 3 list shd be --> [3,4,4,3] --> Count is even and isPalindrome. 
	 */
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean isRoot = true;

		while(!q.isEmpty()) {
			int count = q.size();
			TreeNode[] itemsAtLevel = new TreeNode[count];
			int levelItemsIndex = 0;

			while(count > 0) {
				TreeNode item = q.poll();
				count--;
				itemsAtLevel[levelItemsIndex++] = item;
				if(item != null) {
					q.add(item.left);
					q.add(item.right);
				}
			}

			//Check if the arrar is symmetrical
			if(!isRoot && !isSymmetric(itemsAtLevel))
				return false;

			isRoot = false;
		}
		return true;
	}

	public boolean isSymmetric(TreeNode[] items) {
		int len = items.length;
		if((len % 2) != 0) {
			return false;
		}

		int left = 0;
		int right = len-1;

		while(left < right) {
			if(items[left] == null && items[right] == null){
				left++;
				right--;
			}else if((items[left] == null || items[right] == null)) {
				return items[left] == items[right];
			}else if(items[left].val != items[right].val){
				return false;
			}else {
				left++;
				right--;
			}
		}
		return true;
	}

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

	@Test
	public void test_1() {
		CheckBinaryTreeIsSymmetric check = new CheckBinaryTreeIsSymmetric();
		int[] arr = {1,2,2,3,4,4,3};
		TreeNode root = check.constructTree(arr, 0);
		assertEquals(true, check.isSymmetric(root));
	}
	
	@Test
	public void test_2() {
		CheckBinaryTreeIsSymmetric check = new CheckBinaryTreeIsSymmetric();
		int[] arr = {1,2,2, -1 ,3, -1 ,3};
		TreeNode root = check.constructTree(arr, 0);
		assertEquals(false, check.isSymmetric(root));
	}
	
	@Test
	public void test_3() {
		CheckBinaryTreeIsSymmetric check = new CheckBinaryTreeIsSymmetric();
		int[] arr = {3,1,1,0,2,2,0,3,-1,-1,4,4,-1,-1,3};
		TreeNode root = check.constructTree(arr, 0);
		assertEquals(true, check.isSymmetric(root));
	}
	
	@Test
	public void test_4() {
		CheckBinaryTreeIsSymmetric check = new CheckBinaryTreeIsSymmetric();
		int[] arr = {3,1,1,0,2,2,0,3,-1,-1,4,3,-1,-1,4};
		TreeNode root = check.constructTree(arr, 0);
		assertEquals(false, check.isSymmetric(root));
	}
}
