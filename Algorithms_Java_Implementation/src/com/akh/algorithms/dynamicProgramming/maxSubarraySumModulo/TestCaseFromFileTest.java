/**
 * 
 */
package com.akh.algorithms.dynamicProgramming.maxSubarraySumModulo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.akh.algorithms.dynamicProgramming.maxSubarraySumModulo.MaxSubarraySumModulo.TestCaseData;

import sun.util.logging.resources.logging;

/**
 * @author Akhash Ramamurthy
 * Jan 8, 2017
 */
public class TestCaseFromFileTest {

	public static void main(String[] args) {
//		int tcs = 5;
//		int n = 100000 ;
//		long m = 10002143548612L;
//		long[] data = new long[n];
		readInputFromFile("testCases/MaxSubarraySumModulo.txt");

	}

	public static TestCaseData[] readInputFromFile(String fileName)
	{
		BufferedReader bufferedreader;
		TestCaseData[] cases = null;
		try
		{
			FileReader filereader = new FileReader(fileName);
			bufferedreader = new BufferedReader(filereader);
			
			String line = bufferedreader.readLine();
			int queryCount = Integer.parseInt(line);
			cases = new TestCaseData[queryCount];
			int outerLoopCount = queryCount*2;
			
			while (outerLoopCount > 0) {
				TestCaseData caseData = new TestCaseData();
				line = bufferedreader.readLine();
				String[] strValues = line.split(" ");
				caseData.n = Integer.parseInt(strValues[0]);
				caseData.m = Long.parseLong(strValues[1]);
				caseData.data = new long[caseData.n];
				
				line = bufferedreader.readLine();
				strValues = line.split(" ");
				int innerLoopCount = caseData.n-1;
				while(innerLoopCount >= 0){
					//Try to parse integer from the String line
					try {
						caseData.data[innerLoopCount] = Long.parseLong(strValues[innerLoopCount]);
					} catch (NumberFormatException nfe) {
						System.err.println("Failed to parse integer from line:" + line);
						System.err.println(nfe.getMessage());
						System.exit(1);
					}
					innerLoopCount--;
				}
				outerLoopCount --;
			}
		}
		catch(FileNotFoundException filenotfoundexception)
		{
			System.out.println("File not found.");
		}
		catch(IOException ioexception)
		{
			System.out.println("File input error occured!");
			ioexception.printStackTrace();
		}
		return cases;
	}

}
