package com.akh.java_concepts_test.inheritance.test;

public abstract class Parent {
	
	public Parent(){
		System.out.println("Parent Constructor");
		init();
	}

	public void init(){
		System.out.println("parent Init()");
	}
		
		
		
		/*method1();
	}
	
	protected abstract void method1();
	
	protected void method2(){
	}*/
}
