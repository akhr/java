/**
 * 
 */
package com.example.ListInterfaceTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 16, 2012
 */
public class Data {

	List<Integer> data = new ArrayList<Integer>();
	
	public Data(){
		for(int i=1; i<=60; i++){
			data.add(i);
		}
		System.out.println("Data obj created : "+data.toString());
	}
	
	public List<Integer> getData(){
		return Collections.unmodifiableList(data);
	}
	
}
