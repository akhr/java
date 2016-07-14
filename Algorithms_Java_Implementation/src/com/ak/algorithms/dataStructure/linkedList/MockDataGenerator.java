package com.ak.algorithms.dataStructure.linkedList;


public class MockDataGenerator {


	
	public static SinglyLinkedList generateSingleLinkedList(int size){
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		for(int i=0; i<size; i++){
			singlyLinkedList.add(i);
		}
		return singlyLinkedList;
	}
}
