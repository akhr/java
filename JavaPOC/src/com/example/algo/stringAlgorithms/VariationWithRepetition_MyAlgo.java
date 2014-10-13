/**
 * 
 */
package com.example.algo.stringAlgorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akhash Ramamurthy
 * Java_POC
 * Jul 6, 2012
 */
public class VariationWithRepetition_MyAlgo {

    public static void main(String[] args) throws IOException {
        List<char[]> items = new ArrayList<char[]>();
        char[] item = new char[3];
        char[] input = {'A', 'B'};
        int combiCount = 2;
       
        generate(input, 3);

        for (char[] rep : items) {
            System.out.println(rep);
        }
    }
    
    private static List<String> generate(char[] input, int count){
    	
    	List<String> output = new ArrayList<String>();
    	StringBuffer sB = new StringBuffer();
    	
    	/*for(int i=0; i<input.length; i++){
    		sB.delete(sB.length()-3, sB.length()-1);
    		sB.append(input[i]);
    		for(int j=0; j<input.length; j++){
    			sB.delete(sB.length()-2, sB.length()-1);
    			sB.append(input[j]);
    			for(int k=0; k<input.length; k++){
    				sB.append(input[k]);
    				output.add(sB.toString());
    				System.out.println(sB.toString());
    				sB.deleteCharAt(sB.length()-1);
    			}
    		}
    	}*/
    	
    	int counter = 0;
    	int loopCount = (int)Math.pow(input.length,count);
    	
    	for(int i=0; i<loopCount; i++){
//    		for (int j=0; j < count ; j++) {
//    			System.out.println("Counter = " +counter++);
//			}
    		System.out.println("Counter = " +counter++);
    		
    	}
    	
    	return output;
    }
    
    
}
