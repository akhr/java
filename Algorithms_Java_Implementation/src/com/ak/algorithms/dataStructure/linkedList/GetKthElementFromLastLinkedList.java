package com.ak.algorithms.dataStructure.linkedList;

import java.util.Stack;

import com.ak.algorithms.dataStructure.linkedList.Node;

public class GetKthElementFromLastLinkedList {
	
	public static Node getKthElement(Node head, int k){
		Node n = head;
		Stack<Node> stack = new Stack<Node>();
		
		while( n != null){
			stack.push(n);
			n = n.next;
		}
		
		for(int i=0; i<k; i++){
			stack.pop();
		}
		
		return stack.pop();
	}

	
	public static void main(String[] args){
		SinglyLinkedList singlyLinkedList = MockDataGenerator.generateSingleLinkedList(10);
		System.out.println("Kth to the Last Element - "+getKthElement(singlyLinkedList.head, 9).data);

	}
}
