package com.ak.algorithms.sorting;

public class MergeSort_Adv {
	
	private int[] inputArray;
	private int[] helperArray;
	
	public MergeSort_Adv(int[] input) {
		this.inputArray = input;
		this.helperArray = new int[input.length];
	}
	
	public static void sort(int[] input){
		MergeSort_Adv mergeSort_Adv = new MergeSort_Adv(input);
		mergeSort_Adv.mergeSort(0, input.length-1);
	}
	
	private void mergeSort(int left, int right){
		if(left<right){
			
			for(int printCount=left; printCount<=right; printCount++)
				System.out.println("MergeSort_Adv:  Elements are == > "+inputArray[printCount]);
			
			int middle = (int)(left+right)/2;
			mergeSort(left, middle);
			mergeSort(middle+1, right);
			merge(left, middle, right);
		}
	}
	
	private void merge(int left, int middle, int right){
		
		for(int printCount=left; printCount<=middle; printCount++)
			System.out.println("MergeSort_Adv: Elements in LeftArray == > "+inputArray[printCount]);

		for(int printCount=middle+1; printCount<=right; printCount++)
			System.out.println("MergeSort_Adv: Elements in RightArray == > "+inputArray[printCount]);
		
		int leftIndex = left;
		int rightIndex = middle+1;
		int helperIndex = left;    //Important
		
		while(leftIndex<=middle && rightIndex<=right){
			if(inputArray[leftIndex]<inputArray[rightIndex]){
				helperArray[helperIndex++] = inputArray[leftIndex++];
			}else{
				helperArray[helperIndex++] = inputArray[rightIndex++];
			}
			
		}
		
		while(leftIndex<=middle){
			helperArray[helperIndex++] = inputArray[leftIndex++];
		}
		
		while(rightIndex<=right){
			helperArray[helperIndex++] = inputArray[rightIndex++];
		}
		
		System.out.println("Merge STEP COMPLETED MERGED Array == > ");
		int i=left;
		while(i<helperIndex){
			System.out.println(helperArray[i]);
			inputArray[i] = helperArray[i];
			i++;
		}
		
		
	}
	

}
