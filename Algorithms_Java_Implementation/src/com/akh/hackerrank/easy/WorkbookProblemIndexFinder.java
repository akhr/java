/**
 * 
 */
package com.akh.hackerrank.easy;

import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * May 8, 2016 5:09:45 PM
 * WorkbookProblemIndexFinder.java
 */
public class WorkbookProblemIndexFinder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int chapters = in.nextInt();
		int maxProbs = in.nextInt();
		int bookPageIndex = 0;
		int magicProbs = 0;
		System.out.println("Chapters : "+chapters);
		System.out.println("Max Probs : "+maxProbs);
		for(int i=0; i<chapters; i++){
			int probsInChapter = in.nextInt();
			if(probsInChapter <= maxProbs){
				bookPageIndex++;
				if(isPageAndProbIndexMatch(bookPageIndex, 1, probsInChapter))
					magicProbs++;
			}else{
				int pageCount = probsInChapter / maxProbs;
				if(probsInChapter % maxProbs != 0)
					pageCount += 1;

				for(int j=0; j<pageCount; j++){
					bookPageIndex++;
					int probIndexStart = getProbStartIndex(j, maxProbs);
					int probIndexEnd = getProbEndIndex(j, maxProbs, probsInChapter, j==pageCount-1);
					if(isPageAndProbIndexMatch(bookPageIndex, probIndexStart, probIndexEnd))
						magicProbs++;
				}
			}
			System.out.println("Problem is "+ (i+1) +"th Chapter : "+probsInChapter);
		}
		System.out.println("Total Pages of Book : "+bookPageIndex);
		System.out.println("Magic Problems In Book : "+magicProbs);
	}

	private static boolean isPageAndProbIndexMatch(int pageIndex, int probIndexStart, int probIndexEnd){
		if(pageIndex == probIndexStart || pageIndex == probIndexEnd || 
				(pageIndex > probIndexStart && pageIndex < probIndexEnd))
			return true;
		return false;
	}

	private static int getProbStartIndex(int chapterPageIndex, int maxProbsInAPage){
		return (maxProbsInAPage*chapterPageIndex)+1;
	}

	private static int getProbEndIndex(int chapterPageIndex, int maxProbsInAPage, int probsInChap, boolean isLastPage){
		if(isLastPage){
			return probsInChap;
		}
		return (maxProbsInAPage*chapterPageIndex)+maxProbsInAPage;
	}
}
