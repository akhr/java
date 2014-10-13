/**
 * 
 */
package com.example.algo.math;

import java.util.StringTokenizer;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Aug 22, 2012
 */
public class FindShortestStringContainingAPattern {

	/**
	 * Given a large document and a short pattern consisting of a few words (eg. W1 W2 W3), 
	 * find the shortest string that has all the words in any order 
	 * (for eg. W2 foo bar dog W1 cat W3 -- is a valid pattern)
	 * 
	 * Proposed Solution:
	 * -----------------
	 * min_len = infinity;
	 * most_recent_pos[n] = -1;
	 * foreach word in document 
		   int sequenceStart = min (the most recent position of all words in pattern except the current word)
   	 * int curr_len = pos of curr word - sequenceStart
   	 * if curr_len < min_len min_len = curr_len
   	 * most_recent_pos[current word] = position of current word
	 * 
	 */
	public static void main(String[] args) {
		String input = new String("Cat ramp jump july free dog ramp cat you seen dog pattern refresh ram lock key value list dog collection " +
				"performance ram");
//		String patternToFind = new String("cat dog ram");
		String patternToFind = new String("cat dog ram ");
//		String patternToFind = new String(" cat dog ram");
		findShortestString(input, patternToFind);
		
//		System.out.println( "Shortest String : "+findShortestString(input, patternToFind));

	}
	
	private static void findShortestString(String input, String patternToFind){
		patternToFind = patternToFind.trim();
		String result = null;
		String[] tokens = new String[(int)Math.floor(patternToFind.length()/2)];
		int fromIndex = 0;
		int toIndex = 0;
		int counter = 0;
		
		while(toIndex < patternToFind.length()){
			toIndex = patternToFind.indexOf(" ", fromIndex)==-1 ? patternToFind.length() : patternToFind.indexOf(" ", fromIndex); 
			tokens[counter] = patternToFind.substring(fromIndex, toIndex).trim();
			fromIndex = patternToFind.indexOf(" ", fromIndex)+1;
			counter++;
		}
		
		for(String token : tokens)
			System.out.println("Token : "+ token);
		
/*		for(int i=0; i<charArray.length; i++){
			if(charArray[i] != " ")
		}
		String[] patternTokens = patternTokens.
		
		
		return result;*/
	}
	

}
