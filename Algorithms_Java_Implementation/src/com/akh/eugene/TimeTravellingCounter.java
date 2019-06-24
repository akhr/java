/*
 *  TimeTravellingCounter.java
 *  Author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

package com.akh.eugene;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.akh.eugene.TimeTravellingCounter.Snapshot;

import java.util.HashMap;

/**
 *  @fileName: TimeTravellingCounter.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jan 7, 2018
 */

/**
 * @author Akhash Ramamurthy
 * Jan 7, 2018
 */
public class TimeTravellingCounter {
	
	Map<Long, Snapshot> snapshotMap = new HashMap<Long, Snapshot>();
	long timeUnit = 0;
	
	public void add(String str){
		if(snapshotMap.containsKey(timeUnit)){
			Snapshot snapshot = snapshotMap.get(timeUnit);
			snapshot.add(str);
		}else{
			Snapshot snapshot = new Snapshot();
			long prevStrCount = snapshotMap.get(timeUnit-2).getCount(str);
			snapshot.add(str);
			snapshotMap.put(timeUnit, snapshot);
			timeUnit++;
		}
	}
	
	public int getCount(String str){
		Snapshot snapshot = snapshotMap.get(timeUnit-1);
		return snapshot.getCount(str);
	}
	
	
	public static class Snapshot {
		Map<String, Integer> stringMap = new HashMap<String, Integer>();
		
		public void add(String str){
			if(stringMap.containsKey(str))
				stringMap.put(str, stringMap.get(str)+1);
			else
				stringMap.put(str, 1);
		}
		
		public int getCount(String str){
			return stringMap.get(str);
		}
	}
	
	@Test
	public void getEasy(){
		TimeTravellingCounter timeTravellingCounter = new TimeTravellingCounter();
		timeTravellingCounter.add("foo");
		timeTravellingCounter.add("bar");
		timeTravellingCounter.add("foo");
		
		Assert.assertEquals(2, timeTravellingCounter.getCount("foo"));
		
	}

}
