/**
 * 
 */
package com.akh.java_concepts_test.ListInterfaceTest;

import java.util.Collections;
import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 16, 2012
 */
public class DataManager {
	Data dataObj = new Data();
	
	public List<Integer> getData(int start, int end){
		List<Integer> exportData = dataObj.getData().subList(start, end);
		System.out.println("Sublist : "+ exportData.toString());
		return exportData;
	}
	
	public static void main(String[] args){
		
		DataManager mgr = new DataManager();
		List<Integer> subList = mgr.getData(20,40);
		System.out.println("Sublist[0] : "+subList.get(0));
		
	}

}
