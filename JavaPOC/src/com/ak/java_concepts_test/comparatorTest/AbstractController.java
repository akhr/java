/**
 * 
 */
package com.thesaka.eg.comparatorTest;


/**
 * @author Akhash Ramamurthy
 *
 * Sep 28, 2011
 */
public abstract class AbstractController {

	public enum ControllerType{
		VIEW(1),
		DATA_VIEW(2),
		DATA(3);

		private int priority;

		ControllerType(int priority){
			this.priority = priority;
		}

		public int getPriority(){
			return priority;
		}

	}

	private ControllerType controllerType; 

	/**
	 * @param controllerType
	 */
	public AbstractController(ControllerType controllerType) {
		this.controllerType = controllerType;
	}

	public ControllerType getControllerType(){
		return this.controllerType;
	}
}
