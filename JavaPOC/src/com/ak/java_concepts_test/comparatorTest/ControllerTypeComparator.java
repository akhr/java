/**
 * 
 */
package com.thesaka.eg.comparatorTest;


/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public class ControllerTypeComparator implements java.util.Comparator<AbstractController> {

	@Override
	public int compare(AbstractController o1, AbstractController o2) {
		
		if(o1.getControllerType().getPriority() == o2.getControllerType().getPriority()) 
			return 0;
		else if(o1.getControllerType().getPriority() < o2.getControllerType().getPriority())
			return -1;
		else if (o1.getControllerType().getPriority() > o2.getControllerType().getPriority())
			return 1;
		
		return 0;
	}
}
