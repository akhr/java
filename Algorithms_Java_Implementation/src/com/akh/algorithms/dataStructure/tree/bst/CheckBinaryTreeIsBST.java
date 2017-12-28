package com.akh.algorithms.dataStructure.tree.bst;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *  @fileName: CheckBinaryTreeIsBST.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 29, 2017
 */

public class CheckBinaryTreeIsBST {
	
	static Integer lastPrinted;
	public static boolean isBST_UsingInOrder(BinaryTreeNode<Integer> currNode){
		if(currNode == null)
			return true;
		
		if(!isBST_UsingInOrder(currNode.getLeft())){
			return false;
		}
		
		if(lastPrinted != null && currNode.getData() <= lastPrinted){
			return false;
		}
		
		if(!isBST_UsingInOrder(currNode.getLeft())){
			return false;
		}
		return true;
	}
	
	public static boolean isBST_UsingBSTCharacteristics(BinaryTreeNode<Integer> currNode, Integer min, Integer max){
		if(currNode == null)
			return true;
		
//		if((min != null && ) )
		return false;
	}
	
	@Test
	public void testIsBinaryTreeIsBST_1(){
		int[] arr = new int[]{1, 5, 7, 12, 14, 27, 33, 64, 78, 90, 200, 201, 220, 230, 240, 250};
		BinaryTreeNode<Integer> root = ConstructBSTFromSortedArray.constructBST(arr, 0, arr.length-1);
		assertTrue(isBST_UsingInOrder(root));
	}

}

