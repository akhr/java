package com.thesaka.eg.superclass;

import java.util.List;

public class SuperClassA {
	
	static List list;
	
	public static int add(SuperClassA obj){
		list.add(obj);
		return list.size();
	}

}
