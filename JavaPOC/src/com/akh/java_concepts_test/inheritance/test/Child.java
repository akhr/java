package com.akh.java_concepts_test.inheritance.test;

public class Child extends Parent {
	
	private Integer attribute1;
	private Integer attribute2 = null;
	
	public Child(){
		super();
		System.out.println("Child Constructor");
	}
	
	public void init(){
		System.out.println("Child init()");
		super.init();
		attribute1 = new Integer(100);
		attribute2 = new Integer(200);
	}
	
	public void print(){
		System.out.println("attribute 1 : " +attribute1);
		System.out.println("attribute 2 : " +attribute2);
	}

}
