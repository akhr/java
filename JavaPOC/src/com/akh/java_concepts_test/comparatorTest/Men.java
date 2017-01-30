/**
 * 
 */
package com.akh.java_concepts_test.comparatorTest;

import java.util.Arrays;

/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
class Men implements HumanBeings{
	  public Men(String firstName) {
	    this.firstName = firstName;
	  }
	  public String toString() {
	    return firstName;
	  }
/*	  public int compareTo(HumanBeings person) {
	    if(person instanceof Men)
	    	return 1;
	    else
	    	return 0;
	  }*/
	  
	  private String firstName;

	public int compareTo(Men o) {
	    if(o instanceof Men)
	    	return 1;
	    else
	    	return 0;
	}
}
