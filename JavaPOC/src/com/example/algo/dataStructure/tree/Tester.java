package com.example.algo.dataStructure.tree;

import com.example.algo.dataStructure.tree.BinaryTree.Node;


public class Tester {

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		BinaryTreeSearch mBST = new BinaryTreeSearch();
		mBST.insert(7, 7);
		mBST.add(3, 3);
		mBST.add(11, 11);
		mBST.add(1, 1);
		mBST.add(5, 5);
		mBST.add(10, 10);
		mBST.add(15, 15);
		mBST.add(4, 4);
		
		int searchItem = 15;
		Node searched = mBST.search(searchItem);
		if(searched !=null)
			System.out.println("mBST.search() found "+searched.key);
		else
			System.out.println("Search Item "+searchItem+" not found");

	}*/
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(8);
		binaryTree.insert(binaryTree.new Node(9));
		binaryTree.insert(binaryTree.new Node(5));
		binaryTree.insert(binaryTree.new Node(7));
		binaryTree.insert(binaryTree.new Node(1));
		binaryTree.insert(binaryTree.new Node(12));
		binaryTree.insert(binaryTree.new Node(2));
		binaryTree.insert(binaryTree.new Node(4));
		binaryTree.insert(binaryTree.new Node(11));
		binaryTree.insert(binaryTree.new Node(3));
		binaryTree.insert(binaryTree.new Node(6));
		
		binaryTree.inOrder();
	}

}
