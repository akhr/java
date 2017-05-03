/**
 * 
 */
package com.akh.algorithms.dataStructure.heap;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author Akhash Ramamurthy
 * May 2, 2017
 * For Explanation : 
 * ********************  https://www.youtube.com/watch?v=t0Cq6tVNRBA  
 */
public class Min_Heap {

	private int[] data;
	private int size = 0;
	
	public Min_Heap() {
		data = new int[10];
	}

	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}

	private int getLeftChildIndex(int parentIndex){
		return (parentIndex*2)+1;
	}

	private int getRightChildIndex(int parentIndex){
		return (parentIndex*2)+2;
	}

	private boolean hasParent(int childIndex){
		if(childIndex == 0)
			return false;
		return getParentIndex(childIndex) >= 0;
	}

	private boolean hasLeftChild(int parentIndex){
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasRightChild(int parentIndex){
		return getRightChildIndex(parentIndex) < size;
	}

	private int getParent(int childIndex){
		return data[getParentIndex(childIndex)];
	}

	private int getLeftChild(int parentIndex){
		return data[getLeftChildIndex(parentIndex)];
	}

	private int getRightChild(int parentIndex){
		return data[getRightChildIndex(parentIndex)];
	}

	public void ensureCapacity(){
		if(size == data.length){
			int newCapacity = data.length*2;
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	public void swap(int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public int peek(){
		if(size <= 0)
			throw new IllegalStateException();
		return data[0];
	}

	public int poll(){
		if(size <= 0)
			throw new IllegalStateException();

		int item = data[0];
		data[0] = data[size-1];
		heapifyDown();
		size--;
		return item;
	}

	public void add(int item){
		ensureCapacity();
		data[size] = item;
		heapifyUp(size);
		size++;
	}

	public void heapifyUp(int index){
		int childIndex = index;

		while(hasParent(childIndex)){
			if(getParent(childIndex) > data[childIndex]){
				swap(childIndex, getParentIndex(childIndex));
			}
			childIndex = getParentIndex(childIndex); //Child becomes next parent
		}
	}

	public void heapifyDown(){
		int parentIndex = 0;
		while(hasLeftChild(parentIndex)){ //If no left child then there is no right child
			int smallerChildIndex = getLeftChildIndex(parentIndex);
			if(hasRightChild(parentIndex) && getRightChild(parentIndex) < getLeftChild(parentIndex)){
				smallerChildIndex = getRightChildIndex(parentIndex);
			}
			if(data[parentIndex] > data[smallerChildIndex]){
				swap(parentIndex, smallerChildIndex);
			}
			parentIndex = smallerChildIndex;
		}
	}
	
	public int[] toArray(){
		return Arrays.copyOf(data, size);
	}

}
