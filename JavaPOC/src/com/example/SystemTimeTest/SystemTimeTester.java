package com.example.SystemTimeTest;

import java.util.Calendar;

public class SystemTimeTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				int count=10;
				while(count>0){
					long mills = System.currentTimeMillis();
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(mills);
					System.out.println("Time in Mills = "+ mills +"   , Long format = "+cal.getTime());
					count--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
