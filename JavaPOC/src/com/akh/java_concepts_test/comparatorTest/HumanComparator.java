/**
 * 
 */
package com.akh.java_concepts_test.comparatorTest;

import java.util.Comparator;

/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class HumanComparator implements java.util.Comparator<HumanBeings> {

	@Override
	public int compare(HumanBeings o1, HumanBeings o2) {
		if(o1 instanceof Men && o2 instanceof Men)
			return 0;
		else if(o1 instanceof Men && o2 instanceof Women)
			return -1;
		else if (o1 instanceof Women && o2 instanceof Men)
			return 1;
		
		return 0;
			
	}



}
