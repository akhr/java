package com.thesaka.eg.thread_local_test;

public class ThreadLocalTester {
	
	private static final ThreadLocal<Integer> intThreadLocal= new ThreadLocal<Integer>();

	public ThreadLocalTester() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Thread thread_1 = new Thread(){
			
			public void run() {
				intThreadLocal.set(5);
				System.out.println("Thread 1 - ThreadLocal.get() : "+intThreadLocal.get());
			}
		};
		thread_1.start();
		
		Thread thread_2 = new Thread(){
			
			public void run() {
				intThreadLocal.set(300);
				System.out.println("Thread 2 - ThreadLocal.get() : "+intThreadLocal.get());
			}
		};
		thread_2.start();
	}

}
