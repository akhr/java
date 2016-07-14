/**
 * 
 */
package com.ak.algorithms.dataStructure.linkedList;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Aug 17, 2012
 */
public class ReverseSinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node<String> head = new Node<String>("0");
		Node<String> node = new Node<String>("1");
		head.next = node;

		for(int i=2; i<=10; i++){
			node.next = new Node<String>(String.valueOf(i));
			node = node.next;
		}

		node = head;
		Node<String> head1 = head;
		
		do{
			System.out.println(node.element.toString());
			node = node.next;
		}while(node.next != null);

		/*System.out.println("************* ReverseTwoNodesAtEachStep(head) ***********************");

		head = reverseTwoNodesAtEachStep(head);
		do{
			System.out.println(head.element.toString());
			head = head.next;
		}while(head != null);*/
		
		
		System.out.println("************* ReverseOneNodeAtEachStep(head) ***********************");
		
		head1 = reverseOneNodeAtEachStep(head1);
		do{
			System.out.println(head1.element.toString());
			head1 = head1.next;
		}while(head1 != null);
	}



	private static Node<String> reverseOneNodeAtEachStep(Node<String> current){

		Node<String> previous = null;
		Node<String> next = current.next;

		while(next != null){
			current.next = previous;
			previous = current;
			current = next;
			next = next.next;
		}
		
		current.next = previous;
		return current;
	}

	private static Node<String> reverseTwoNodesAtEachStep(Node<String> head){

		Node<String> previous = head;	
		Node<String> current = head.next;
		Node<String> next = current.next;
		
		previous.next = null;
		
		while(current != null && current.next != null && next != null){
			Node<String> temp = next.next;
			current.next = previous;
			next.next = current;
			previous = current;
			current = next;
			next = temp;
		}

		return current;
	}


	private static class Node<E>{
		E element;
		Node<E> next;

		public Node(E element){
			this.element = element;
		}

	}
}
