package com.akh.algorithms.dataStructure.tree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.*;

import com.akh.algorithms.dataStructure.tree.CheckBinaryTreeIsSymmetric.TreeNode;

/**
 *  @fileName: TreeZigZagLevelOrder.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 12, 2018
 */

public class TreeZigZagLevelOrder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<List<Integer>> zigzagLevelOrder_2_Stack(TreeNode root) {
		if( root == null ){
			return new ArrayList<>(new ArrayList<>());
		}

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		List<Integer> levelList = null;

		s1.push(root);

		while(!s1.isEmpty() || !s2.isEmpty()){

			levelList = new ArrayList<>();
			output.add(levelList);
			while(!s1.isEmpty()){
				TreeNode currNode = s1.pop();
				levelList.add(currNode.val);
				if(currNode.left != null)
					s2.push(currNode.left);
				if(currNode.right != null)
					s2.push(currNode.right);
			}

			levelList = new ArrayList<>();
			output.add(levelList);
			while(!s2.isEmpty()){
				TreeNode currNode = s2.pop();
				levelList.add(currNode.val);
				if(currNode.right != null)
					s1.push(currNode.right);
				if(currNode.left != null)
					s1.push(currNode.left);
			}

		}
		return output;
	}
	
	public List<List<Integer>> zigzagLevelOrder_DFS(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		dfs_helper(root, result, 0);
		return result;
	}
	
	private void dfs_helper(TreeNode root, List<List<Integer>> result, int depth){
		if(root == null)
			return;
		
		if(result.size() <= depth){
			result.add(depth, new ArrayList<>());
		}
		List<Integer> levelList = result.get(depth);
		
		if(depth % 2 == 0){
			levelList.add(root.val);
		}else{
			levelList.add(0, root.val);
		}
		
		dfs_helper(root.left, result, depth+1);
		dfs_helper(root.right, result, depth+1);
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
	public void test_2_Stack_1(){
		TreeZigZagLevelOrder zigzagTree = new TreeZigZagLevelOrder();
		int[] arr = {1,2,3,4,-1,-1,5};
		TreeNode root = zigzagTree.constructTree(arr, 0);
		List<List<Integer>> actual = zigzagTree.zigzagLevelOrder_2_Stack(root);
		int[][] expected = {{3}, {20,9}, {15,7}};
		for(int i=0; i<expected.length; i++){
			for(int node : actual.get(i)){
				System.out.println("Level "+i+" ==> "+node);
			}
		}
	}
	
	@Test
	public void test_2_Stack_2(){
		TreeZigZagLevelOrder zigzagTree = new TreeZigZagLevelOrder();
		int[] arr = {1,2,3,4,5,6,7,8,-1,-1,-1,9,12,10,11};
		TreeNode root = zigzagTree.constructTree(arr, 0);
		List<List<Integer>> actual = zigzagTree.zigzagLevelOrder_2_Stack(root);
		int[][] expected = {{1}, {3,2}, {4,5,6,7}, {11,10,12,9,8}};
		for(int i=0; i<expected.length; i++){
			for(int node : actual.get(i)){
				System.out.println("Level "+i+" ==> "+node);
			}
		}
	}
	
	@Test
	public void test_DFS_1(){
		TreeZigZagLevelOrder zigzagTree = new TreeZigZagLevelOrder();
		int[] arr = {1,2,3,4,-1,-1,5};
		TreeNode root = zigzagTree.constructTree(arr, 0);
		List<List<Integer>> actual = zigzagTree.zigzagLevelOrder_DFS(root);
		int[][] expected = {{3}, {20,9}, {15,7}};
		for(int i=0; i<expected.length; i++){
			for(int node : actual.get(i)){
				System.out.println("Level "+i+" ==> "+node);
			}
		}
	}
	
	@Test
	public void test_DFS_2(){
		TreeZigZagLevelOrder zigzagTree = new TreeZigZagLevelOrder();
		int[] arr = {1,2,3,4,5,6,7,8,-1,-1,-1,9,12,10,11};
		TreeNode root = zigzagTree.constructTree(arr, 0);
		List<List<Integer>> actual = zigzagTree.zigzagLevelOrder_DFS(root);
		int[][] expected = {{1}, {3,2}, {4,5,6,7}, {11,10,12,9,8}};
		for(int i=0; i<expected.length; i++){
			for(int node : actual.get(i)){
				System.out.println("Level "+i+" ==> "+node);
			}
		}
	}
}
