/**
 * 
 */
package com.example.polymorphism;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 8, 2012
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new HunterDog();
		((HunterDog)a).doSecurity();
		((HunterDog)a).befriendly();

	}

}
