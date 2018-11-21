/**
 * @fileName: MountainArray_941.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Nov 21, 2018
 * 
 */
package com.akh.algorithms.dataStructure.array;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @fileName: MountainArray_941.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 21, 2018
 * 
 */
public class MountainArray_941 {

	public boolean validMountainArray(int[] A) {
		if (A.length <= 2)
			return false;

		if (A[0] > A[1])
			return false;
		boolean isIncreasing = true;
		boolean isFliped = false;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] == A[i + 1])
				return false;
			if (isIncreasing) { // increasing
				if (A[i] > A[i + 1]) {
					if (!isFliped) {
						isFliped = true;
						isIncreasing = false;
						i--;
					} else
						return false;
				}
			} else { // decreasing
				if (A[i] < A[i + 1])
					return false;
			}
		}
		return isFliped;
	}

	@Test
	public void t_101() {
		int[] A = { 0, 3, 2, 1 };
		assertTrue(validMountainArray(A));
	}

	@Test
	public void t_102() {
		int[] A = { 14, 82, 89, 84, 79, 70, 70, 68, 67, 66, 63, 60, 58, 54, 44, 43, 32, 28, 26, 25, 22, 15, 13, 12, 10,
				8, 7, 5, 4, 3 };
		assertFalse(validMountainArray(A));
	}
}
