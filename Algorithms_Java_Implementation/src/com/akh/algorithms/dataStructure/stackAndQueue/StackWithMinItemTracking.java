/*
 *  StackWithMinItemTracking.java
 *  Author: Akhash Ramamurthy
 *  Created on: Dec 30, 2017
 */

package com.akh.algorithms.dataStructure.stackAndQueue;

import java.util.EmptyStackException;

import org.junit.Assert;
import org.junit.Test;


/**
 *  @fileName: StackWithMinItemTracking.java
 *  @author: Akhash Ramamurthy
 *  Created on: Dec 30, 2017
 */

/**
 * @author Akhash Ramamurthy
 * Dec 30, 2017
 */
public class StackWithMinItemTracking {
	
	public static class StackNode {
		int data;
		StackNode next;
		StackNode minUntilThisPoint;
		
		public StackNode(int data){
			this.data = data;
		}
	}
	
	private int size;
	private StackNode top;
	private StackNode stackMin;
	
	public void push(int data){
		StackNode newNode = new StackNode(data);
		if(top == null){
			top = newNode;
			newNode.minUntilThisPoint = newNode;
		}else{
			newNode.next = top;
			top = newNode;
			updateMinNodeOnPush(newNode);
		}
		size++;
	}
	
	public int pop() throws EmptyStackException{
		if(size == 0)
			throw new EmptyStackException();
		StackNode returnNode = top;
		top = top.next;
		updateMinNodeOnPop(returnNode);
		size--;
		return returnNode.data;
	}
	
	public int peek(){
		if(size == 0)
			throw new EmptyStackException();
		return top.data;
	}
	
	public int getMin(){
		return stackMin.data;
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
	
	private void updateMinNodeOnPush(StackNode newNode){
		if(stackMin == null || stackMin.data >= newNode.data){
			stackMin = newNode;
		}
		//Update with new Min or existing Min
		newNode.minUntilThisPoint = stackMin;
	}
	
	private void updateMinNodeOnPop(StackNode popedNode){
		if(stackMin.data == popedNode.data){
			stackMin = top.minUntilThisPoint;
		}
	}
	
	
//=====================================  TEST ============================================	
	@Test
	public void testStackSize(){
		StackWithMinItemTracking stack = new StackWithMinItemTracking();
		stack.push(100);
		stack.push(78);
		stack.push(30);
		stack.push(10);
		stack.push(21);
		stack.push(60);
		stack.push(3);
		stack.push(80);
		stack.push(4);
		stack.push(5);
		stack.pop();
		Assert.assertEquals(9, stack.getSize());
	}
	
	@Test
	public void testEmptyStack(){
		StackWithMinItemTracking stack = new StackWithMinItemTracking();
		try{
			stack.pop();
		}catch (EmptyStackException e){
			Assert.assertTrue(true); 
			return;
		}
		Assert.fail();
	}
	
	@Test
	public void testStackMin(){
		StackWithMinItemTracking stack = new StackWithMinItemTracking();
		stack.push(100);
		stack.push(2);
		stack.push(30);
		stack.push(9);
		stack.push(80);
		stack.push(8);
		stack.push(6);
		stack.printStack();
		Assert.assertEquals(2, stack.getMin());
		stack.pop();
		stack.printStack();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.printStack();
		Assert.assertEquals(2, stack.getMin());
		stack.pop();
		stack.printStack();
		Assert.assertEquals(2, stack.getMin());
	}
}
