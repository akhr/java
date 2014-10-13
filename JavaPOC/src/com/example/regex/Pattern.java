package com.example.regex;

public class Pattern {


	public static void main(String[] args) {

		// TODO Auto-generated method stub

		String pattern = "[a-zA-Z]+[,~!@#$%^&*()]+";
		String pattern2 = "((?=.*[a-zA-Z]+)(?=.*[@#$%]+))";
		String pattern3 = "^([a-zA-Z]+)(([a-zA-Z0-9]*)|([a-zA-Z0-9,~!@#$%^&*()-_=]*))$";
		String pattern4 = "[a-z]+";
 
		String chk = "12123a";

		if(chk.matches(pattern4)){

			System.out.println("Matching");

		}else{

			System.out.println("NOOOOOOOOOOOOOOO");

		}

	}
}
