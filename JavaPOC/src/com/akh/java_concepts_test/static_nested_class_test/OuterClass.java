package com.akh.java_concepts_test.static_nested_class_test;

public class OuterClass {
	
	private static int outer_var;
	
	private String outerInstanceVar;

	public OuterClass(int a) {
		outer_var = a;
	}
	
	public static class NestedClass{
		
		private int nested_var;
		
		public NestedClass(int a) {
			nested_var = a;
		}
		
		public int getNestedVar(){
			return nested_var;
		}
		
		public int getNestedVarPlusOuterVar(){
			return nested_var + outer_var;
		}
		
	}

}
