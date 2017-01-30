package com.akh.java_concepts_test.InterfaceTest2;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;


public class Tester {

	/**
	 * @param args
	 */
	
	private Object      calledObj = null;
	private Method      calledMethod = null;

	private Class[]     paramTypes;
	private Object[]    paramValues;
	
	
	public static void main(String[] args) {
		
		Tester t = new Tester();
		Implementation3 impl = new Implementation3();
		
		Class[] paramTypes = { String.class};

		Object[] paramValues = { "stringMessage" };
		
		t.getInterfaces( impl,"implementThisMethod" , paramTypes, paramValues);


	}
	

    //Check at first if calledObj has interfaces
    //with methodName method
    //
	public void getInterfaces(Object calledObj, String methodName, Class[] paramTypes, Object[] paramValues)
	{
	    this.calledObj = calledObj;
	    this.paramTypes = paramTypes;
	    this.paramValues = paramValues;

	    Class classObj = (calledObj instanceof Class) ? (Class)calledObj : calledObj.getClass();

		Class[]  interfaces = classObj.getInterfaces();
	    for (int i=0; i< interfaces.length; i++)
	    {
	      try
	      {
	        calledMethod = interfaces[i].getMethod(methodName, paramTypes);
	        System.out.println("callerMethod from " + interfaces[i].getName() + " = " + calledMethod.getName());
	      }
	      catch(NoSuchMethodException exp)
	      {
	        continue;
	      }
	      catch(SecurityException exp)
	      {
	        exp.printStackTrace();
	        return;
	      }
	    }

	    //If called method was not found in interfaces, then
	    //try to find that in object
	    //
	    if (calledMethod==null)
			try {
				calledMethod = classObj.getMethod (methodName, paramTypes);
				System.out.println("callerMethod from Class= " + calledMethod.getName());
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		System.out.println("The final value of calledMethod is ");
	}
    
  

}
