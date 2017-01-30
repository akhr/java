package com.akh.java_concepts_test.threadtest;

public class RunnableExample {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnableThread(), "thread1");
		Thread thread2 = new Thread(new RunnableThread(), "thread2");
		RunnableThread thread3 = new RunnableThread("thread3");
		//Start the threads
		thread1.start();
		thread1.start();
		try {
			//delay for one second
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());
	}
}


class RunnableThread implements Runnable {

	Thread runner;
	public RunnableThread() {
	}
	public RunnableThread(String threadName) {
/*		runner = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(runner.getName());
		runner.start(); // (2) Start the thread.
*/	}
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread());
	}
}