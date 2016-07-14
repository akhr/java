package com.ak.algorithms.dataStructure.linkedList;

import com.ak.algorithms.dataStructure.linkedList.Node;

public class LinkedListRemoveDuplicates {

	
	/**
	 * 1. The simplest way would to find remove dulicated wud to load the linkedList contents into
	 * a HashMap<ListObject, Count>. If any count>1 then delete that node and proceed.
	 * Time: O(n) & Space : O(n)  
	 * 
	 * 2. Find duplicates without using extra data buffer. Impl below..
	 * 
	 */
	public static void removeDups(SinglyLinkedList linkedList){
		Node n = linkedList.head;
		while(n != null){
			Node prev = n;
			Node nextNode = n.next;
			while(nextNode != null){
				if(n.data == nextNode.data){
					prev.next = nextNode.next;
				}else{
					prev = nextNode;
				}
				nextNode = nextNode.next;
			}
			n = n.next;
		}

	}
	
	public static void main(String[] args){
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(30);
		linkedList.add(30);
		linkedList.add(20);
		linkedList.printLinkedList();
		
//		System.out.println("\nRemove Data : "+linkedList.remove(20));
		LinkedListRemoveDuplicates.removeDups(linkedList);
		linkedList.printLinkedList();

	}
}
