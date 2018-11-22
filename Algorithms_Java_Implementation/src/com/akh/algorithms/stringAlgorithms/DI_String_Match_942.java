/**
 * @fileName: DI_String_Match_942.java
 * @author: Akhash Ramamurthy
 * @CreatedOn: Nov 21, 2018
 * 
 */
package com.akh.algorithms.stringAlgorithms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


/**
 * @fileName: DI_String_Match_942.java
 * @author: Akhash Ramamurthy
 * @Created on: Nov 21, 2018
 * 
 */
public class DI_String_Match_942 {
	
	public int[] diStringMatch_2(String S) {
		int N = S.length();
		int lo = 0;
		int hi = N;
		int[] ans = new int[N+1];
		for(int i = 0; i < N; i++) {
			if(S.charAt(i) == 'I') {
				ans[i] = lo++;
			}else if(S.charAt(i) == 'D') {
				ans[i] = hi--;
			}
		}
		ans[N] = lo;
		return ans;
	}

	@Test
	public void t_1() {
		String S = "IDID";
		int[] expecteds = {0,4,1,3,2};
		assertArrayEquals(expecteds, diStringMatch_2(S));
	}
	
	@Test
	public void t_2() {
		String S = "III";
		int[] expecteds = {0,1,2,3};
		assertArrayEquals(expecteds, diStringMatch_2(S));
	}
	
	@Test
	public void t_3() {
		String S = "DDI";
		int[] expecteds = {3,2,0,1};
		assertArrayEquals(expecteds, diStringMatch_2(S));
	}
	
	
	//*********************   CONVULTED   **************************//
	private enum DIR {		
		ID("I", "D", 'R'),
		II("I", "I", 'L'), 
		DD("D", "D", 'R'),
		DI("D", "I", 'L');

		private DIR(String fir, String sec, char direction) {
			this.first = fir;
			this.second = sec;
			this.direction = direction;
		}

		public static DIR getDir(char f, char s) {
			if(f == 'I' && s == 'D')
				return ID;
			if(f == 'I' && s == 'I')
				return II;
			if(f == 'D' && s == 'D')
				return DD;
			if(f == 'D' && s == 'I')
				return DI;
			return null;
		}

		private String first;
		private String second;
		private char direction;

	}

	public int[] diStringMatch(String S) {
		int left = 0;
		int right = S.length();
		int[] res = new int[S.length()+1];
		int resIndx = 0;

		char[] tokens = S.toCharArray();
		if(tokens[0] == 'I') {
			res[resIndx++] = left++;
		}else {
			res[resIndx++] = right--;
		}

		for(int i = 0; i<tokens.length-1; i++) {
			DIR dir = DIR.getDir(tokens[i], tokens[i+1]);
			if(dir.direction == 'L') {
				res[resIndx++] = left++;
			}
			if(dir.direction == 'R') {
				res[resIndx++] = right--;
			}
		}

		if(left == right) {
			res[resIndx] = left;
		}
		return res;
	}
}
