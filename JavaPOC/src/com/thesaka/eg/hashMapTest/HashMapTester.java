/**
 * 
 */
package com.thesaka.eg.hashMapTest;

import java.util.HashMap;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Sep 25, 2012
 */
public class HashMapTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("CAT", "MILK");
		map.put("DOG", "BONE");
		map.put("CROW", "MEAT");
		map.put("LION", "MEAT");
		map.put("DEER", "GRASS");
		map.put("SQUIREL", "FRUIT");
	}

}
