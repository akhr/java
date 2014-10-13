package com.example.springarray;

import java.awt.List;
import java.util.ArrayList;


public class SpringArrayTester {
	
	public static void main(String[] args)
	{
		ArrayList<String> testing = new ArrayList<String>();
		testing.add("One");
		testing.add("Two");
		testing.add("Three");
		testing.add("Mouse");
		boolean inList = testing.contains("Mouse");
		
		System.out.println("Result = "+ inList );
	}

}
