/**
 * 
 */
package com.thesaka.eg.genericsTypeTest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akhash Ramamurthy
 *
 * Feb 29, 2012
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<MyClass> list = new ArrayList<MyClass>(); 
		list.add(new MyClass("A"));
		list.add(new MyClass("B"));
		list.add(new MyClass("C"));
		list.add(new MyClass("D"));
		list.add(new MyClass("E"));
		list.add(new MyClass("F"));
		list.add(new MyClass("G"));
		
		(new Tester()).getObjectType(list, new MyClass("H"), 25);
	}
	
	private void getObjectType(Object... params){
		if(params[0] instanceof List<?>){
//			System.out.println("Param 0 : " + params[0].getClass().getSimpleName() +" + "+ params[0]);
		}
		
//		ParameterizedType genericType = Tester.class.get
//
//		if(genericType instanceof ParameterizedType){
//		    ParameterizedType aType = (ParameterizedType) genericType;
//		    Type[] fieldArgTypes = aType.getActualTypeArguments();
//		    for(Type fieldArgType : fieldArgTypes){
//		        Class fieldArgClass = (Class) fieldArgType;
//		        System.out.println("fieldArgClass = " + fieldArgClass);
//		    }
//		}
//		System.out.println("Param 1 : " + params[1].getClass().getSimpleName() +" + "+ ((MyClass)params[1]).getName());
		
//		System.out.println("Param 2 : " + params[2].getClass().getSimpleName() +" + "+ params[2]);
		
		
	}

}
