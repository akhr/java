package com.example.InterfaceTest2;

public class Implementation3 implements Interface1, Interface2 {

	private static int count = 0;
	@Override
	public void implementThisMethod(String agr1, int agr2) {
		count ++;
		System.out.println("I am implementing implementThisMethod() and count = " + count);

	}
	
	public void implementThisMethod (String agr1){
		count ++;
		System.out.println("I am implementing implementThisMethod() and count = " + count);
	}

}
