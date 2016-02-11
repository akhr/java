package com.thesaka.topcoder.div2_lower;

/**
 * 
 * @author Akhash Ramamurthy
 * 
 * A store sells M different items, conveniently numbered 0 through M-1. 
 * For a shopping survey you interviewed N customers. 
 * Each customer responded to the survey with a list of items they've bought. 
 * Each customer bought at most one of each item. 
 * It is possible that some customers did not buy anything at all.
 * After collecting the responses, you've summed up the results and found that s[i] people have bought item i. 
 * Due to an unfortunate accident, you've then lost the actual survey responses. 
 * All you have left are the values s[i] you computed.
 * You are now supposed to report the number of big shoppers among the survey respondents. 
 * A big shopper is defined as a customer who has bought K or more items. 
 * Of course, having lost the detailed responses, you might be unable to determine the actual number of big shoppers.
 * You are given the ints N and K, and the int[] s with M elements. 
 * Compute and return the smallest possible number of big shoppers.
 *
 */

public class ShoppingSurvey {
	
		public static void main(String[] args){
			
		}

		public int minValue(int N, int K, int[] s)
		{
			int minBigShoppers = 0;
			
			for(int i=0; i<s.length; i++){
				if(s[i] >= K)
					minBigShoppers++;
			}
			return minBigShoppers;	
		}
		
}
