package com.akh.java_concepts_test.superclass;

import java.util.List;

public class SuperClassA {
	
	static List list;
	
	public static int add(SuperClassA obj){
		list.add(obj);
		return list.size();
	}

}
