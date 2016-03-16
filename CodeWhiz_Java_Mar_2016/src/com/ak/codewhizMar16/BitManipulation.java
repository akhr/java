/**
 * 
 */
package com.ak.codewhizMar16;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 9, 2016 7:47:35 PM
 * BitManipulation.java
 */
public class BitManipulation {

	public static void main(String[] args){
		Scanner st=new Scanner(System.in);
		int n=st.nextInt();
		int m=st.nextInt();
		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);
		for(int j=0; j<m; j++){
			b1.clear(j);
			b2.clear(j);
		}

		for(int i=0; i<m; i++){
			String operationStr = st.next();
			OPERATION op = OPERATION.getEnum(operationStr);
			BitSet left = st.nextInt() == 1 ? b1 : b2;
			
			switch(op){
			case AND:
			case OR: 
			case XOR:
				BitSet right = st.nextInt() == 1 ? b1 : b2;
				performTwoOperandOperation(left, right, op);
				break;
			case FLIP:
				int index1 = st.nextInt();
				if(index1<n)
					left.flip(index1);
				break;
			case SET:
				int index2 = st.nextInt();
				if(index2<n)
					left.set(index2);
				break; 
			}
			
			System.out.println(b1.cardinality()+" "+b2.cardinality());
		}
	}

	private static enum OPERATION {
		AND("AND"),
		OR("OR"),
		XOR("XOR"),
		FLIP("FLIP"),
		SET("SET"),
		INVALID("INVALID");

		private String name;

		private OPERATION(String name) {
			this.name = name;
		}

		public static OPERATION getEnum(String nam){
			if(nam != null && !nam.isEmpty()){
				if(nam.equalsIgnoreCase(AND.name))
					return AND;
				else if(nam.equalsIgnoreCase(OR.name))
					return OR;
				else if(nam.equalsIgnoreCase(XOR.name))
					return XOR;
				else if(nam.equalsIgnoreCase(FLIP.name))
					return FLIP;
				else if(nam.equalsIgnoreCase(SET.name))
					return SET;
				else
					return INVALID;
			}else{
				return INVALID;
			}
		}
	}

	private static void performTwoOperandOperation(BitSet left, BitSet right, OPERATION op){	
		switch(op){
		case AND:
			left.and(right);
			break;
		case OR:
			left.or(right);
			break;
		case XOR:
			left.xor(right);
			break;
		default:
			break;
		}
	}

}
