/**
 * 
 */
package com.akh.algorithms.dataStructure.heap;

import com.akh.utils.Utils;

/**
 * @author Akhash Ramamurthy
 * May 3, 2017
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 10;
		int min = 1;
		int max = 20;
		int[] input = Utils.intGenerator(size, min, max);
		Min_Heap minHeap = new Min_Heap();
		for(int i=0; i<size; i++){
			minHeap.add(input[i]);
		}
		Utils.printArray("Constructed Min-Heap", minHeap.toArray());
		
		System.out.println("Extracted Min : "+minHeap.poll());
		Utils.printArray("Heap after min extraction", minHeap.toArray());
	}

}
