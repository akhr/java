package com.akh.java_concepts_test.static_nested_class_test;

import com.akh.java_concepts_test.static_nested_class_test.OuterClass.NestedClass;

public class Tester {

	public Tester() {

	}
	
	public static void main(String[] args){
		OuterClass outer = new OuterClass(10);
		
		NestedClass nested_1 = new OuterClass.NestedClass(20);
		System.out.println("Nested Class nestedVar = "+nested_1.getNestedVar());
		System.out.println("Nested Class nestedVar + outerVar = "+nested_1.getNestedVarPlusOuterVar());
		
		NestedClass nested_2 = new OuterClass.NestedClass(100);
		System.out.println("Nested Class nestedVar = "+nested_2.getNestedVar());
		System.out.println("Nested Class nestedVar + outerVar = "+nested_2.getNestedVarPlusOuterVar());
		
	}

}
