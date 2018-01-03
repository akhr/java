/*
 *  StackOfPlates.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jan 1, 2018
 */

package com.akh.algorithms.dataStructure.stackAndQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.akh.algorithms.dataStructure.stackAndQueue.StackUsingNode.StackNode;

/**
 *  @fileName: StackOfPlates.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jan 1, 2018
 */

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.
 */

public class StackOfPlates {

	private List<StackUsingNode> setOfStacks;
	int size;
	int currentSubStackIndex = -1;
	StackNode top = null;
	int stackMaxSize;

	public StackOfPlates() {
		this.stackMaxSize = 3;
		this.setOfStacks = new ArrayList<>();
		StackUsingNode a = new StackUsingNode();
		this.currentSubStackIndex = 0;
		this.setOfStacks.add(currentSubStackIndex, a);
		this.size = 0;
	}

	private boolean isSubStackFull(int subStackIndex) throws IllegalStateException{
		StackUsingNode subStack = setOfStacks.get(subStackIndex);
		if(subStack != null)
			return subStack.getSize() == stackMaxSize;
		else
			throw new IllegalStateException("Sub Stack Doesn't Exist");
	}

	private void addNewSubStack(){
		StackUsingNode subStack = new StackUsingNode();
		currentSubStackIndex++;
		setOfStacks.add(currentSubStackIndex, subStack);
	}

	public void push(int data){
		try{
			if(isSubStackFull(currentSubStackIndex)){
				addNewSubStack();
			}
			setOfStacks.get(currentSubStackIndex).push(data);
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
	}

	private boolean isSubStackEmpty(int subStackIndex) throws IllegalStateException{
		StackUsingNode subStack = setOfStacks.get(subStackIndex);
		if(subStack != null)
			return subStack.getSize() == 0;
		else
			throw new IllegalStateException("Sub Stack Doesn't Exist");
	}

	private void removeSubStack(int subStackIndex){
		setOfStacks.remove(currentSubStackIndex);
		currentSubStackIndex--;
	}

	public int pop() throws EmptyStackException, IllegalStateException{
		return popAt(currentSubStackIndex);
	}

	public int popAt(int subStackIndex) throws EmptyStackException, IllegalStateException{
		int data;
		if(!isSubStackEmpty(subStackIndex)){
			data = setOfStacks.get(subStackIndex).pop();
			if(subStackIndex == currentSubStackIndex){ //Do remove subStack only when normal pop() is called
				int subStackSize = setOfStacks.get(subStackIndex).getSize();
				if(subStackSize == 0)
					removeSubStack(subStackIndex);
				
				// If this prev subStack is all emptied out by user directly calling popAt() then remove this 
				// empty stack as well and remove the prev.prev
				subStackSize = setOfStacks.get(currentSubStackIndex).getSize();
				if(subStackSize == 0)
					removeSubStack(currentSubStackIndex);
			}
		}else{
			throw new IllegalStateException("Sub Stack Doesn't Exist");
		}
		return data;
	}

	public int peek(){
		return setOfStacks.get(currentSubStackIndex).peek();
	}

	public void printStack(){
		System.out.print("\n*********** StackOfPlates Contents : [");
		System.out.println("\nCURR = "+currentSubStackIndex);
		for(int i=0; i<=currentSubStackIndex; i++){
			setOfStacks.get(i).printStack();
		}
		System.out.println("]");
	}

	//====================================================================================
	@Test
	public void testStack(){
		StackOfPlates stackOfPlates = new StackOfPlates();
		stackOfPlates.push(10);
		stackOfPlates.push(20);
		stackOfPlates.push(30);
		stackOfPlates.push(40);
		stackOfPlates.push(50);
		stackOfPlates.push(60);
		stackOfPlates.push(70);
		stackOfPlates.push(80);
		stackOfPlates.push(90);
		stackOfPlates.push(100);
		stackOfPlates.printStack();
		Assert.assertEquals(3, stackOfPlates.currentSubStackIndex);
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.printStack();
		Assert.assertEquals(1, stackOfPlates.currentSubStackIndex);
		stackOfPlates.push(110);
		stackOfPlates.push(120);
		stackOfPlates.push(130);
		stackOfPlates.printStack();
		Assert.assertEquals(2, stackOfPlates.currentSubStackIndex);
		stackOfPlates.pop();
		stackOfPlates.printStack();
		Assert.assertEquals(1, stackOfPlates.currentSubStackIndex);
	}
	
	@Test
	public void testPopAt(){
		StackOfPlates stackOfPlates = new StackOfPlates();
		stackOfPlates.push(10);
		stackOfPlates.push(20);
		stackOfPlates.push(30);
		stackOfPlates.push(40);
		stackOfPlates.push(50);
		stackOfPlates.push(60);
		stackOfPlates.push(70);
		stackOfPlates.push(80);
		stackOfPlates.push(90);
		stackOfPlates.push(100);
		System.out.println("\n&^&^&^& Added all items");
		stackOfPlates.printStack();
		Assert.assertEquals(3, stackOfPlates.currentSubStackIndex);
		stackOfPlates.popAt(1);
		stackOfPlates.popAt(1);
		System.out.println("\n&^&^&^& Removed 2 items popAt 1");
		stackOfPlates.printStack();
		Assert.assertEquals(3, stackOfPlates.currentSubStackIndex);
		stackOfPlates.popAt(1);
		System.out.println("\n&^&^&^& Removed 1 item popAt 1");
		stackOfPlates.printStack();
		Assert.assertEquals(3, stackOfPlates.currentSubStackIndex);
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		System.out.println("\n&^&^&^& Removed 3 items pop");
		stackOfPlates.printStack();
		Assert.assertEquals(2, stackOfPlates.currentSubStackIndex);
		stackOfPlates.pop();
		System.out.println("\n&^&^&^& Removed 1 item pop");
		stackOfPlates.printStack();
		Assert.assertEquals(0, stackOfPlates.currentSubStackIndex);
	}


}
