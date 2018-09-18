package com.akh.algorithms.dataStructure.array.range;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  @fileName: Range_Sum_Query_Mutable_307_Test.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 18, 2018
 */

public class Range_Sum_Query_Mutable_307_Test {
	
	private Range_Sum_Query_Mutable_307 rangeSumQuery;
	int[] nums;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		nums = null;
		rangeSumQuery = null;
	}

	@Test
	public void testSumRange_1() {
		nums = new int[] {1, 3, 5};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(9, rangeSumQuery.sumRange(0, 2));
	}

	@Test
	public void testUpdate_1() {
		nums = new int[] {1, 3, 5, 4};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		rangeSumQuery.update(1, 2);
		assertEquals(8, rangeSumQuery.sumRange(0, 2));
	}
	
	@Test
	public void testSumRange_2() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(6, rangeSumQuery.sumRange(2, 4));
	}

	@Test
	public void testUpdate_2() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(6, rangeSumQuery.sumRange(2, 4));
		rangeSumQuery.update(3, 10);
		assertEquals(16, rangeSumQuery.sumRange(2, 4));
	}
	
	@Test
	public void testUpdate_3() {
		nums = new int[]{-1,2,4,0};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(6, rangeSumQuery.sumRange(1, 3));
		rangeSumQuery.update(3, 10);
		assertEquals(16, rangeSumQuery.sumRange(1, 3));
	}
	
	@Test
	public void testSumRange_EmptyArray() {
		nums = new int[]{};
		try{
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		}catch (IllegalArgumentException e) {
			assertTrue(e instanceof IllegalArgumentException);;
		}
	}
	
	@Test
	public void testSumRange_NullArray() {
		nums = null;
		try{
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		}catch (IllegalArgumentException e) {
			assertTrue(e instanceof IllegalArgumentException);;
		}
	}
	
	@Test
	public void testSumRange_OutOfBound_1() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(-1, rangeSumQuery.sumRange(12, 14));
	}
	
	@Test
	public void testSumRange_OutOfBound_2() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		assertEquals(-1, rangeSumQuery.sumRange(-1, 3));
	}
	
	@Test
	public void testUpdate_OutOfBound_1() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		rangeSumQuery.update(-1, 10);
		assertEquals(6, rangeSumQuery.sumRange(2, 4));
	}
	
	@Test
	public void testUpdate_OutOfBound_2() {
		nums = new int[]{-1,3,4,0,2,1};
		rangeSumQuery = new Range_Sum_Query_Mutable_307(nums);
		rangeSumQuery.update(13, 10);
		assertEquals(6, rangeSumQuery.sumRange(2, 4));
	}

}
