package com.ak.algorithms.dataStructure.tree.bst;

/**
 * @author Akhash
 *
 */

public class BinaryTreeNode<T extends Comparable<T>> {
	
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data) {
		this.data = data;
	}
	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof BinaryTreeNode<?>)){
			return false;
		}
		
		if(this.data.equals(((BinaryTreeNode<T>)other).data))
			return true;
		else
			return false;
	}

}
