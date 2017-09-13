/*
 *  BinarySearchTree_New.java
 *  Author: Akhash Ramamurthy
 *  Created on: Aug 11, 2017
 */

package com.akh.algorithms.dataStructure.tree.bst;

/**
 *  @fileName: BinarySearchTree_New.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 11, 2017
 */

public class BinarySearchTree_New {
	private BSTNode root = null;

	private class BSTNode {
		int data;
		BSTNode left, right, parent;
		public BSTNode(int d){
			this.data = d;
		}
	}

	public static void main(String[] args) {
		BinarySearchTree_New bst = new BinarySearchTree_New();
		int[] data = new int[]{23, 7, 203, 21, 12, 63, 71, 4, 2, 300, 350, 57, 22};
		for(int i : data){
			bst.insert(i);
		}
		BSTNode rootCopy = bst.root;
		bst.inOrder(rootCopy);
		bst.preOrder(rootCopy);

		System.out.println("isFound = "+(bst.search(75) != null));
		bst.delete(23);
		rootCopy = bst.root;
		bst.inOrder(rootCopy);
		bst.preOrder(rootCopy);
	}

	public void insert(int x){
		if(root == null){
			root = new BSTNode(x);
			return;
		}

		BSTNode curr = root;
		while(curr!=null && curr.data != x){
			if(x < curr.data){
				if(curr.left == null){
					//insert code
					curr.left = new BSTNode(x);
					curr.left.parent = curr;
				}else{
					curr = curr.left;
				}
			}else {
				if(curr.right == null){
					//insert code
					curr.right = new BSTNode(x);
					curr.right.parent = curr;
				}else{
					curr = curr.right;
				}
			}
		}
	}

	public boolean delete(int x){
		BSTNode toDelete = search(x);
		//Search Node
		if(toDelete == null){
			return false;
		}

		//Two Children Node
		if(toDelete.left != null && toDelete.right != null){
			BSTNode leftRoot = toDelete.left;
			BSTNode secondLargest = findLargestNode(leftRoot);
			toDelete.data = secondLargest.data;
			if(secondLargest.left != null){  //none is greater than secondLargest. so no right node
				secondLargest.parent.right = secondLargest.left;
				secondLargest.left.parent = secondLargest.parent;
			}
			if(secondLargest == secondLargest.parent.right){
				secondLargest.parent.right = null;
			}else{
				secondLargest.parent.left = null;
			}
		}else if(toDelete.left != null || toDelete.right != null){ //One node
			BSTNode child = (toDelete.left != null) ? toDelete.left : toDelete.right;
			if(toDelete == toDelete.parent.right){
				toDelete.parent.right = child;
			}else{
				toDelete.parent.left = child;
			}
		}else{ //leaf node
			if(toDelete == toDelete.parent.right){
				toDelete.parent.right = null;
			}else{
				toDelete.parent.left = null;
			}
		}
		return true;
	}

	public BSTNode search(int x){
		BSTNode curr = root;
		while(curr != null){
			if(curr.data == x)
				return curr;
			if(x < curr.data){
				curr = curr.left;
			}else{
				curr = curr.right;
			}
		}
		return null;
	}

	public BSTNode findLargestNode(BSTNode curr){
		while(curr.right != null){
			curr = curr.right;
		}
		return curr;
	}

	private void inOrder(BSTNode itr){
		if( itr == null ){
			return;
		}
		if(itr.left != null)
			inOrder(itr.left);
		System.out.println( " Inorder " + itr.data);
		if(itr.right != null )
			inOrder(itr.right);
	}

	private void preOrder(BSTNode itr){
		if( itr == null ){
			return;
		}
		System.out.println( " PreOrder : "+ itr.data);
		preOrder(itr.left);
		preOrder(itr.right);
	}

}
