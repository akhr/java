package com.example.enumTest;

import java.util.ArrayList;

public class ParentClass<E extends ArrayList<E>> {
	
	E event;
	
	public ParentClass(E data){
		this.event = data;
	}
	
	public E getData(){
		return event;
	}
	
	public void displayData(){
		System.out.println("DataType = "+ event.getClass().getSimpleName());
		System.out.println("Data = "+ event);
	}

}
