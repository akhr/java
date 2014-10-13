package com.example.algo;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Multiplication {


	public static void main(String[] args){

		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(2);
		input1.add(3);
		
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(4);
		input2.add(5);
		
		System.out.println("Output = " +multiply("191", "99"));
	}


	/*public static List<Integer> product(List<Integer> a, List<Integer> b){
		int product = 0;
		int carry = 0;
		List<Integer> fResult = new ArrayList<Integer>();
		
		System.out.println("a.size() = " +a.size());
		System.out.println("b.size() = " +b.size());
		
		for(int i1=b.size()-1; i1>=0; i1--){
			System.out.println("b.elements = " +b.get(i1));
		}
		
		
		for(int i=b.size()-1; i>=0; i--){

			List<Integer> innerResult = new ArrayList<Integer>();
			int k=0;

			if(i>0){
				for(k=0; k<= i; k++){
					innerResult.add(0);
				}
			}

			for(int j = a.size()-1; j>=0; j--){
				product = (b.get(i) * a.get(j)) + carry;
				if(product > 9){
					carry = product / 10; 
					innerResult.add(k, product%10);
				}else
					innerResult.add(k, product);
			}
			
			carry = 0;

			if(fResult.size()==0){
				Iterator<Integer> it = innerResult.iterator();
				while(it.hasNext())
					fResult.add(0, it.next());
			}else{
				
				List<Integer> outerResult = new ArrayList<Integer>();
				outerResult.addAll(fResult);
				fResult.clear();
				
				for(int mCounter = innerResult.size(), frCounter=fResult.size(); mCounter<=0; mCounter--,frCounter--){
					int sum = innerResult.get(mCounter) + fResult.get(frCounter) + carry;
					if(sum > 9){
						carry = sum / 10; 
						fResult.add(frCounter, product%10);
					}else
						fResult.add(frCounter, product);
				}
				
			}
				

		}
		return fResult;
	} */
	
	public static String multiply(String num1, String num2){
        int product, carry=0, sum=0;
        String result = new String("");
        String partial = new String("");
        ArrayList<String> partialList = new ArrayList<String>();

        /* computing partial products using this loop. */
        for(int j=num2.length()-1 ; j>=0 ; j--) {
            for(int i=num1.length()-1 ; i>=0 ; i--) {       

                product = Integer.parseInt((new Character(num1.charAt(i))).toString()) * 
                                Integer.parseInt((new Character(num2.charAt(j))).toString()) + carry;               
                carry = product/10;
                partial = Integer.toString(product%10) + partial;               
            }       

            if(carry != 0)
                partial = Integer.toString(carry) + partial;

            partialList.add(partial);
            partial = "";
            carry = 0;
        }                           

        /* appending zeroes incrementally */
        for(int i=0 ; i<partialList.size() ; i++)
            partialList.set(i, partialList.get(i) + (Long.toString( (long)java.lang.Math.pow(10.0,(double)i))).substring(1)   );        

        /* getting the size of the largest partial product(last) */
        int largestPartial = partialList.get(partialList.size()-1).length();

        /* prefixing zeroes */
        int zeroes;
        for(int i=0 ; i<partialList.size() ; i++) {
            zeroes =  largestPartial - partialList.get(i).length();

            if(zeroes >= 1)
            partialList.set(i, (Long.toString( (long)java.lang.Math.pow(10.0,(double)zeroes))).substring(1) + partialList.get(i)   );
        }

        /* to compute the result */
        carry = 0;
        for(int i=largestPartial-1 ; i>=0 ; i--) {

            sum = 0;
            for(int j=0 ; j<partialList.size() ; j++)
                sum = sum + Integer.parseInt(new Character(partialList.get(j).charAt(i)).toString());

            sum = sum + carry;
            carry = sum/10;         
            result = Integer.toString(sum%10) + result;     
        }

        if(carry != 0)
            result = Integer.toString(carry) + result;
        
        return result;

	}
}
