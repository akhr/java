package com.akh.algorithms.dataStructure.stackAndQueue;

public class ThreeStacksWithOneArray {
	
	public static final int STACK_1 = 1;
	public static final int STACK_2 = 2;
	public static final int STACK_3 = 3;
	
	private int[] data;
	private int head1 = 0;
	private int head2 = 0;
	private int head3 = 0;
	
	public ThreeStacksWithOneArray(int stackSize){
		if(stackSize > 0){
			int size = (stackSize*3);
			System.out.println("\nArray created with size : "+size);
			data = new int[size];
		}
	}
	
	public void push(int stackId, int item){
		switch (stackId) {
		case STACK_1:
			int loc1 = head1*3;
			data[loc1] = item;
			head1++;
			break;
		case STACK_2:
			int loc2 = (head2*3)+1;
			data[loc2] = item;
			head2++;
			break;
		case STACK_3:
			int loc3 = (head3*3)+2;
			data[loc3] = item;
			head3++;
			break;
		default:
			break;
		}
	}
	
	public int pop(int stackId){
		int item = -1;
		switch (stackId) {
		case STACK_1:
			int loc1 = (--head1)*3;
			item = data[loc1];
			data[loc1] = 0;
			System.out.println("Poped Item STACK_1 :"+item);
			return item;
		case STACK_2:
			int loc2 = (--head2*3)+1;
			item = data[loc2];
			data[loc2] = 0;
			System.out.println("Poped Item STACK_2 :"+item);
			return item;
		case STACK_3:
			int loc3 = (--head3*3)+2;
			item = data[loc3];
			data[loc3] = 0;
			System.out.println("Poped Item STACK_3:"+item);
			return item;
		default:
			break;
		}
		System.out.println("\nStack "+stackId+" is Empty");
		return item;
	}
	
	public int peek(int stackId){
		int item = -1;
		switch (stackId) {
		case STACK_1:
			int loc1 = (head1-1)*3;
			item = data[loc1];
			return item;
		case STACK_2:
			int loc2 = (head2-1)*3;
			item = data[loc2];
			return item;
		case STACK_3:
			int loc3 = (head3-1)*3;
			item = data[loc3];
			return item;
		default:
			break;
		}
		System.out.println("\nStack "+stackId+" is Empty");
		return item;
	}
	
	public void printStack(int stackId){
		
		switch (stackId) {
		case STACK_1:
			System.out.print("\n\n\nPrinting STACK_1 Contents : [ ");
			for(int i=0; i<head1; i++){
				System.out.print(data[i*3]+",\t");
			}
			System.out.println("]");
			break;
		case STACK_2:
			System.out.print("\n\n\nPrinting STACK_2 Contents : [ ");
			for(int i=0; i<head2; i++){
				System.out.print(data[(i*3)+1]+",\t");
			}
			System.out.println("]");
			break;
		case STACK_3:
			System.out.print("\n\n\nPrinting STACK_3 Contents : [ ");
			for(int i=0; i<head3; i++){
				System.out.print(data[(i*3)+2]+",\t");
			}
			System.out.println("]");
			break;
		default:
			break;
		}
	}

}
