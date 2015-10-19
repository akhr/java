/**
 * 
 */
package com.thesaka.topcoder.div1;

/**
 * @author akhash
 *
 */
public class MaxRectangularAreaFinderFromMatrix {

	public static void main(String[] args) {
		System.out.println("Res = "+maxArea(4,4,10));

	}

	public static long maxArea(int w, int h, int m){
		long maxArea = Integer.MIN_VALUE;

		for(long newWidth= w; newWidth>0; newWidth--){
			long tempHeigth = m/newWidth;
			long newHeigth = Math.min(tempHeigth, h);
			maxArea = Math.max(newHeigth*newWidth , maxArea);
		}
		return maxArea;
	}

}
