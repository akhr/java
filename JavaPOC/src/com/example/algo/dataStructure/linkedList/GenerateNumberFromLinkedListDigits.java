package com.example.algo.dataStructure.linkedList;

public class GenerateNumberFromLinkedListDigits {
	
	public static int generateNumber(Node head, int position){
		if(head.next == null){
			return head.data;
		}
		return generateNumber(head.next, position-1) + (head.data * (int)Math.pow(10,position));
	}
	
	public static int getDigitCount(Node head){
		Node n = head;
		int digitCount = 0;
		while(n != null){
			n = n.next;
			digitCount++;
		}
		return digitCount;
	}
	
	public static int generateNumberFromReverse(Node head, int position){
		if(head.next == null){
			return head.data * (int)Math.pow(10,position);
		}
		return generateNumberFromReverse(head.next, position+1) + (head.data * (int)Math.pow(10,position));
	}
	
	public static int[] generateNumber_2(Node node, int position){
		if(node != null && node.next==null){
			return new int[]{node.data, position+1}; 
		}
		
		int[] result = generateNumber_2(node.next, position);
		int tensValue = (node.data * (int)Math.pow(10, result[1])) + result[0];
		return new int[]{tensValue, result[1]+1};
	}

	public static int addNumbers(Node head1, Node head2){
		/*int number1 = generateNumber(head1, getDigitCount(head1)-1);
		int number2 = generateNumber(head2, getDigitCount(head2)-1);*/
		
		int number0 = generateNumber_2(head1, 0)[0];
		System.out.println("\nNumber 0 : "+number0);
		int number1 = generateNumber_2(head2, 0)[0];
		System.out.println("\nNumber 1 : "+number1);
		
		int number2 = generateNumberFromReverse(head1, 0);
		System.out.println("\nNumber 2 : "+number2);
		int number3 = generateNumberFromReverse(head2, 0);
		System.out.println("\nNumber 3 : "+number3);
		return number1 + number2;
	}
	
	public static void main(String[] args){
		SinglyLinkedList singlyLinkedList_1 = new SinglyLinkedList();
		singlyLinkedList_1.add(1);
		singlyLinkedList_1.add(2);
		singlyLinkedList_1.add(3);
		singlyLinkedList_1.add(4);
		singlyLinkedList_1.add(5);
		singlyLinkedList_1.add(6);
		singlyLinkedList_1.add(7);
		singlyLinkedList_1.add(8);
		
		SinglyLinkedList singlyLinkedList_2 = new SinglyLinkedList();
		singlyLinkedList_2.add(5);
		singlyLinkedList_2.add(9);
		singlyLinkedList_2.add(2);
		
		System.out.print("Input 1 : ");
		singlyLinkedList_1.printLinkedList();
		
		System.out.print("\nInput 2 : ");
		singlyLinkedList_2.printLinkedList();
		
		System.out.println("\nResult : "+addNumbers(singlyLinkedList_1.head, singlyLinkedList_2.head));
	}
	
}
