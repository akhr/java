package com.akh.hackerrank.medium;

public class CandyDistribution {

	public static void main(String[] args) {
		

	}
	
	static int distributeCandy(int[] score) {
		int length = score.length;
		int[] candyArr = new int[length];
		
		for(int i=0; i<length; i++){
			
			if(i==0){
				int compareRes = compare(score[i], score[i+1]);
				if( compareRes == 0){
					candyArr[i] = 1;
				}else if(compareRes < 0){
					candyArr[i] = 1;
				}else{
					candyArr[i] = 2;
				}
			}
			else if(i==length-1){
				int compareRes = compare(score[i-1], score[i]);
				if( compareRes == 0){
					candyArr[i] = 1;
				}else if(compareRes < 0){
					candyArr[i] = candyArr[i-1]+1;
				}else{
					candyArr[i] = 1;
				}
			}
			else{
				int leftCompareRes = compare(score[i-1], score[i]);
				int righCompareRes = compare(score[i], score[i+1]);
				
				if(leftCompareRes == 0 && righCompareRes == 0){
					candyArr[i] = 1;
				}else if(leftCompareRes < 0 && righCompareRes == 0){
					candyArr[i] = candyArr[i] + 1;
				}else if(leftCompareRes > 0 && righCompareRes == 0){
					candyArr[i] = 1;
				}else if(leftCompareRes == 0 && righCompareRes < 0){
					candyArr[i] = 1;
				}else if(leftCompareRes == 0 && righCompareRes > 0){
					candyArr[i] = 2;
				}else if(leftCompareRes < 0 && righCompareRes > 0){
					candyArr[i] = 2;
				}else if(leftCompareRes < 0 && righCompareRes < 0){
					candyArr[i] = 1;
				}else if(leftCompareRes > 0 && righCompareRes > 0){
					candyArr[i] = 1;
				}else if(leftCompareRes > 0 && righCompareRes < 0){
					candyArr[i] = 1;
				}else if(leftCompareRes < 0 && righCompareRes < 0){
					candyArr[i] = 1;
				}else if(leftCompareRes > 0 && righCompareRes < 0){
					candyArr[i] = 1;
				}else if(leftCompareRes < 0 && righCompareRes > 0){
					candyArr[i] = 1;
				}else if(leftCompareRes > 0 && righCompareRes > 0){
					candyArr[i] = 1;
				}
			}
		}
		
		int totalCandies = 0;
		for(int j=0; j<length; j++){
			totalCandies += candyArr[j];
		}

		return totalCandies;
    }
	
	private static int compare(int a, int b){
		if(a == b)
			return 0;
		else if(a < b)
			return -1;
		else
			return 1;
	}

}
