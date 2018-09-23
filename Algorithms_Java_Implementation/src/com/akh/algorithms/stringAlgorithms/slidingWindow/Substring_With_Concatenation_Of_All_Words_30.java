package com.akh.algorithms.stringAlgorithms.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @fileName: Substring_With_Concatenation_Of_All_Words_30.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 21, 2018
 */

public class Substring_With_Concatenation_Of_All_Words_30 {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if(s == null | s.length()<=0 || words==null || words.length==0)
			return res;

		Map<Character, Integer> charsToFind = new HashMap<>();
		Map<String, Integer> wordsToFind = new HashMap<>();
		int requiredCharsCount = 0;

		for(String word: words) {
			wordsToFind.put(word, wordsToFind.getOrDefault(word, 0)+1);
		}
		
		//Load charsTofindMap and get requriedCharsCnt
		requiredCharsCount = loadCharsToFindMap(charsToFind, words);
			
		int left, right;
		left = right = 0;
		int foundCharsCount = 0;
		int wL = words[0].length(); //All words are of same length

		while(right < s.length()) {
			char expandChar = s.charAt(right);
			if(charsToFind.containsKey(expandChar) && charsToFind.get(expandChar) > 0) {
				foundCharsCount++;
				charsToFind.put(expandChar, charsToFind.getOrDefault(expandChar, 0)-1);
				++right;
			}else {
				
				//Restart Window
				//Unwanted char || Wanted char but count more than required. .
				left = ++right;
				foundCharsCount = 0;
				loadCharsToFindMap(charsToFind, words);
			}
			
			if(foundCharsCount == requiredCharsCount && (right-left) == requiredCharsCount) {
				String window = s.substring(left, right);
				if(isValidWindow(window, wordsToFind, words.length, wL))
					res.add(left);
				
				//Restart Window
				left = right; 
				foundCharsCount = 0;
				loadCharsToFindMap(charsToFind, words);
			}
		}
		return res;
	}
	
	private boolean isValidWindow(String window, Map<String, Integer> wordsToFind, int wordsCnt, int wordSize) {

		int i = 0;
		int foundWordsCnt = 0;
		while(i < window.length()) {
			String windowWord = window.substring(i, i+wordSize);
			if(wordsToFind.containsKey(windowWord)) foundWordsCnt++;
			i += wordSize;
		}
		return foundWordsCnt == wordsCnt;
	}
	
	private int loadCharsToFindMap(Map<Character, Integer> charsToFind, String[] words) {
		int requiredCharsCount = 0;
		for(String word: words) {
			for(char c : word.toCharArray()) {
				charsToFind.put(c, charsToFind.getOrDefault(c, 0)+1);
				requiredCharsCount++;
			}
		}
		return requiredCharsCount;
	}

}
