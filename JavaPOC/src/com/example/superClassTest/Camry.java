package com.example.superClassTest;

public class Camry extends Toyota {
	
	public Camry(){
		super();
	}

	@Override
	public void accel() {
		System.out.println("This is Camry Accel Method");
	}
	
	public void brake() {
		//System.out.println("This is Camry Brake Method");
	}
	
	public void carSize(){
		System.out.println("This is Camry SPECIAL  SIZE Method");
	}
	
	protected void caution(){
		System.out.println("Camry Caution ON when Speeding");
	}
	

}
