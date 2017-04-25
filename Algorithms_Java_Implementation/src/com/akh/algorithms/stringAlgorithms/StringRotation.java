package com.akh.algorithms.stringAlgorithms;

import java.util.Scanner;

public class StringRotation {

	public static void main(String[] args) {
		/*canner scanner=new Scanner(System.in);
		int testCaseCount=scanner.nextInt();
//		String q=scanner.nextLine();
		for(int testCaseIndex=0; testCaseIndex<testCaseCount; testCaseIndex++)
		{
			String str1=scanner.nextLine();
			String str2=scanner.nextLine();
			System.out.println(compare(str1,str2));
		}*/

		System.out.println("O/p = "+compare(0, "geeksforgeeks", "geeksgeeksfo1", 0));
	}
	
	private static int compare(int recursiveCount, String s1, String s2, int rotateCount){
		if(recursiveCount == s1.length())
			return 0;
		
		if(s1.length() != s2.length())
			return 0;
		if(s1.equalsIgnoreCase(s2)){
			return 1;
		}else{
			s1 = rotate(s1, rotateCount);
			return compare(++recursiveCount, s1, s2, 1);
		}
	}
	
	private static String rotate(String str, int count){
		if(count == 0)
			return str;
		
		StringBuilder sB = new StringBuilder();
		sB.append(str.substring(count, str.length()));
		sB.append(str.substring(0, count));
		System.out.println("Rotated Str for "+str+" by "+count+" = "+sB.toString());
		return sB.toString();
	}

}
