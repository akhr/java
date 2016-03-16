package com.thesaka.eg.timeFormat;

import java.util.Calendar;
import java.util.Date;

public class TimeFormatTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Cur Time1 =" +System.currentTimeMillis());
		long startTime = System.currentTimeMillis();   
		Thread.sleep(3000); 
		System.out.println("Cur Time2 =" +System.currentTimeMillis());
		long estimatedTime =System.currentTimeMillis() - startTime;
		System.out.println("Run Time =" +estimatedTime/1000.00);
		
		Calendar cal = Calendar.getInstance();
		System.out.println("HOUR_OF_DAY =" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("HOUR =" + cal.get(Calendar.HOUR));
		System.out.println("WEEK_OF_MONTH =" + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WEEK_OF_YEAR =" + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("DAY_OF_WEEK =" + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_MONTH =" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK_IN_MONTH =" + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("MINUTE =" + cal.get(Calendar.MINUTE));
		System.out.println("MILLISECOND =" + cal.get(Calendar.MILLISECOND));
		System.out.println("DATE =" + cal.get(Calendar.DATE));
		System.out.println("SECOND =" + cal.get(Calendar.SECOND));
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("************************************************");
		
//		Date date = new Date(1985, 04, 10, 12, 30, 15);
		cal.set(1985, 04, 10, 12, 30, 15);

		System.out.println("YEAR =" + cal.get(Calendar.YEAR));
		System.out.println("MONTH =" + cal.get(Calendar.MONTH));
		System.out.println("DAY_OF_MONTH =" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_WEEK =" + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("HOUR_OF_DAY =" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("HOUR =" + cal.get(Calendar.HOUR));
		System.out.println("WEEK_OF_MONTH =" + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WEEK_OF_YEAR =" + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("DAY_OF_WEEK_IN_MONTH =" + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("MINUTE =" + cal.get(Calendar.MINUTE));
		System.out.println("MILLISECOND =" + cal.get(Calendar.MILLISECOND));
		System.out.println("DATE =" + cal.get(Calendar.DATE));
		System.out.println("SECOND =" + cal.get(Calendar.SECOND));

		
//		Date date = new Date(1985, 04, 10, 12, 30, 15);
//		
//		
//		System.out.println(""+date.get);
	}

}
