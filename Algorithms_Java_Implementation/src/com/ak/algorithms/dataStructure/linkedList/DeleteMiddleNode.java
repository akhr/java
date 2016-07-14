package com.ak.algorithms.dataStructure.linkedList;

public class DeleteMiddleNode {

	/**
	 * Delete the middle node from a singly linked list given access only to that node.
	 * Input : a->b->c->d->e
	 * Node to delete c. No access to the head node.
	 * Output: a->b->d->e
	 */
	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = MockDataGenerator.generateSingleLinkedList(10);
		Node n = singlyLinkedList.head; 
		int deletePos = 3, pos=0; 
		while(pos < deletePos-1){
			n = n.next;
			pos++;
		}
		System.out.print("Input : ");
		singlyLinkedList.printLinkedList();
		System.out.print("\nNode to Delete : "+n.data);
		delete(n);
		System.out.print("\n\nOutput : ");
		singlyLinkedList.printLinkedList();
	}
	
	public static void delete(Node toDelete){
		Node nextToDelete = toDelete.next;
		toDelete.data = nextToDelete.data;
		toDelete.next = nextToDelete.next;
	}

}
