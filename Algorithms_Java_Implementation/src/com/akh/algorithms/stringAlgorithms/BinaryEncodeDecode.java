package com.akh.algorithms.stringAlgorithms;

public class BinaryEncodeDecode{

	public String[] decode(String encoded){

		int[] input = new int[encoded.length()];
		for(int i=0; i<encoded.length(); i++){
			input[i] = Character.getNumericValue(encoded.charAt(i));
		}

		String[] results = new String[2];
		int[] result = new int[input.length];
		//Assume p(0) = 0
		result[0] = 0;
		results[0] = calculateResult(input, result);

		result[0]=1;
		results[1] = calculateResult(input, result); 

		return results;
	}

	private String calculateResult(int[] input, int[] result)
	{
		for(int i=1; i<input.length; i++){
			int digit;
			if(i==1){
				digit =  input[i-1] - result[i-1];
			}else{
				digit =  input[i-1] - result[i-1] - result[i-2];
			}

			if(digit==0 || digit==1){
				result[i] = digit;
			}else{
				return "NONE";
			}
		}

		StringBuilder sB = new StringBuilder();
		for(int value : result){
			sB.append(value);
		}
		return sB.toString();
	}
	
	public static void main(String[] args){
		BinaryEncodeDecode binaryCode = new BinaryEncodeDecode();
		String[] results = binaryCode.decode("123210122");
		System.out.println("Result - 0 :"+results[0]);
		System.out.println("Result - 1 :"+results[1]);
	}
}
