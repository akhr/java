/**
 * 
 */
package com.ak.codewhizMar16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 15, 2016 12:50:44 AM
 * ReadFromFile.java
 */
public class ReadFromFile {
	
	private static final String PATH = "./src/assests/";
	private static final String FILENAME = "bitManipulationInput_1.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		read();
	}
	
	public static void read(){
		BufferedReader br = null;
		try {
			System.out.println("Working Directory = " +System.getProperty("user.dir"));

			String sCurrentLine;
			File file = new File(PATH, FILENAME);
			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String[] strArr = sCurrentLine.split(" ");
				for(int i=0; i<strArr.length; i++)
					System.out.print(" "+ strArr[i]+" ");
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
