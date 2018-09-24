package com.akh.algorithms.stringAlgorithms.slidingWindow;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 *  @fileName: Substring_With_Concatenation_Of_All_Words_30.java
 *  @author: Akhash Ramamurthy
 *  Created on: Sep 21, 2018
 *  
 * 		You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

		Example 1:

		Input:
		  s = "barfoothefoobarman",
		  words = ["foo","bar"]
		Output: [0,9]
		Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
		The output order does not matter, returning [9,0] is fine too.
		Example 2:

		Input:
		  s = "wordgoodstudentgoodword",
		  words = ["word","student"]
		Output: []
 */

public class Substring_With_Concatenation_Of_All_Words_30 {

/*	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> res = new ArrayList<>();
		if(s == null | s.length()<=0 || words==null || words.length==0)
			return res;

		Map<String, Integer> wordsToFind = new HashMap<>();
		int wL = words[0].length(); //Because all words are of same length
		for(String word: words) {
			if(word.length() != wL) //All words shd be of equal length else return
				return res;
			wordsToFind.put(word, wordsToFind.getOrDefault(word, 0)+1);
		}

		int left, right;
		left = right = 0;
		int requiredWordsCount = 0;

		while((right+wL)<=s.length()){
			String expandWord = s.substring(right, right+wL);
			if(wordsToFind.containsKey(expandWord)){
				if(wordsToFind.get(expandWord) > 0){
					requiredWordsCount++;
				}
				wordsToFind.put(expandWord, wordsToFind.get(expandWord)-1);
				right += wL;
			}else{
				right++;
			}

			while(left < right && requiredWordsCount == words.length){
				String shrinkWord = s.substring(left, left+wL);
				if(wordsToFind.containsKey(shrinkWord)){
					if(wordsToFind.get(shrinkWord) == 0){
						requiredWordsCount--;
					}
					wordsToFind.put(shrinkWord, wordsToFind.get(shrinkWord)+1);
				}

				if(s.substring(left, right).length() == (words.length*wL))
					res.add(left);
				left++;
			}
		}
		return res;
	}*/

	public List<Integer> findSubstring(String s, String[] words){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(s==null||s.length()==0||words==null||words.length==0){
			return result;
		} 

		//frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String w: words){
			if(map.containsKey(w)){
				map.put(w, map.get(w)+1);
			}else{
				map.put(w, 1);
			}
		}

		int len = words[0].length();

		for(int j=0; j<len; j++){
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
			int start = j;//start index of start
			int count = 0;//count totoal qualified words so far

			for(int i=j; i<=s.length()-len; i=i+len){
				String sub = s.substring(i, i+len);
				if(map.containsKey(sub)){
					//set frequency in current map
					if(currentMap.containsKey(sub)){
						currentMap.put(sub, currentMap.get(sub)+1);
					}else{
						currentMap.put(sub, 1);
					}

					count++;

					while(currentMap.get(sub)>map.get(sub)){
						String left = s.substring(start, start+len);
						currentMap.put(left, currentMap.get(left)-1);

						count--;
						start = start + len;
					}


					if(count==words.length){
						result.add(start); //add to result

						//shift right and reset currentMap, count & start point         
						String left = s.substring(start, start+len);
						currentMap.put(left, currentMap.get(left)-1);
						count--;
						start = start + len;
					}
				}else{
					currentMap.clear();
					start = i+len;
					count = 0;
				}
			}
		}

		return result;
	}

	@Test
	public void test_1(){
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		int[] expected = {0,9};
		int[] actual = findSubstring(s, words).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test_2(){
		String s = "wordgoodstudentgoodword";
		String[] words = {"word","student"};
		int[] expected = {};
		int[] actual = findSubstring(s, words).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test_3(){
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo","barr","wing","ding","wing"};
		int[] expected = {13};
		int[] actual = findSubstring(s, words).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test_4(){
		String s = "aaaaaa";
		String[] words = {"aaa","aaa"};
		int[] expected = {0};
		int[] actual = findSubstring(s, words).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test_5(){
		String s = "aaaaaaaa";
		String[] words = {"aa","aa", "aa"};
		int[] expected = {0,1,2};
		int[] actual = findSubstring(s, words).stream().mapToInt(i->i).toArray();
		assertArrayEquals(expected, actual);
	}

}
