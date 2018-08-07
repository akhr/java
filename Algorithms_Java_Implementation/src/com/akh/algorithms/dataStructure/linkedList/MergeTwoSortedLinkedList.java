package com.akh.algorithms.dataStructure.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *  @fileName: MergeTwoSortedLinkedList.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 7, 2018
 *	L1 ==> 8-->10-->35-->56-->78-->80
 *	L2 ==> 24-->32-->65
 *	Result ==> 8-->10-->24-->32-->35-->56-->65-->78-->80
 */

public class MergeTwoSortedLinkedList {

	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}

	public static Node merge(Node list1, Node list2){
		if(list1 == null && list2 == null)
			return null;
		if(list1 == null)
			return list2;
		if(list2 == null)
			return list1;
		
		Node curr1 = list1;
		Node curr2 = list2;
		Node resultHead = null;
		Node currResult = null;

		while(curr1 != null && curr2!= null){
			if(curr1.data < curr2.data){
				if(resultHead == null){
					resultHead = curr1;
					currResult = curr1;
					curr1 = curr1.next;
				}else{
					currResult.next = curr1;
					currResult = currResult.next;
					curr1 = curr1.next;
				}
			}else if(curr1.data > curr2.data){
				if(resultHead == null){
					resultHead = curr2;
					currResult = curr2;
					curr2 = curr2.next;
				}else{
					currResult.next = curr2;
					currResult = currResult.next;
					curr2 = curr2.next;
				}
			}

		}

		while(curr1 != null){
			currResult.next = curr1;
			currResult = currResult.next;
			curr1 = curr1.next;
		}

		while(curr2 != null){
			currResult.next = curr2;
			currResult = currResult.next;
			curr2 = curr2.next;
		}

		return resultHead;
	}

	public static Node getLinkedList(int[] arr){
		if(arr.length <= 0)
			return null;
		
		Node listHead = new Node(arr[0]);
		Node curr = listHead;
		for(int i=1; i<arr.length; i++){
			curr.next = new Node(arr[i]);
			curr = curr.next;
		}
		return listHead;
	}
	
	public static void printLinkedList(Node head){
		if(head == null){
			System.out.println("LinkedList Is Empty");
			return;
		}
		Node curr = head;
		System.out.println("====> Printing LinkedList ====>");
		while(curr != null){
			System.out.println(curr.data);
			curr = curr.next;
		}
		System.out.println("====> DONE Printing LinkedList ====>");
	}
	
	
	
	
	@Test
	public void test_1(){
		int[] l1 = {8,10,35,56,78,80};
		int[] l2 = {24,32,65};
		Node list1Head = getLinkedList(l1);
		Node list2Head = getLinkedList(l2);
		Node resultHead = merge(list1Head, list2Head);
		printLinkedList(resultHead);
		
		int[] expected = {8,10,24,32,35,56,65,78,80};
		Node curr = resultHead;
		int currE = 0;
		int loopCount = 0;
		while(curr != null){
			assertEquals(expected[currE], curr.data);
			currE++;
			curr = curr.next;
			loopCount++;
		}
		
		assertEquals(expected.length, loopCount);
	}
	
	@Test
	public void test_2(){
		int[] l1 = {0,0,0,1};
		int[] l2 = {24,32,65};
		Node list1Head = getLinkedList(l1);
		Node list2Head = getLinkedList(l2);
		Node resultHead = merge(list1Head, list2Head);
		printLinkedList(resultHead);
		
		int[] expected = {0,0,0,1,24,32,65};
		Node curr = resultHead;
		int currE = 0;
		int loopCount = 0;
		while(curr != null){
			assertEquals(expected[currE], curr.data);
			currE++;
			curr = curr.next;
			loopCount++;
		}
		
		assertEquals(expected.length, loopCount);
	}
	
	@Test
	public void test_3(){
		int[] l1 = {};
		int[] l2 = {24,32,65};
		Node list1Head = getLinkedList(l1);
		Node list2Head = getLinkedList(l2);
		Node resultHead = merge(list1Head, list2Head);
		printLinkedList(resultHead);
		
		int[] expected = {24,32,65};
		Node curr = resultHead;
		int currE = 0;
		int loopCount = 0;
		while(curr != null){
			assertEquals(expected[currE], curr.data);
			currE++;
			curr = curr.next;
			loopCount++;
		}
		
		assertEquals(expected.length, loopCount);
	}
	
	@Test
	public void test_4(){
		int[] l1 = {};
		int[] l2 = {};
		Node list1Head = getLinkedList(l1);
		Node list2Head = getLinkedList(l2);
		Node resultHead = merge(list1Head, list2Head);
		printLinkedList(resultHead);
		
		int[] expected = {};
		Node curr = resultHead;
		int currE = 0;
		int loopCount = 0;
		while(curr != null){
			assertEquals(expected[currE], curr.data);
			currE++;
			curr = curr.next;
			loopCount++;
		}
		
		assertEquals(expected.length, loopCount);
	}
}
