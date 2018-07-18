package com.akh.algorithms.dataStructure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *  @fileName: SumOfCubesOfAplusBEqualsCplusD.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 15, 2018
 *  Print all a^3 + b^3 = c^3 + d^3 for all 1 < a,b,c,d < 1000
 */

public class SumOfCubesOfAplusBEqualsCplusD {

	public static class Operand{
		private int x;
		private int y;

		public Operand(int x, int y){
			this.x = x;
			this.y = y;
		}

		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
	}

	
	//========================================================================================================================================//
	//Brute-force O(N^4)
	public static void printAllCombinations_brute(int upperLimit){	
		System.out.println("\n\n\n//Brute-force O(N^4)");

		int counter = 0;
		for(int i=1; i<=upperLimit; i++){
			for(int j=1; j<=upperLimit; j++){
				for(int k=1; k<=upperLimit; k++){
					for(int l=1; l<=upperLimit; l++){
						double iAndJ = Math.pow(i, 3) + Math.pow(j, 3);
						double kAndL = Math.pow(k, 3) + Math.pow(l, 3);
						if(iAndJ == kAndL){
							counter++;
							System.out.println("For Sum = "+(int)iAndJ+"  ---> a = "+i+" b = "+j+"  <---->  c = "+k+" d = "+l);
						}
					}
				}
			}
		}
		System.out.println("No of combinations : "+counter);
	}

	
	
	//========================================================================================================================================//
	//Optimized O(N^2)
	public static void printAllCombinations_optimized_1(int upperLimit){	
		System.out.println("\n\n\n//Optimized O(N^2)");

		//find a and b combinations and store result in a HashMap
		Map<Double, List<Operand>> resultMap = new HashMap<Double, List<Operand>>();
		int counter = 0;

		for(int a=1; a<=upperLimit; a++){
			for(int b=1; b<=upperLimit; b++){
				double sum = Math.pow(a, 3) + Math.pow(b, 3);
				if(resultMap.containsKey(sum)){
					resultMap.get(sum).add(new Operand(a,  b));
				}else{
					List<Operand> list = new ArrayList<>();
					list.add(new Operand(a, b));
					resultMap.put(sum, list);
				}
			}
		}

		//Check if c and d combination results are in the a&b map. When you find print all 4 
		for(int c=1; c<=upperLimit; c++){
			for(int d=1; d<=upperLimit; d++){
				double sum = Math.pow(c, 3) + Math.pow(d, 3);
				List<Operand> aAndBs = resultMap.get(sum);
				for(Operand aAndB : aAndBs){
					counter++;
					System.out.println("For Sum = "+(int)sum+"  ---> a = "+aAndB.getX()+" b = "+aAndB.getY()+"  <---->  c = "+c+" d = "+d);
				}
			}
		}
		System.out.println("No of combinations : "+counter);
	}

	
	//========================================================================================================================================//
	//Optimized O(N^2)
	public static void printAllCombinations_optimized_2(int upperLimit){	
		System.out.println("\n\n\n//More Optimized O(N^2)");

		//find a and b combinations and store result in a HashMap
		Map<Double, List<Operand>> resultMap = new HashMap<Double, List<Operand>>();
		int counter = 0;

		for(int a=1; a<=upperLimit; a++){
			for(int b=1; b<=upperLimit; b++){
				double sum = Math.pow(a, 3) + Math.pow(b, 3);
				if(resultMap.containsKey(sum)){
					resultMap.get(sum).add(new Operand(a,  b));
				}else{
					List<Operand> list = new ArrayList<>();
					list.add(new Operand(a, b));
					resultMap.put(sum, list);
				}
			}
		}

		// No need to calculate the pairs once again for C and D. Since A and B are calculated
		// from the same range of nos 1 to 1000 - meaning we have calculated C and D already.
		// So just iterate through resultsMap and print 
		for(Entry<Double, List<Operand>> entry : resultMap.entrySet()){
			double sum = entry.getKey();
			for(Operand pair1 : entry.getValue()){
				for(Operand pair2 : entry.getValue()){
					counter++;
					System.out.println("For Sum = "+(int)sum+"  ---> a = "+pair1.getX()+" b = "+pair1.getY()+"  <---->  c = "+pair2.getX()+" d = "+pair2.getY());
				}
			}
		}
		System.out.println("No of combinations : "+counter);
	}

	public static void main(String[] args){
		int upperLimit = 12;
		SumOfCubesOfAplusBEqualsCplusD.printAllCombinations_brute(upperLimit);
		SumOfCubesOfAplusBEqualsCplusD.printAllCombinations_optimized_1(upperLimit);
		SumOfCubesOfAplusBEqualsCplusD.printAllCombinations_optimized_2(upperLimit);
	}

}
