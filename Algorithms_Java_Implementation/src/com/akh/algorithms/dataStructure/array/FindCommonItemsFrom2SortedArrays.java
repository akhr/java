/**
 * 
 */
package com.akh.algorithms.dataStructure.array;

/**
 * @author Akhash Ramamurthy
 * Apr 27, 2017
 */
public class FindCommonItemsFrom2SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,9,10,12,15,21};
		int[] b = new int[]{4,7,8,10,11,12,21};
		System.out.println("MatchCount = "+getCommonItemsCount(a, b));
	}
	
	private static int getCommonItemsCount(int[] a, int[] b){
		int[] startArray;
		int[] otherArray;
		if(Math.min(a[0], b[0]) == a[0]){
			startArray = a;
			otherArray = b;
		}else{
			startArray = b;
			otherArray = a;
		}
		
		int sIndex = 0;
		int oIndex = 0;
		int matchCount = 0;
		
		while(sIndex < startArray.length && oIndex < otherArray.length){
			if(startArray[sIndex] == otherArray[oIndex]){
				matchCount++;
				sIndex++;
				oIndex++;
			}else if(startArray[sIndex] < otherArray[oIndex]){
				sIndex++;
			}else{
				oIndex++;
			}
		}
		return matchCount;
	}

}
