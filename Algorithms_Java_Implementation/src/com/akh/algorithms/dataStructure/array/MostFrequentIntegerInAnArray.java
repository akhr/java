/*
 *  MostFrequentIntegerInAnArray.java
 *  Author: Akhash Ramamurthy
 *  Created on: Aug 13, 2017
 */

package com.akh.algorithms.dataStructure.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *  @fileName: MostFrequentIntegerInAnArray.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 13, 2017
 */

public class MostFrequentIntegerInAnArray {

	public static void main(String[] args) {
		int[] items = new int[]{2,1,43,1,6,73,5,4,65,1,3,6,1,1};
		System.out.println("Most common item = "+getMostFrequentInt(items));
	}
	
	//Time Complexity = O(N)
	//Space Complexity = O(N)
	public static int getMostFrequentInt(int[] items){
		Map<Integer, Integer> itemsMap = new HashMap<Integer, Integer>(items.length);
		for(int item : items){
			if(!itemsMap.containsKey(item))
				itemsMap.put(item, 1);
			else
				itemsMap.put(item, itemsMap.get(item)+1);
		}
		
		int maxCount = Integer.MIN_VALUE;
		for(Entry<Integer, Integer> entry : itemsMap.entrySet()){
			if(entry.getValue() > maxCount)
				maxCount = entry.getValue();
		}
		return maxCount;
	}
}
