package com.akh.aa.mudField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 *  @fileName: X_Of_A_Kind_In_A_Deck_914.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 29, 2018
 *  
 *  In a deck of cards, each card has an integer written on it.

		Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

		Each group has exactly X cards.
		All the cards in each group have the same integer.


		Example 1:

		Input: [1,2,3,4,4,3,2,1]
		Output: true
		Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
		Example 2:

		Input: [1,1,1,2,2,2,3,3]
		Output: false
		Explanation: No possible partition.
		Example 3:

		Input: [1]
		Output: false
		Explanation: No possible partition.
		Example 4:

		Input: [1,1]
		Output: true
		Explanation: Possible partition [1,1]
		Example 5:

		Input: [1,1,2,2,2,2]
		Output: true
		Explanation: Possible partition [1,1],[2,2],[2,2]
 */

public class X_Of_A_Kind_In_A_Deck {

	public boolean hasGroupsSizeX(int[] deck) {
		int len = deck.length;
		if(deck == null || deck.length <= 0 || len % 2 != 0)
			return false;

		Map<Integer, Integer> map = getIndividualCounts(deck);
		int minGrpSize = Integer.MAX_VALUE;

		for(Entry<Integer, Integer> entry : map.entrySet()){
			minGrpSize = Math.min(minGrpSize, entry.getValue());
		}

		for(Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() % minGrpSize != 0)
				return false;
		}
		return true;
	}

	private Map<Integer, Integer> getIndividualCounts(int[] deck){
		Map<Integer, Integer> map = new HashMap<>();
		for(int item : deck){
			map.put(item, map.getOrDefault(item, 0)+1);		
		}
		return map;
	}

	@Test 
	public void test_1(){
		int[] a = {1,2,3,4,4,3,2,1};
		assertTrue(hasGroupsSizeX(a));
	}

	@Test 
	public void test_2(){
		int[] a = {1,1,1,2,2,2,3,3};
		assertFalse(hasGroupsSizeX(a));
	}

	@Test 
	public void test_3(){
		int[] a = {1,1};
		assertTrue(hasGroupsSizeX(a));
	}

	@Test 
	public void test_4(){
		int[] a = {1,1,2,2,2,2};
		assertTrue(hasGroupsSizeX(a));
	}



/*	public int partitionDisjoint(int[] A) {
		if(A==null)
			return 0;
		if(A.length == 2){
			return 1;
		}
		int leftIndx = 0;
		int rightIndx = A.length-1;
		int leftLargest = Integer.MIN_VALUE;
		int leftLargestIndx = 0;
		int rightSmallestIndx = A.length-1;
		int rightSmallest = Integer.MAX_VALUE;

		while(leftIndx < rightIndx){
			int left = A[leftIndx];
			int right = A[rightIndx];

			if(leftLargest < left){
				leftLargest = left;
				leftLargestIndx = leftIndx;
			}

			if(rightSmallest > right){
				rightSmallest = right;
				rightSmallestIndx = rightIndx;
			}

			if(leftLargest < rightSmallest){
				leftIndx++;
				rightIndx--;
			}else{ //break
				if(leftLargest == left && rightSmallest == right){
					return leftIndx+2;
				} 
				if(leftLargest != left){
					return (leftLargestIndx-1)+1;
				}
				if(rightSmallest != right){
					return A.length - (rightSmallestIndx+1);
				}
			}
		}
		return leftIndx+1;
	}*/
	
	public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N-1];
        for (int i = N-1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i-1] <= minright[i])
                return i;

        return -1;
    }


	@Test 
	public void test_b_1(){
		int[] a = {1,1,1,0,6,12};
		assertEquals(4, partitionDisjoint(a));
	}

	@Test 
	public void test_b_2(){
		int[] a = {5,0,3,8,6};
		assertEquals(3, partitionDisjoint(a));
	}

	@Test 
	public void test_b_3(){
		int[] a = {1,1};
		assertEquals(1, partitionDisjoint(a));
	}

	@Test 
	public void test_b_4(){
		int[] a = {26,51,40,58,42,76,30,48,79,91};
		assertEquals(1, partitionDisjoint(a));
	}
	
	@Test 
	public void test_b_5(){
		int[] a = {90,47,69,10,43,92,31,73,61,97};
		assertEquals(9, partitionDisjoint(a));
	}


	/**
	 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.



Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]


Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].

	 */

	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> res = new ArrayList<>();
		if(A != null && B != null && A.length > 0 && B.length > 0)
			return res;
		return res;
	}
}
