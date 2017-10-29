package com.akh.algorithms.dataStructure.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;
import org.junit.Test;



/**
 *  @fileName: CreateLevelLinkedList.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 22, 2017
 */

public class CreateLevelLinkedList {

	public List<LinkedList<BinaryTreeNode<Integer>>> getLevelLinkedList(BinaryTreeNode<Integer> root){

		List<LinkedList<BinaryTreeNode<Integer>>> resultList = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();
		createLevelLinkedList_1(root, resultList, 0);
		return resultList;
	}


	/******* Differentiating levels using PRE ORDER TRAVERSAL which in turn is DFS *******/
	private void createLevelLinkedList_1(BinaryTreeNode<Integer> currNode, 
			List<LinkedList<BinaryTreeNode<Integer>>> resultList, 
			int level){

		if(currNode == null){
			return;
		}

		LinkedList<BinaryTreeNode<Integer>> levelList;

		//Check if the linkedList is already created for the level
		//		if(resultList.get(level) == null){ //Cant use this coz ArrayOutOfBoundException everytime when looking to add a new level.
		if(resultList.size() == level){	
			levelList = new LinkedList<BinaryTreeNode<Integer>>();
			resultList.add(levelList);
		}else{
			levelList = resultList.get(level);
		}

		/******* PRE ORDER TRAVERSAL *******/
		//Add the current node to the level linkedList
		levelList.add(currNode);
		//Goto left child
		createLevelLinkedList_1(currNode.getLeft(), resultList, level+1);
		//Goto right child
		createLevelLinkedList_1(currNode.getRight(), resultList, level+1);
	}

	/******* Differentiating levels using BFS - Two WHILE LOOPS*******/
	private void createLevelLinkedList_2(BinaryTreeNode<Integer> currNode, List<LinkedList<BinaryTreeNode<Integer>>> resultList){
		if(currNode == null)
			return;

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(currNode);

		int nodeCount = 0;
		while(true){
			nodeCount = q.size();
			if(nodeCount == 0)
				return;

			LinkedList<BinaryTreeNode<Integer>> levelList = new LinkedList<BinaryTreeNode<Integer>>();
			while(nodeCount > 0){
				BinaryTreeNode<Integer> node = q.poll();
				levelList.add(node);
				nodeCount--;
				if(node.getLeft() != null)
					q.add(node.getLeft());
				if(node.getRight() != null)
					q.add(node.getRight());
			}
			resultList.add(levelList);
		}
	}
	
	/******* Differentiating levels using BFS - One WHILE and One FOR LOOP*******/
	private void createLevelLinkedList_3(BinaryTreeNode<Integer> currNode, List<LinkedList<BinaryTreeNode<Integer>>> resultList){
		if(currNode == null)
			return;

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
		q.add(currNode);
		
		LinkedList<BinaryTreeNode<Integer>> levelList = new LinkedList<BinaryTreeNode<Integer>>();
		levelList.add(currNode);
		
		while(levelList.size() > 0){
			resultList.add(levelList);
			LinkedList<BinaryTreeNode<Integer>> parentList = levelList;
			levelList = new LinkedList<BinaryTreeNode<Integer>>();
			
			for(BinaryTreeNode<Integer> child : parentList){
				if(child.getLeft() != null)
					levelList.add(child.getLeft());
				if(child.getRight() != null)
					levelList.add(child.getRight());
			}
		}
	}
	
	
	
	/**============================   TEST  ============================**/ 
	@Test
	public void check_Method_1(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		List<LinkedList<BinaryTreeNode<Integer>>> resultList = new ArrayList();
		createLevelLinkedList_1(root, resultList, 0);
		int nodeCount = 0;
		for(LinkedList<BinaryTreeNode<Integer>> levelList : resultList){
			nodeCount += levelList.size();
		}
		assertEquals(10, nodeCount);
	}

	@Test
	public void check_Method_2(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		List<LinkedList<BinaryTreeNode<Integer>>> resultList = new ArrayList();
		createLevelLinkedList_2(root, resultList);
		int nodeCount = 0;
		for(LinkedList<BinaryTreeNode<Integer>> levelList : resultList){
			nodeCount += levelList.size();
		}
		assertEquals(10, nodeCount);
	}
	
	@Test
	public void check_Method_3(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		List<LinkedList<BinaryTreeNode<Integer>>> resultList = new ArrayList();
		createLevelLinkedList_2(root, resultList);
		int nodeCount = 0;
		for(LinkedList<BinaryTreeNode<Integer>> levelList : resultList){
			nodeCount += levelList.size();
		}
		assertEquals(10, nodeCount);
	}

}
