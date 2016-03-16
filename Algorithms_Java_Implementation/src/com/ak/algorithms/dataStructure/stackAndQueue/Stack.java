package com.thesaka.algorithms.dataStructure.stackAndQueue;

public class Stack {
	
	private int[] data;
	private int tail=0;
	
	public Stack(int size){
		if(size > 0)
			data = new int[size];
		else
			data = new int[10];
	}
	
	public void push(int item){
		data[tail++] = item;
	}
	
	public int pop(){
		int item = data[--tail];
		data[tail] = 0;
		return item;
	}
	
	public int peek(){
		return data[tail-1];
	}
	
	public void printStack(){
		System.out.print("\nStack Contents : [");
		for(int i=tail-1; i>=0; i--){
			System.out.print(data[i]+",\t");
		}
		System.out.println("]");
	}

}
