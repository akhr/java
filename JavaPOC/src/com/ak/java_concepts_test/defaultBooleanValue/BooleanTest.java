package com.thesaka.eg.defaultBooleanValue;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BooleanTest {

	/**
	 * @param args
	 */
	
	private static boolean flag;
	static DecimalFormat wholeDecimalFormater = new DecimalFormat("###,###.##");
	
	public static void main(String[] args) {
		
		String val = wholeDecimalFormater.format(new BigDecimal(1));
		System.out.println("Value = "+ val);
		
		
		

	}

}
