package com.akh.algorithms.dataStructure.array;

/**
 *  @fileName: CheckIfArrayIsIncreasingSquence.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 13, 2017
 *  
 *  
 *  Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false;

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. 
Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
*/

public class CheckIfArrayIsIncreasingSquence {

	public static void main(String[] args) {
		int[] in1 = new int[]{1, 3, 2, 1};
		int[] in2 = new int[]{1, 3, 2};
		int[] in3 = new int[]{1, 2, 1, 2};
		int[] in4 = new int[]{1, 2, 3, 4, 3, 6};
		int[] in5 = new int[]{3, 5, 67, 98, 3};
		int[] in6 = new int[]{192, -90, -30, 2, 5, 6, 10, 25, 30};
		
		System.out.println("Is in Incr Sqeuence - "+almostIncreasingSequence(in5));

	}

	static boolean almostIncreasingSequence(int[] sequence) {
		int length = sequence.length;
		int seqBrokenCount = 0;
		
		for(int i=0; i<length-1; i++){
		
			if(sequence[i] >= sequence[i+1]){
				if(seqBrokenCount >= 1){
					//already broken exit
					return false;
				}else{
					seqBrokenCount++;
					
					if(i == 0) //If first element continue considering the 1st element is removed
						continue;
					
					if(i == length-2) //last element. It can be removed
						return true;
					
					if(i-1 >= 0 && isRampSpike(i, sequence)){
						if(sequence[i-1] < sequence[i+1]){
							continue;
						}else{
                            return false;
                        }
					} else if(i+2 <= length-1 && isRampDip(i, sequence)){
						if(sequence[i] < sequence[i+2]){
							continue;
						}else{
                            return false;
                        }
					} else {
						return false;
					}
				}
			}
		}
		return seqBrokenCount >= 1;
	}
	
	static boolean isRampSpike(int i, int[] seq){
	    return (seq[i-1] < seq[i]) && (seq[i+1] < seq[i]) && (seq[i-1] < seq[i+1]);
	} 

	static boolean isRampDip(int i, int[] seq){
		return (seq[i] > seq[i+1]) && (seq[i+1] < seq[i+2]) && (seq[i] < seq[i+2]);
	}
}
