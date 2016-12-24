package com.akh.algorithms;

import java.util.Scanner;

public class SpreadSheetProblem {

	private int[] columns;
	private int[] helperArray;
	private int columnCount = 0;
	private int totalSize = 0;

	public static void main(String[] args) {
		SpreadSheetProblem spreadSheetProblem = new SpreadSheetProblem(new int[]{8,2,10,10});
		Scanner reader = new Scanner(System.in);  
		while(true){
			System.out.println("Enter a click coordinate: ");
			int n = reader.nextInt();
			System.out.println("Click("+n+") - "+spreadSheetProblem.click2(n));
		}
	}

	public SpreadSheetProblem(int[] columns){
		this.columns = columns;
		this.columnCount = columns.length;
		for(int column : columns){ //O(n)
			totalSize += column;
		}
		helperArray = preProcess(columns);
	}

	private int click(int pixelcooordinate){
		int result = -1;
		int processedWidth = 0;

		if(pixelcooordinate<0 || pixelcooordinate>totalSize)
			result = -1;

		for(int i=0; i<columnCount; i++){ //O(n)
			int start;
			int end;
			if(i==0){
				start = 0;
				end = columns[i];
				if(checkIfInRange(start, end, pixelcooordinate))
					result = i;
			}else if(i==columnCount-1){
				start = totalSize - columns[columnCount-1];
				end = totalSize;
				if(checkIfInRange(start, end, pixelcooordinate))
					result = i;
			}else{
				start = processedWidth;
				end = processedWidth+columns[i];
				if(checkIfInRange(start, end, pixelcooordinate))
					result = i;
			}
			processedWidth += columns[i];
		}
		return result;
	}
	
	private int[] preProcess(int[] input){
		int[] helperArray = new int[input.length];
		helperArray[0] = input[0];
		for(int i=1; i<input.length; i++){
			helperArray[i]=input[i]+helperArray[i-1];
		}
		return helperArray;
	}
	
	private int click2(int pixel){
		int result = -1;
		if(pixel<0 || pixel>totalSize)
			result = -1;
		result = binarySearch(helperArray, 0, helperArray.length-1, pixel);
		return result;	
	}
	
	private int binarySearch(int[] array, int start, int end, int search){
		
		int middle = (start+end)/2;
		
//		if(start-end == 1 || start-end == -1){
			//if()
//		}
		
		if(start > end)
			return -1;
		
		if(search == array[middle])
			return middle;
		else if(search < array[middle])
			return binarySearch(array, start, middle-1, search);
		else
			return binarySearch(array, middle+1, end, search);
	}
	

	private boolean checkIfInRange(int start, int end, int pixel){
		if(pixel>=start && pixel<=end)
			return true;
		return false;
	}

}
