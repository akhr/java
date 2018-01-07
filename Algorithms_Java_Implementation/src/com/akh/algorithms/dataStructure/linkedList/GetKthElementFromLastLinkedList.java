package com.akh.algorithms.dataStructure.linkedList;

import java.util.Stack;

import com.akh.algorithms.dataStructure.linkedList.Node;

public class GetKthElementFromLastLinkedList {
	
	public static Node getKthElement(Node head, int k){
		Node n = head;
		Stack<Node> stack = new Stack<Node>();
		
		while( n != null){
			stack.push(n);
			n = n.next;
		}
		
		for(int i=1; i<k; i++){
			stack.pop();
		}
		
		return stack.pop();
	}
	
	public static Node getKthElement_UsingDoublePointer(Node head, int k){
		Node slow = head;
		Node fast = head;
		for(int i=1; i<=k; i++){
			fast = fast.next;
		}
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	
	public static void main(String[] args){
		SinglyLinkedList singlyLinkedList = MockDataGenerator.generateSingleLinkedList(10);
		System.out.println("Kth to the Last Element - "+getKthElement(singlyLinkedList.head, 4).data);
		System.out.println("Kth to the Last Element Double Pointer- "+getKthElement_UsingDoublePointer(singlyLinkedList.head, 4).data);

	}
}
