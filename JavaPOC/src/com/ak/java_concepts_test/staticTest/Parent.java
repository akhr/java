package com.thesaka.eg.staticTest;

public class Parent {
	static int a = 10;
	
	protected int addInnerContent(){
		int value = Parent.InnerClass.getValueOfB();
		return a+value;
	}
	
	static class InnerClass{
		static int b = 20; 
		static int c= a+b;
		
		static int getValueOfB(){
			return b;
		}
		
		static int getValueOfC(){
			return c;
		}
		
		static int calc(int b){
			return b+a;
		}
	}

}
