/**
 * 
 */
package com.thesaka.topcoder.div1;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 6, 2016 10:08:57 AM
 * ExplodingRobots.java
 */
public class ExplodingRobots {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Result for (1,0) & (2,0) With U : "+canExplode(1, 0, 2, 0, "U"));	

	}

	private static String EXPLOSION = "Explosion";
	private static String SAFE = "Safe";

	public static String canExplode(int x1, int y1, int x2, int y2, String instructions){

		int left,right,up,down;
		left=right=up=down=0;

		for(char c:instructions.toCharArray()){
			switch (c) {
			case 'L': left++;break;
			case 'R': right++;break;
			case 'U': up++;break;
			case 'D': down++;break;
			}
		}

		//Find if R2 is to right/top (Q1) of R2
		if(x2 >= x1 && y2 >= y1){
			if(x1+right >= x2-left && y1+up >= y2-down)
				return EXPLOSION;
		}

		//Find if R2 is to left/top (Q2) of R2
		if(x2 <= x1 && y2 >= y1){
			if(x2+right >= x1-left && y1+up >= y2-down)
				return EXPLOSION;
		}

		//Find if R2 is to left/bottom (Q3) of R2
		if(x2 <= x1 && y2 <= y1){
			if(x2+right >= x1-left && y2+up >= y1-down)
				return EXPLOSION;
		}

		//Find if R2 is to right/bottom (Q4) of R2
		if(x2 >= x1 && y2 <= y1){
			if(x1+right >= x2-left && y2+up >= y1-down)
				return EXPLOSION;
		}


		return SAFE;
	}

}
