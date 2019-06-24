/*
 *  TimeTravellingCounter.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

package com.akh.eugene;

import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  @fileName: TimeTravellingCounter.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

/**
 * @author Akhash Ramamurthy
 * Jan 7, 2018
 */
public class TimeTravellingCounter2 {

	Map<String, List<Long>> stringToTime = new HashMap<String, List<Long>>();
	Map<String,List<Long>> resetMap = new HashMap<String, List<Long>>();

	long timeUnit = 0;

	public void add(String str){
		if( stringToTime.containsKey(str)){
			List<Long> temp = stringToTime.get(str);
			temp.add(System.currentTimeMillis());
		}else{
			List<Long> t = new ArrayList<Long>();
			t.add(System.currentTimeMillis());
			stringToTime.put(str, t);
			
		}
		
	}
	public int getCount(String str){
		return getCount(str, System.currentTimeMillis());
	}

    public int getCount(String str, long givenTime){
    	if(resetMap.containsKey(str)){
    		List<Long> resetTimes = resetMap.get(str);
    		Long startTime = 0L;
    		for(int i=resetTimes.size()-1; i>=0; i++){
    			if(givenTime <= resetTimes.get(i)){
    				startTime = resetTimes.get(i);
    				break;
    			}
    		}
    		return getCount(str, startTime, givenTime);
    	}
    	return getCount(str, 0, givenTime);
    }

    public int getCount(String str, long startTime, long endTime){
    	List<Long> out = stringToTime.get(str);
    	int count = 0;
    	for(long x : out){
    		if(x >= startTime && x<=endTime)
    			count++;	
    	}
    	return count;
    }

    public void reset(String str){
    	if( resetMap.containsKey(str) ){
			List<Long> temp = resetMap.get(str);
			temp.add(System.currentTimeMillis());
		}else{
			List<Long> t = new ArrayList<Long>();
			t.add(System.currentTimeMillis());
			resetMap.put(str, t);
		}
    }
    
    
	@Test
	public void getEasy(){
		TimeTravellingCounter2 timeTravellingCounter = new TimeTravellingCounter2();
		timeTravellingCounter.add("foo");
		timeTravellingCounter.add("bar");
		timeTravellingCounter.add("foo");

		Assert.assertEquals(2, timeTravellingCounter.getCount("foo"));
		Assert.assertEquals(2,timeTravellingCounter.getCount("foo", Long.MAX_VALUE));

	}

}
