/*
 *  StackUsingNode.java
 *  Author: Akhash Ramamurthy
 *  Created on: Dec 30, 2017
 */

package com.akh.algorithms.dataStructure.stackAndQueue;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;

/**
 *  @fileName: StackUsingNode.java
 *  @author: Akhash Ramamurthy
 *  Created on: Dec 30, 2017
 */

/**
 * @author Akhash Ramamurthy
 * Dec 30, 2017
 */
public class StackUsingNode {
	
	public static class StackNode {
		int data;
		StackNode next;
		
		public StackNode(int data){
			this.data = data;
		}
	}
	
	private int size;
	private StackNode top;
	
	public void push(int data){
		StackNode newNode = new StackNode(data);
		if(top == null)
			top = newNode;
		else{
			newNode.next = top;
			top = newNode;
		}
		size++;
	}
	
	public int pop() throws EmptyStackException{
		if(size == 0)
			throw new EmptyStackException();
		StackNode returnNode = top;
		top = top.next;
		size--;
		return returnNode.data;
	}
	
	public int peek(){
		if(size == 0)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void printStack(){
		System.out.print("\nStack Contents : [");
		StackNode next = top;
		while(next != null){
			System.out.print(next.data+",\t");
			next = next.next;
		}
		System.out.println("]");
	}
	
	@Test
	public void testStack(){
		StackUsingNode stack = new StackUsingNode();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.push(100);
		stack.printStack();
		stack.pop();
		System.out.println("100 poped - Now peeking : "+stack.peek());
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
		Assert.assertEquals(4, stack.getSize());
	}
	
	@Test
	public void testEmptyStack(){
		StackUsingNode stack = new StackUsingNode();
		try{
			stack.pop();
		}catch (EmptyStackException e){
			Assert.assertTrue(true); 
			return;
		}
		Assert.fail();
	}
}
