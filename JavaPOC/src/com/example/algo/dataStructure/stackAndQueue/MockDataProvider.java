package com.example.algo.dataStructure.stackAndQueue;

public class MockDataProvider {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack(20);
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
		stack.printStack();
		
		Queue queue = new Queue(20);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);
		queue.enqueue(100);
		queue.printQueue();
		
		ThreeStacksWithOneArray stacksWithArray = new ThreeStacksWithOneArray(10);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 10);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 20);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 30);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 40);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 50);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 60);
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_1);
		
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 100);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 200);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 300);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 400);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 500);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 600);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_2, 700);
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_2);
		
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 1000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 2000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 3000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 4000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 5000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 6000);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_3, 7000);
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_3);
		
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_3); //7000
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_2); //700
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //60
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_3); //6000
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_3); //5000 
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_3); //4000
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_2); //600
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_2); //500
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //50
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //40
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //30
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //20
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //10  Stack 1 Empty
		
		System.out.println("=====  After Poping  ====");
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 11);
		stacksWithArray.push(ThreeStacksWithOneArray.STACK_1, 12);
		stacksWithArray.pop(ThreeStacksWithOneArray.STACK_1); //12
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_1);
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_2);
		stacksWithArray.printStack(ThreeStacksWithOneArray.STACK_3);
		

	}

}
