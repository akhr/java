package com.thesaka.eg.regex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ramamurthy
 *
 */
public class SSNValidator{
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		//		input.add("123-45-6789");
		//		input.add("9876-5-4321");
		//		input.add("987-65-4321 (attack)");
		//		input.add("90a-65-4321 ");
		//		input.add("234 t23413");
		//		input.add("sdfg43");
		input.add("Adsfgsd");
		input.add("Adsfgsd23");
		input.add("Adsf23gsd");
		input.add("!Adsf23gsd");
		input.add("12sfgsd");
		input.add("sfgsd23423");
		input.add("23543sfgsd56756");
		input.add("2341243%^$");
		input.add("345345");
		input.add("dfg%$^@$%^#$%^");


		for (String ssn : input) {
			/*		       if(ssn.matches("^[a-zA-Z]+$")){
		            System.out.println(ssn +" -->Contains Only Alpha");
		        }

		       if(ssn.matches("^[0-9]+$")){
		            System.out.println(ssn +" -->Contains Only NUM");
		        }*/

			if(ssn.matches(".*[^a-zA-Z0-9]+.*")){
				System.out.println(ssn +" -->Contains Spl Char also");
			}
		}
	}
}