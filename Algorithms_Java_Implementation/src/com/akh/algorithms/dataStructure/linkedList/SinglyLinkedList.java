package com.akh.algorithms.dataStructure.linkedList;

public class SinglyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public void add(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			tail = head;
		}else{
			tail.next = newNode;
			tail = newNode;
		}
	}

	public boolean remove(int data){
		Node returnNode = null;

		if(head.data == data){
			returnNode = head;
			if(tail == head){
				head = null;
				tail = null;
			}else		
				head = head.next;
		}else{
			Node prev = head;
			Node n = head.next;
			while(n != null){
				if(n.data == data){
					returnNode = n;
					if(tail == returnNode){
						tail = prev;
						prev.next = null;
					}else{
						prev.next = n.next;
					}
				}
				prev = n;
				n = n.next;
			}
		}
		return (returnNode != null)?true:false;
	}
	
	public void printLinkedList(){
		System.out.print("\nLinkedList Data = {\t");
		Node n = head;
		while(n != null){
			System.out.print(n.data+"\t");
			n = n.next;
		}
		System.out.print("}");
	}



}
