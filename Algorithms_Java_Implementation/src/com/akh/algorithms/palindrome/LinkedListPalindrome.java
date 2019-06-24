package com.akh.algorithms.palindrome;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

/**
 *  @fileName: LinkedListPalindrome.java
 *  @author: Akhash Ramamurthy
 *  Created on: May 14, 2017
 */

public class LinkedListPalindrome {
	
	private Node<String> mHead;
	private int mSize = 0;

	public static void main(String[] args) {
		LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
/*		linkedListPalindrome.addNode(new Node<String>("m"));
		linkedListPalindrome.addNode(new Node<String>("a"));
		linkedListPalindrome.addNode(new Node<String>("l"));
		linkedListPalindrome.addNode(new Node<String>("a"));
		linkedListPalindrome.addNode(new Node<String>("y"));
		linkedListPalindrome.addNode(new Node<String>("a"));
		linkedListPalindrome.addNode(new Node<String>("l"));
		linkedListPalindrome.addNode(new Node<String>("a"));
		linkedListPalindrome.addNode(new Node<String>("m"));*/
		
		linkedListPalindrome.addNode(new Node<String>("a"));
		linkedListPalindrome.addNode(new Node<String>("m"));
		linkedListPalindrome.addNode(new Node<String>("m"));
		linkedListPalindrome.addNode(new Node<String>("a"));
		
		linkedListPalindrome.printNode();
		System.out.println("Is LinkedList Palindrome - "+linkedListPalindrome.isPalindrome());
	}
	
	private boolean isPalindrome(){
		if(mHead == null)
			return false;
		int size = getSize();
		if(size == 1){ //Only one char
			return true;
		}
		
		int leftStartIndex = 0;
		Node<String> leftCurrNode = mHead;
		Node<String> rightCurrNode = getRightStartNode(size);
		
		while(leftStartIndex < (size/2)){
			if(!leftCurrNode.data.equalsIgnoreCase(rightCurrNode.data))
				return false;
			leftStartIndex++;
			leftCurrNode = leftCurrNode.next;
			rightCurrNode = rightCurrNode.next;
		}
		return true;
	}
	
	private int getSize(){
		int size = 1;
		Node<String> curr = mHead;
		while(curr.next != null){
			size++;
			curr = curr.next;
		}
		System.out.println("Size of String = "+size);
		return size;
	}
	
	private int getRightStartIndex(int size){
		if ((size % 2) != 0){ 	//Odd case
			return (size/2)+1;
		}else{ 					//Even case
			return (size/2);
		}
	}
	
	private Node<String> getRightStartNode(int size){
		int rightStartIndex = getRightStartIndex(size);
		System.out.println("Right Start Index - "+rightStartIndex);
		
		Node<String> curr = mHead;
		int currIndex = 0;
		while(curr.next != null && currIndex<rightStartIndex){
			curr = curr.next;
			currIndex++;
		}
		System.out.println("Right Start Node - "+curr.data);
		return curr;
	}

	private void addNode(Node<String> nd){
		Node<String> itr = mHead;
		if( mHead == null){
			this.mHead = nd;
			return;
		}
		while(itr != null && itr.next != null){
			itr = itr.next;
		}
		itr.next = nd;
		mSize++;
	}

	private void printNode(){
		Node next = mHead;
		while(next!= null){
			System.out.println( next.data);
			next = next.next;
		}
	}

	public static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
		}
	}

}
