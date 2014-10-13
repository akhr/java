package com.thesaka.eg.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^([0-9])+$");
		
		

		
	}
	
	private String getUserInput(){
		System.out.println("Enter something here : ");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    return bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
