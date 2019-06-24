/**
 * @fileName: DeleteStringColumsToMakeSorted_944.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Nov 21, 2018
 * 
 */
package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @fileName: DeleteStringColumsToMakeSorted_944.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 21, 2018
 * 
 */
public class DeleteStringColumsToMakeSorted_944 {

	public int minDeletionSize(String[] A) {
		if(A == null || A.length <= 0)
			return 0;
		
		int rows = A.length;
		int cols = A[0].length();
		Set<Integer> deleteIndices = new HashSet<>();
		
		for(int j=0; j<cols; j++) {
			for(int i=1; i<rows; i++) {
				
				if(deleteIndices.contains(j)) //Optimization. Check if this column needs to be skipped.
					continue;
				
				String prevStr = A[i-1]; 
				String currStr = A[i]; 
				if(currStr.charAt(j) < prevStr.charAt(j)) {  //Column char is out of order - delete col
					deleteIndices.add(j);
				}
			}
		}
		return deleteIndices.size();
	}
	
	@Test
	public void test_1() {
		String[] A = {"cba","daf","ghi"};
		int expected = 1;
		assertEquals(expected, minDeletionSize(A));
	}
	
	@Test
	public void test_2() {
		String[] A = {"a","b"};
		int expected = 0;
		assertEquals(expected, minDeletionSize(A));
	}
	
	@Test
	public void test_3() {
		String[] A = {"zyx","wvu","tsr"};
		int expected = 3;
		assertEquals(expected, minDeletionSize(A));
	}

}
