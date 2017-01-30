package com.akh.java_concepts_test.enumTest;

import java.util.ArrayList;

public class ChildClass<E extends ArrayList<E>> extends ParentClass<E> {
	
	E d;
	
	public ChildClass(E d){
		super(d);
		this.d = d;
	}

}
