package com.akh.algorithms.recursion;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 *  @fileName: LetterCasePermutation_784.java
 *  @author: Akhash Ramamurthy
 *  Created on: Oct 5, 2018
 *  
 *  Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

		Examples:
		Input: S = "a1b2"
		Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

		Input: S = "3z4"
		Output: ["3z4", "3Z4"]

		Input: S = "12345"
		Output: ["12345"]
		Note:

		S will be a string with length at most 12.
		S will consist only of letters or digits.
 */

public class LetterCasePermutation_784 {

	public List<String> letterCasePermutation_DFS_Recursive(String S){
		if(S == null)
			return new ArrayList<String>();

		//It will be PRE Order - munthiri kottai... So create result Object beforehand
		List<String> res = new ArrayList<>();
		helper_DFS_Recursive(S, res, 0);
		return res;
	}

	public void helper_DFS_Recursive(String S, List<String> res, int position) {
		if(position == S.length()) {
			res.add(S);
			return;
		}

		//Visit the node - Nothing to do

		char[] chars = S.toCharArray();

		//If !char then move to next position
		if(Character.isDigit(chars[position])) {
			helper_DFS_Recursive(S, res, position+1);
			return;
		}

		//Visit/Create left child - Lower case the char
		chars[position] = Character.toLowerCase(chars[position]);
		helper_DFS_Recursive(String.valueOf(chars), res, position+1);

		//Visit/Create right child - Upper case the char
		chars[position] = Character.toUpperCase(chars[position]);
		helper_DFS_Recursive(String.valueOf(chars), res, position+1);
	}

	public List<String> letterCasePermutation_DFS_Iterative(String S){
		if(S == null)
			return new ArrayList<String>();

		List<String> res = new ArrayList<>();
		Stack<String> stringStack = new Stack<>();
		Stack<Integer> positionStack = new Stack<>();

		stringStack.push(S);
		positionStack.push(0);

		while(!stringStack.isEmpty()) {
			//Visit the node - But doing nothing with node itself
			String poped = stringStack.pop();
			int position = positionStack.pop();
			if(position == S.length()) {
				//Do not add node to res until its a LEAF i.e., you examined all positions (0 --> S.length-1) 
				res.add(poped);
				continue;
			}

			char[] chars = poped.toCharArray();

			//If !char then move to next - put the poped String back into stack or else stack will be empty & will exit
			if(Character.isDigit(chars[position])) {
				stringStack.push(poped);
				positionStack.push(position+1);
				continue;
			}

			//Create right child
			chars[position] = Character.toUpperCase(chars[position]);
			stringStack.push(String.valueOf(chars));
			positionStack.push(position+1);

			//Create left child
			chars[position] = Character.toLowerCase(chars[position]);
			stringStack.push(String.valueOf(chars));
			positionStack.push(position+1);

		}
		return res;
	}

	public List<String> letterCasePermutation_BFS(String S){
		if(S == null)
			return new ArrayList<String>();

		List<String> res = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(S);
		
		//Runs for # of times = levels of tree  
		for(int i = 0; i < S.length(); i++) {
			if(Character.isDigit(S.charAt(i)))
				continue;
			
			int size = queue.size();
			for(int j = 0; j < size; j++) {
				String polled = queue.poll();
				
				char[] chars = polled.toCharArray();
				
				chars[i] = Character.toLowerCase(chars[i]);
				queue.offer(String.valueOf(chars));
				
				chars[i] = Character.toUpperCase(chars[i]);
				queue.offer(String.valueOf(chars));
			}
		}
		
		//After running FOR for S.length Queue contains only LEAF nodes - Copy over the leaf nodes to res
		res.addAll(queue);
		return res;
	}
	
	
	//=============================================  Recursive Test ============================================= 
	@Test
	public void test_DFS_R_1() {
		String S = "abc";
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_R_2() {
		String S = "a1b2";
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"a1b2", "a1B2", "A1b2", "A1B2"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_R_3() {
		String S = "3z4";
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"3z4", "3Z4"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_R_4() {
		String S = "12345";
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"12345"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_R_EmptyString() {
		String S = "";
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {""};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_R_NullString() {
		String S = null;
		List<String> actualsList = letterCasePermutation_DFS_Recursive(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	//=============================================  Iterative Test ============================================= 
	@Test
	public void test_DFS_I_1() {
		String S = "abc";
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_I_2() {
		String S = "a1b2";
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"a1b2", "a1B2", "A1b2", "A1B2"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_I_3() {
		String S = "3z4";
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"3z4", "3Z4"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_I_4() {
		String S = "12345";
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"12345"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_I_EmptyString() {
		String S = "";
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {""};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_DFS_I_NullString() {
		String S = null;
		List<String> actualsList = letterCasePermutation_DFS_Iterative(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {};
		assertArrayEquals(expecteds, actuals);
	}
	
	//=======================================================  BFS Test ============================================= 
	@Test
	public void test_BFS_1() {
		String S = "abc";
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_BFS_2() {
		String S = "a1b2";
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"a1b2", "a1B2", "A1b2", "A1B2"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_BFS_3() {
		String S = "3z4";
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"3z4", "3Z4"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_BFS_4() {
		String S = "12345";
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {"12345"};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_BFS_EmptyString() {
		String S = "";
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {""};
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void test_BFS_NullString() {
		String S = null;
		List<String> actualsList = letterCasePermutation_BFS(S);
		String[] actuals = actualsList.toArray(new String[actualsList.size()]); 
		System.out.println("Output : "+Arrays.toString(actuals));
		String[] expecteds = {};
		assertArrayEquals(expecteds, actuals);
	}
}
