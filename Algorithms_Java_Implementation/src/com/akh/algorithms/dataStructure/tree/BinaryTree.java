package com.akh.algorithms.dataStructure.tree;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	private Node mRoot;

	public BinaryTree(Node root) {
		this.mRoot = root;
	}

	public BinaryTree(int rootData){
		this.mRoot = new Node(rootData);
	}

	public boolean insert(Node insertNode){
		if(this.mRoot == null){
			this.mRoot = insertNode;
			return true;
		}else if(this.mRoot.getData() == insertNode.getData()){
			return true;
		}else{
			return insert(mRoot, insertNode);
		}

	}

	public void delete(Node node){

	}

	public void search(Node node){

	}

	public int getNodeLevel(Node node){
		return 0;
	}

	
	//BFS - Queue
	private boolean insert(Node root, Node insertNode){

		Queue<Node> processingOrderQueue = new LinkedList<BinaryTree.Node>();
		processingOrderQueue.add(root);

		while(!processingOrderQueue.isEmpty()){
			Node currNode = processingOrderQueue.remove();
			if(currNode != null){
				if(currNode.getData() == insertNode.getData()){
					return true;
				}else if(insertNode.getData() < currNode.getData()){
					Node leftNode = currNode.getLeft();
					if(leftNode == null){
						currNode.setLeft(insertNode);
						return true;
					}else if(leftNode.getData() == insertNode.getData()){
						return true;
					}else{
						processingOrderQueue.add(leftNode);
					}
				}else if(insertNode.getData() > currNode.getData()){
					Node rightNode = currNode.getRight();
					if(rightNode == null){
						currNode.setRight(insertNode);
						return true;
					}else if(rightNode.getData() == insertNode.getData()){
						return true;
					}else{
						processingOrderQueue.add(rightNode);
					}
				}
			}
		}
		return false;
	}
	
	public void preOrder(){
		preOrder(mRoot);
	}

	public void inOrder(){
		inOrder(mRoot);
	}
	
	public void postOrder(){
		postOrder(mRoot);
	}
	private void preOrder(Node root){
		
		if(root != null){
			System.out.println(root.getData()+"\n");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	private void inOrder(Node root){
		
		if(root != null){
			preOrder(root.getLeft());
			System.out.println(root.getData()+"\n");
			preOrder(root.getRight());
		}
	}
	
	private void postOrder(Node root){
		
		if(root != null){
			preOrder(root.getLeft());
			preOrder(root.getRight());
			System.out.println(root.getData()+"\n");
		}
	}
	
	class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getData() {
			return data;
		}

	}

}
