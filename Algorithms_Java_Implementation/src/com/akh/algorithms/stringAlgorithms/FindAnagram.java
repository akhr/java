/**
 * 
 */
package com.akh.algorithms.stringAlgorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akhashr
 *
 */
public class FindAnagram {

	public static void main(String[] args) {
		System.out.println("isAnagram = "+ isAnagram("abcd", "adbc"));

	}

	public static boolean isAnagram(String a, String b){

		if(a.length() != b.length())
			return false;

		Map<String, Integer> map = new HashMap<String, Integer>();;    
		for(int i=0; i<b.length(); i++){
			if(map.containsKey(b.charAt(i)))
				map.get(b.charAt(i));
			else{
				char[] cArr = new char[1];
				cArr[0] = b.charAt(i);
				map.put(cArr.toString(),1);    
			}   
		}

		for(int j=0; j<a.length(); j++){
			if(map.containsKey(a.charAt(j)) && map.get(a.charAt(j))>0){
				map.get(a.charAt(j));    
			}else
				return false;
		} 
		return true;
	} 

}
