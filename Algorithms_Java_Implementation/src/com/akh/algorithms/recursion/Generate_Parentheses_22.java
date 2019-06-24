package com.akh.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  @fileName: Generate_Parentheses_22.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 16, 2018
 */

public class Generate_Parentheses_22 {
	
	public List<String> generateParenthesis(int n) {
		if(n <= 0)
			return new ArrayList<String>(Arrays.asList(""));
		
		List<String> res = new ArrayList<>();
		StringBuilder tempSB = new StringBuilder();
		tempSB.append("(");
		dfs_recursive(n, 0, tempSB, res);
		return res;
	}
	
	private void dfs_recursive(int n, int pos, StringBuilder tempSB, List<String> res){
		
		if(pos == (n*2)-1){ //Leaf node
			res.add(tempSB.toString());
			return;
		}
		
		if(pos <= n-1){
			tempSB.append("(");
			dfs_recursive(n, pos+1, tempSB, res);
			tempSB.deleteCharAt(tempSB.length()-1);
		}
		
		tempSB.append(")");
		dfs_recursive(n, pos+1, tempSB, res);
		tempSB.deleteCharAt(tempSB.length()-1);
		
	}
}
