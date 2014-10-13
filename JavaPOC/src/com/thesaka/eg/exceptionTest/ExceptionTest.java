package com.thesaka.eg.exceptionTest;

public class ExceptionTest {

	public ExceptionTest(String name) throws MyException {
		if(name == null || name.isEmpty())
			throw new MyException("Name is NULL");
		System.out.println("The name is NULL");
		call();
	}
	
	private void call(){
		System.out.println("Inside call()");
	}

}
