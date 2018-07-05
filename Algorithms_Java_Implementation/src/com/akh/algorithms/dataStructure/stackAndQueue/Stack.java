/*
 *  Stack.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jul 4, 2018
 */

package com.akh.algorithms.dataStructure.stackAndQueue;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *  @fileName: Stack.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 4, 2018
 */

/**
 * @author Akhash Ramamurthy
 * Jul 4, 2018
 */
public class Stack<E> {

	private static final double THRESHOLD_CAPACITY = 0.75;

	private Object[] mData;
	private int mCapacity;
	private int mSize;
	private int mTopIndex;

	public Stack(int capacity){
		mCapacity = capacity;
		mData = new Object[capacity];
		mSize = 0;
		mTopIndex = -1;
	}

	public void push(E item){
		ensureCapacity();
		mTopIndex++;
		mData[mTopIndex] = item;
		mSize++;
	}

	@SuppressWarnings("unchecked")
	public E pop() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException();
		else{
			E item = (E) mData[mTopIndex];
			mData[mTopIndex] = null;
			mTopIndex--;
			mSize--;
			System.out.println("Poped out - "+item.toString());
			return item;
		}
	}

	@SuppressWarnings("unchecked")
	public E peek(){
		if(isEmpty())
			throw new EmptyStackException();
		else
			return (E) mData[mTopIndex];
	}

	public boolean isEmpty(){
		return mSize <= 0;
	}

	private boolean isAtThresholdCapacity(){
		if((mSize/mCapacity) > THRESHOLD_CAPACITY){
			return true;
		}
		return false;
	}

	private void ensureCapacity(){
		if(isAtThresholdCapacity()){
			grow();
		}
	}

	private void grow(){
		System.out.println("Grow called");
		mCapacity *= 2;
		mData = Arrays.copyOf(mData, mCapacity);
		System.out.println("New mData Capacity - "+mCapacity);
	}

	public void printStack(){
		int top = mTopIndex;
		System.out.println("Stack Current Status: ");
		for (int i = top; i>=0; i--) {
			System.out.println(mData[i]);
		}
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(5);
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("e");
		stack.push("f");
		stack.pop();
		stack.push("g");
		stack.push("h");
		stack.push("i");
		stack.push("j");
		stack.push("k");
		stack.push("l");
		stack.printStack();
		try{
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
			stack.pop();
		}catch(EmptyStackException e){
			System.out.println("Stack Empty");
		}
	}
}
