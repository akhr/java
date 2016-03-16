package com.thesaka.eg.InterfaceTest2;

public class Implementation2 implements Interface2 {

	public Implementation2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void implementThisMethod(String agr1, int agr2) {
		System.out.println("I am implementing implementThisMethod() of Interface2");

	}
	
	public void implementThisMethod (String agr1){
		System.out.println("I am implementing implementThisMethod() of Interface2");
	}

}
