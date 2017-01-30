package com.akh.java_concepts_test.staticTest;

public class Child extends Parent {
	public static void main(String... args){
		Child child = new Child();
		
		System.out.println(child.a);
//		System.out.println(addInnerContent());
	}
	
	@Override
	protected int addInnerContent(){
		int value = Parent.InnerClass.getValueOfB();
		return a+value;
	}

}
