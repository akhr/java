package com.example.staticTest;

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
