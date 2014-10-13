/**
 * 
 */
package com.thesaka.eg.countDownLatchTest;

import java.util.concurrent.CountDownLatch;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 20, 2012
 */
public class Task implements Runnable{
	
	String name;
	CountDownLatch latch;
	
	public Task(String name, CountDownLatch latch){
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Latching Down Thread - "+name);
		latch.countDown();
	}

}
