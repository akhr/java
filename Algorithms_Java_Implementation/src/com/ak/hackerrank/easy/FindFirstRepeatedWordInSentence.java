/**
 * 
 */
package com.ak.hackerrank.easy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * May 8, 2016 9:10:06 PM
 * Solution.java
 */
public class FindFirstRepeatedWordInSentence {

	public static void main(String[] args) throws IOException{
/*        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("temp.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
        String res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        
        res = firstRepeatedWord(_s);
        bw.write(res);
        bw.newLine();
        
        bw.close();*/
		
		String input = "He had had enough of this nonsense";
		String output = firstRepeatedWord(input);
		System.out.println("Input :"+input);
		System.out.println("Output :"+output);
    }
	
	private static String firstRepeatedWord(String originalString){
		String[] strArr = originalString.split("[^\\w']+");
		List<String> list = new ArrayList<String>(strArr.length);
		String result = null;
		for(int i=0; i<strArr.length; i++){
			if(list.contains(strArr[i])){
					result = strArr[i];
					break;
			}else
				list.add(strArr[i]);
		}
		return result;
	}

}
