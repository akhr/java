/**
 * 
 */
package com.example.comparatorTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class MainClassControllerTypeComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<AbstractController> arr = new ArrayList<AbstractController>();
		arr.add(new ViewController());
		arr.add(new DataController());
		arr.add(new DataViewController());
		arr.add(new DataController());
		arr.add(new ViewController());
		arr.add(new ViewController());
		arr.add(new DataController());
		arr.add(new DataViewController());
		arr.add(new DataViewController());
		arr.add(new DataController());
		arr.add(new ViewController());
		arr.add(new ViewController());
		arr.add(new DataViewController());
		arr.add(new DataController());
		arr.add(new ViewController());
		
		Collections.sort(arr, new ControllerTypeComparator());
		System.out.println("\nThe cast is ascending sequence is:\n");
		for (AbstractController arrElement : arr) {
			System.out.println("Controller type = "+arrElement.getClass().getSimpleName());
		}

	}

}
