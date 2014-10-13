package com.example.superClassTest;

public class Car {
	
	public Car(){
		accel();
	}

	public void accel()
	{
		System.out.println("This is Car Accel Method");
//		oilChange();
	}
	
	protected void oilChange(){
		System.out.println("This is Car OilChange Method");
	}
}
