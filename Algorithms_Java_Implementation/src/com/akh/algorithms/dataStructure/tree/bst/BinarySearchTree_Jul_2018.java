package com.akh.algorithms.dataStructure.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  @fileName: BinarySearchTree_Revisit.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 8, 2018
 */

public class BinarySearchTree_Jul_2018<E extends Comparable<E>>{

	private BSTNode<E> mRoot;

	public BinarySearchTree_Jul_2018(){
		System.out.println("Constructor");
	}

	public BSTNode<E> getRoot(){
		return this.mRoot;
	}

	public static class BSTNode<E>{
		E mData;
		BSTNode<E> left;
		BSTNode<E> right;
		BSTNode<E> parent;

		public BSTNode(E data){
			this.mData = data;
		}

		public E getData(){
			return this.mData;
		}
	}

	public void insert(E item){
		BSTNode<E> node = new BSTNode<E>(item);
		if(mRoot == null)
			this.mRoot = node;
		else
			insert(node, mRoot);
	}

	private void insert(BSTNode<E> node, BSTNode<E> parent){
		//Check if item already exist
		if(parent.getData() == node.getData())
			return;

		//Check if item belongs to left tree
		if(node.getData().compareTo(parent.getData()) < 0){
			if(parent.left == null){
				parent.left = node;
				node.parent = parent;
			}else
				insert(node, parent.left);
		}else{
			if(parent.right == null){
				parent.right = node;
				node.parent = parent;
			}else
				insert(node, parent.right);
		}
		System.out.println("Inserted Node "+node.getData()+" into tree");
	}

	public BSTNode<E> search(E item){
		return search(item, mRoot);
	}

	private BSTNode<E> search(E item, BSTNode<E> parent){
		//Check of parent is null
		if(parent == null)
			return null;
		else if(item.compareTo(parent.getData()) == 0)
			return parent;
		else if(item.compareTo(parent.getData()) < 0){
			return search(item, parent.left);
		}else{
			return search(item, parent.right);
		}
	}


	/**
	 * Three Cases:
	 * 	Case 1: Node has two children 
	 * 	Case 2: Node has only one child
	 * 	Case 3: Node to removed is a leaf
	 */
	public void remove(E item){
		if(item == null){
			return;
		}
		System.out.println("Remove node - "+item.toString()+" from tree");

		BSTNode<E> toDelete = search(item);
		if(toDelete == null){	
			return ;
		}  

		if(toDelete.left != null && toDelete.right != null){ 			//Case 1: Node has two children
			// Replace with largest child from left subtree
			// 1.Since from left all nodes to right of toDelete ==> greater (BST rule) than replacement
			// 2.Largest of left subtree ==> remaining left subTree (once this node is replaced) smaller than replacement 
			BSTNode<E> largestChild = getLargestChild(toDelete.left);
			toDelete.mData = largestChild.mData;

			if(largestChild.parent.left == largestChild){ //Replacement directly connected toDelete
				largestChild.parent.left = null;
			}else if(largestChild.left != null){ //Replacement has a left child
				largestChild.parent.right = largestChild.left;
			}else{ //Replacement has no children
				largestChild.parent.right = null;
			}


			// OR 

			// Replace with smallest child from right subtree
			// 1.Since from right all nodes to left of toDelete ==> smaller (BST rule) than replacement
			// 2.Smallest of right subtree ==> remaining right subTree (once this node is replaced) larger than replacement 
			/*BSTNode<E> smallestChild = getSmallestChild(toDelete.right);
			toDelete.mData = smallestChild.mData;
			smallestChild.parent.left = null;*/

		} else if(toDelete.left == null || toDelete.right == null){		//Case 2: Node has only one child 
			BSTNode<E> replacement = toDelete.left != null ? toDelete.left : toDelete.right;
			if(toDelete.parent.left == toDelete)
				toDelete.parent.left = replacement;
			else if(toDelete.parent.right == toDelete)
				toDelete.parent.right = replacement;
		} else { 														//Case 3: Node to removed is a leaf
			if(toDelete.parent.left == toDelete)
				toDelete.parent.left = null;
			else if(toDelete.parent.right == toDelete)
				toDelete.parent.right = null;
		}
	}

	public void printTree(){
		System.out.println("Printing Tree ... ");
		if(getRoot() == null){
			System.out.println("Tree is empty");
			return;
		}

		Queue<BSTNode<E>> nodes = new LinkedList<BinarySearchTree_Jul_2018.BSTNode<E>>();
		int nodeCount = 0;
		nodes.add(getRoot());

		while(true){
			nodeCount = nodes.size();
			if(nodeCount == 0)
				break;

			while(nodeCount > 0){
				BSTNode<E> node = nodes.poll();
				nodeCount--;
				System.out.print(((MyData)node.getData()).value+"\t");
				if(node.left != null)
					nodes.add(node.left);
				if(node.right != null)
					nodes.add(node.right);
			}
			System.out.print("\n");
		}
	}

	private BSTNode<E> getLargestChild(BSTNode<E> current){
		while(current.right != null){
			current = current.right;
		}
		return current;
	}

	private BSTNode<E> getSmallestChild(BSTNode<E> current){
		while(current.left != null){
			current = current.left;
		}
		return current;
	}

	static class MyData implements Comparable<MyData>{
		int value = 0;

		public MyData(int val) {
			this.value = val;
		}

		@Override
		public int compareTo(MyData o) {
			int result;
			if(this.value == o.value){
				result = 0;
			}else if(this.value < o.value){
				result = -1;
			}else{
				result = 1;
			}
			//System.out.println("Comparison returned : "+result+" for this.v = "+this.value+" & o.value="+o.value);
			return result;
		}
		
		public String toString(){
			return String.valueOf(value);
		}
	}

	
	
	//####################################################################################################################################################################

	public static void main(String[] args){
		BinarySearchTree_Jul_2018<MyData> bst = new BinarySearchTree_Jul_2018<MyData>();
		MyData searchNode = null;
		
		System.out.println("Inserting into BST");
		int[] rands = new int[]{8,4,7,13,1,6,15,3,10,5,9,11,14,18};
		for(int i=0; i<rands.length; i++){
			MyData dataModel = new MyData(rands[i]);
			bst.insert(dataModel);
			if(i==7)
				searchNode = dataModel;
		}
		System.out.println("Bst root - "+bst.mRoot.getData().value);
		System.out.println("Search Result for "+searchNode+" = "+(bst.search(searchNode) != null));
		bst.printTree();
		bst.remove(new MyData(8));
		bst.printTree();
	}
	
}
