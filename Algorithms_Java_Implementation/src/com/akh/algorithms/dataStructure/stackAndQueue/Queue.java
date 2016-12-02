package com.akh.algorithms.dataStructure.stackAndQueue;

public class Queue {

	private int[] data;
	private int head = 0;
	private int tail = 0;

	public Queue(int size){
		if(size>0)
			data = new int[size];
		else
			data = new int[10];
	}

	public void enqueue(int item){
		data[tail++] = item;
	}

	public int dequeue(){
		int item = 0;
		if(head<=tail){
			item = data[head++];
			System.out.println("Dequeued : "+item);
		}else
			System.out.println("Queue Empty !");
		return item;
	}

	public int size(){
		if((tail - head) > 0)
			return tail-head;
		else
			return -1;
	}
	
	public void printQueue(){
		if(tail>=head){
			System.out.print("\nQueue Contents : [ ");
			for(int i=head; i<tail; i++){
				System.out.print(data[i]+",\t");
			}
			System.out.println("]");
		}
	}

}
