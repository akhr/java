package com.akh.topcoder.div2_lower;

public class DanceCourse {

	public DanceCourse() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = new int[]{10,20,5,2,9,3,1};
		System.out.print("Input = ");
		printArray(input);
		System.out.println("\n");
		System.out.println("Result = "+minimum(5, input));
	}

	public static int minimum(int K, int[] danceCost) {
		int res = 0;

		for(int i=0; i<danceCost.length; i++){
			for(int j=0; j<K; j++){
				if(danceCost[i]<danceCost[j]){
					swap(danceCost, i, j);
				}
			}

		}
		
		System.out.print("Output =");
		printArray(danceCost);
		
        for(int i=0; i<K; i++){
        	res += danceCost[i];
        }
		
		return res;
	}

	private static int[] swap(int[] input, int i, int j){
		
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
		return input;
	}
	
	private static void printArray(int[] input){
		for (int i = 0; i < input.length; i++) {
			System.out.print("\t"+input[i]);
		}
	}

}
