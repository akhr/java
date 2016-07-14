/**
 * 
 */
package com.ak.algorithms.dataStructure.tree.bst;

/**
 * @author Akhash
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BinaryTreeNode<T> root;
	private int treeSize;
	
	public BinarySearchTree() {
		
	}

	BinarySearchTree(T data){
		root = new BinaryTreeNode<T>(data);
	}

	public boolean insert(T data){
		if(data == null)
			return false;

		BinaryTreeNode<T> node = new BinaryTreeNode<T>(data);
		return insert(node);
	}

	public boolean insert(BinaryTreeNode<T> node){
		return insert(root, node);
	}

	public boolean insert(BinaryTreeNode<T> root, BinaryTreeNode<T> node){
		if(node == null)
			return false;

		if(root == null){
			this.root = node;
			treeSize++;
			return true;
		}

		int compareResult = root.getData().compareTo(node.getData());

		if(compareResult == 0){
			//This node has same value as root. No need to add the new node
			return true;
		}else if(compareResult > 0){
			if(root.getLeft() == null){
				root.setLeft(node);
				treeSize++;
				return true;
			}else
				return insert(root.getLeft(), node);
		}else{
			if(root.getRight() == null){
				root.setRight(node);
				treeSize++;
				return true;
			}else	
				return insert(root.getRight(), node);
		}
	}
	
	public boolean search(T searchValue){
		return search(this.root, searchValue);
	}
	
	public boolean search(BinaryTreeNode<T> root, T searchValue){
		if(root == null || searchValue == null)
			return false;
		
		int compareResult = root.getData().compareTo(searchValue);
		
		if(compareResult == 0)
			return true;
		else if(compareResult > 0)
			return search(root.getLeft(), searchValue);
		else
			return search(root.getRight(), searchValue);
	}
}
