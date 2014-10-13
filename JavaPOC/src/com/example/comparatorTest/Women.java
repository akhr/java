/**
 * 
 */
package com.example.comparatorTest;

/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class Women implements HumanBeings {
	public Women(String firstName) {
		this.firstName = firstName;
	}
	public String toString() {
		return firstName;
	}
	
	public int compareTo(Women o) {
	    if(o instanceof Women)
	    	return 0;
	    else
	    	return 1;
	}
	
	private String firstName;

}
