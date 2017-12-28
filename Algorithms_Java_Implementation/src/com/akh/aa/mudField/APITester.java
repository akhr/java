package com.akh.aa.mudField;

import java.util.Arrays;

/**
 *  @fileName: APITester.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jun 11, 2017
 */

public class APITester {

	public static void main(String[] args) {
//		System.out.println("Missing - "+makeArrayConsecutive2(new int[]{6, 2, 3, 8, 10}));
		System.out.println("Missing - "+makeArrayConsecutive2(new int[]{0, 3}));
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		System.out.println("z- "+Character.getNumericValue('z'));
		System.out.println("a- "+Character.getNumericValue('a'));
		System.out.println("len - "+table.length);
	}
	
	static int makeArrayConsecutive2(int[] statues) {
	    Arrays.sort(statues);
	    int missingCount = 0;
	    int nextIndex = statues[0];
	    for(int i=0; i<=statues.length-1; i++){
	    	if(statues[i] != nextIndex){
	    		missingCount++;
	    		i--;
	    	}
	    	nextIndex++;
	    }
	    return missingCount;
	}

}
