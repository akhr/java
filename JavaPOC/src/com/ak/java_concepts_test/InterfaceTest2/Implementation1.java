package com.thesaka.eg.InterfaceTest2;

public class Implementation1 implements Interface1{

	public Implementation1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void implementThisMethod(String agr1, int agr2) {
		System.out.println("I am implementing implementThisMethod() of Interface1");

	}
	
	public void implementThisMethod (String agr1){
		System.out.println("I am implementing implementThisMethod() of Interface1");
	}

}
