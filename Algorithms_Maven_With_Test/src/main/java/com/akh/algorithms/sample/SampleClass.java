package com.akh.algorithms.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  @fileName: SampleClass.java
 *  @author: Akhash Ramamurthy
 *  Created on: Jul 15, 2018
 */

public class SampleClass {

	public static void main(String[] args) {
		//Creating the Logger object
		Logger logger = LoggerFactory.getLogger("SampleLogger");

		//Logging the information
		logger.info("Hi This is my first SLF4J program");
	}

}
