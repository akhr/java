package com.akh.java_concepts_test.superClassTest;

public abstract class Toyota extends Car {
	
	public Toyota(){
		accel();
	}

	@Override
	public void accel() {
		System.out.println("This is Toyota Accel Method");
	}
	
	
/*	public void lights(){
		accel();
		System.out.println("This is Toyota lights Method");
	}*/
//	protected abstract void brake(); 
	
	public void wiper(Toyota myCar){
		System.out.println("Going from Wiper to Caution"); 
		myCar.caution();
	}


	protected abstract void carSize();
	
	protected void caution(){
		System.out.println("Toyota Caution ON when Speeding");
	}

}
