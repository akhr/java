package com.akh.java_concepts_test.superClassTest;

public class Corolla extends Toyota {
	
/*	public void accel() {
		//System.out.println("This is Corolla Accel Method");
	}*/
	
	public void brake() {
		//System.out.println("This is Corolla brake Method");
	}


	public void carSize(){
		System.out.println("This is COROLLA SIZE Method");
	}
	
	@Override
	public void oilChange(){
		System.out.println("This is COROLLA Oil Change Method");
	}
}
