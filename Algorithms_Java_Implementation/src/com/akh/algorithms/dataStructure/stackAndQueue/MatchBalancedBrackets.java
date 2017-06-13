/**
 * 
 */
package com.akh.algorithms.dataStructure.stackAndQueue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Akhash Ramamurthy
 * Jan 10, 2017
 */
public class MatchBalancedBrackets {

	public static void main(String[] args) {
		String input = "{9*5[(79-1)/2(1*3)]}(((({wertwe{{[556&$45232fdg()45]fd}}ewf})456))){}";
		System.out.println("Is Matching = "+areBracketsMatched(input));

	}

	private static boolean areBracketsMatched(String input){
		char[] expr = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		try{
			for(char c : expr){
				if(c=='(' || c=='[' || c=='{'){
					stack.push(c);
				}
				switch(c){
				case ')' : 
					if(stack.peek()!='(')
						return false;
					else
						stack.pop();
					break;
				case ']' : 
					if(stack.peek()!='[')
						return false;
					else
						stack.pop();
					break;
				case '}' : 
					if(stack.peek()!='{')
						return false;
					else
						stack.pop();
					break;
				default:
					break;
				}
			}
		}catch(EmptyStackException e){
			return false;
		}
		return true;
	}

}
