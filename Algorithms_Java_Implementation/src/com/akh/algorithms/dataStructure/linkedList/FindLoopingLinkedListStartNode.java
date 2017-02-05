package com.akh.algorithms.dataStructure.linkedList;

import java.util.HashMap;
import java.util.Map;

public class FindLoopingLinkedListStartNode {

	public static void main(String[] args){
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.add(10);
		singlyLinkedList.add(20);
		singlyLinkedList.add(30);
		singlyLinkedList.add(40);
		singlyLinkedList.add(50);
		singlyLinkedList.add(60);
		Node starterNode = singlyLinkedList.tail;
		singlyLinkedList.add(70);
		singlyLinkedList.add(80);
		singlyLinkedList.tail.next = starterNode;
		System.out.println("Loop Starter : "+getLoopStarter(singlyLinkedList.head).data);
		System.out.println("Loop Starter 2 : "+detectAndRemoveLoop(singlyLinkedList.head).data);
	}

	public static Node getLoopStarter(Node head){
		Map<Node, Boolean> map = new HashMap<Node, Boolean>();
		Node n = head;
		while(n != null){
			if(!map.containsKey(n)){
				map.put(n,true);
			}else{
				return n;
			}
			n = n.next;
		}
		return null;
	}

	// Implementation using no extra space. Floyd's cycle detect algorithm, also called the tortoise and hare algorithm
	// http://stackoverflow.com/questions/5607292/interview-remove-loop-in-linked-list-java

	public static Node detectAndRemoveLoop(Node head){
		if(head == null)
			return head;

		Node slow = head;
		Node fast = head;
		
		// Consider list length = n
		while(slow.next != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
				// Now slow is within the loop at a position n - k
				// i.e., k items away from the start of the loop
			}
		}
		
		// To find the start of loop reset fast to head
		// Move fast at the same pace as slow
		// After k steps they will meet at the same point. Thats the starting point of the loop.
		fast = head;
		Node cycleStart = null;
		while(slow.next != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
			if(slow == fast){
				// Store the starting point of the loop
				cycleStart = slow;
				break;
			}
		}
		
		// Next step is to find the node point to this starting point of the loop and reset to NULL
		while(fast.next != null){
			if(fast.next == cycleStart){
				fast.next = null;
			}else{
				fast = fast.next;
			}
		}
		return slow;
	}
}
