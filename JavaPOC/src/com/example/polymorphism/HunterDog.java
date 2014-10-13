/**
 * 
 */
package com.example.polymorphism;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 8, 2012
 */
public class HunterDog extends Dog /*implements Pet*/ {

	/**
	 * 
	 */
	public HunterDog() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void eat() {
		System.out.println("HunterDogs eat");
	}		

	@Override
	public void makeNoise() {
		System.out.println("HunterDogs bark loud");
		
	}
	
	public void hunt(){
		System.out.println("HunterDogs hunt");
	}
	
	public void doSecurity(){
		System.out.println("HunterDogs secure houses");
	}
}
