package com.thesaka.eg.enumTest;

import java.util.ArrayList;

import javax.management.relation.RoleList;

public class EnumTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		RoleList roleList = new RoleList();
		roleList.add("ONE");
		roleList.add("TWO");
		roleList.add("THREE");*/
//		ChildClass<ArrayList<String>> sampleInstance = new ChildClass(roleList);
//		sampleInstance.displayData();
		
		System.out.println(Days.FRIDAY.name());
		System.out.println(Days.SATURDAY.name());
		System.out.println(Days.WEDNESDAY.name());
		
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println(Days.valueOf("FRIDAY"));

		

	}

}
