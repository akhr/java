package com.akh.java_concepts_test.mutliThreadingTest;

public class MutliThreadingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread.currentThread().setName("Main Thread");
		
		Thread childT = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				throw new NullPointerException();
			}
		}, "Child Thread");
		
		childT.start();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main Thread Still Alive");

	}

}
