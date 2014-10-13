package com.example.polymorphism;

public class Dog extends Animal implements Pet {

	public Dog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void befriendly() {
		System.out.println("Dog is pet");
	}

	@Override
	public void eat() {
		System.out.println("Dog eat");
	}		

	@Override
	public void makeNoise() {
		System.out.println("Dog make noise");
		
	}
	
	public void doSecurity(){
		System.out.println("Dog secure houses");
	}

}
