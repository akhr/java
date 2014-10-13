package com.example.algo.dataStructure.linkedList;

public class Node{
	public Node next;
	public int data;

	public Node(int data){
		this.data = data;
	}
	
	public Node(int data, Node next){
		this.data = data;
		this.next = next;
	}

}