/**
 * 
 */
package com.thesaka.topcoder.div1;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 6, 2016 9:07:59 AM
 * CoinFlipsDiv2.java
 */
public class CoinFlipsDiv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test1 = "HHHTTTHHHTTTHTHTH";
		int result = countCoins(test1);
		System.out.println("Input = "+test1 +"  -  Result = "+result);
	}

	static int countCoins(String state){
		int result = 0;
		char[] charArr = state.toCharArray();
		char prev, curr, next;
		for(int i=0; i<charArr.length; i++){
			if(i>0)
				prev = charArr[i-1];
			else
				prev = 'A';
			curr = charArr[i];
			if(i<charArr.length-1)
				next = charArr[i+1];
			else
				next ='A';
			if(checkIfInteresting(prev, curr, next)){
				result++;
			}
		}
		return result;
	}

	static boolean checkIfInteresting(char prev, char curr, char next){
		if((prev != 'A' && prev != curr) || (next != 'A' && curr != next))
			return true;
		else
			return false;
	}

}
