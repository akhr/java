/**
 * 
 */
package com.thesaka.eg.comparatorTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class MainClassHumanComparator {
	public static void main(String[] args) {
		
		List<HumanBeings> indians = new ArrayList<HumanBeings>();
		
		indians.add(new Men("A")); 
		indians.add(new Women("J"));
		indians.add(new Men("C"));
		indians.add(new Men("E"));
		indians.add(new Women("B"));
		indians.add(new Men("Z"));
		indians.add(new Women("A"));
		indians.add(new Women("H"));
		indians.add(new Men("X"));
		indians.add(new Men("O"));
		indians.add(new Women("C"));
		indians.add(new Women("G"));
		
//		Collections.sort(indians, new HumanComparator());
		System.out.println("\nThe cast is ascending sequence is:\n");
		for (HumanBeings person : indians) {
			System.out.println("Person type = "+person.getClass().getSimpleName()+" Person Name =+" +person);
		}
	}
}
