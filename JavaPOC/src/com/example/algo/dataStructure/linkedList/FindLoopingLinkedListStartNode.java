package com.example.algo.dataStructure.linkedList;

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

}
