/**
 * 
 */
package com.thesaka.eg.enumTest;

/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class InnerEnumTestClass<E extends Enum<E>> {
	
	public E enumtype;
	
	

	/**
	 * @param enumtype
	 */
	public InnerEnumTestClass(E enumtype) {
		super();
		this.enumtype = enumtype;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		InnerEnumTestClass<Days> testObj = new InnerEnumTestClass<Days>(Days.WeekDays.MONDAY);

	}

}
