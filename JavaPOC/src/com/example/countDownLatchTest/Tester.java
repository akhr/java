/**
 * 
 */
package com.example.countDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 20, 2012
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		Task t1 = new Task("thread1", latch);
		Task t2 = new Task("thread2", latch);
		Task t3 = new Task("thread3", latch);
		
		System.out.println("Time = "+System.currentTimeMillis());
		new Thread(t1).start();
		new Thread(t2).start(); 
		new Thread(t3).start();
		
		try {
			System.out.println("Latch is starting to AWAIT");
			latch.await(10000, TimeUnit.MILLISECONDS);
			System.out.println("Latch AWAIT is COMPLETED");
			System.out.println("Time = "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
