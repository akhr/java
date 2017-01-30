package com.akh.java_concepts_test.RoundOffDouble;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class Tester {

	/**
	 * @param args
	 */
	
	static DecimalFormat twoDecimalFormater = new DecimalFormat("###,###.##");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		double d = (double)220/(double)50;
		System.out.println("d = " + d);
		System.out.println("D = " + Math.ceil(d));
		double dd = 345345345345343485.9980834534534534;
		double ddd=0.0;
		try {
			ddd= twoDecimalFormater.parse(twoDecimalFormater.format(dd)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Double Value = "+ twoDecimalFormater.format(dd));
			e.printStackTrace();
		}
		twoDecimalFormater.setRoundingMode(RoundingMode.HALF_UP);
		twoDecimalFormater.setGroupingSize(3);
		System.out.println("Complex Value = "+ ddd);*/
		

		String dd = "234,234,657,456.4234";
		if(dd.indexOf("B") >= 0)
		{
			String[] dddd = dd.split("[,\\s]+");
			int i=0;
			StringBuilder sB = new StringBuilder();
			for(i=0; i<dddd.length; i++)
			{
				 sB.append(dddd[i]);
				System.out.println("String Value = "+ dddd[i]);
				System.out.println("Sb = " + sB);
			}
			
		}
		else
		{
			System.out.println("Double Value = "+ twoDecimalFormater.format(dd));
		}
		
	}

}
