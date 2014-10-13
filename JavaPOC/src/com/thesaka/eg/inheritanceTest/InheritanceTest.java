/**
 * 
 */
package com.thesaka.eg.inheritanceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.omg.CORBA.OMGVMCID;

/**
 * @author Akhash Ramamurthy
 *
 * Jan 30, 2012
 */
public class InheritanceTest {

	private class Human{
		private Human(){
//			System.out.println("Human Class Instantiated");
		}
	}

	private class Indian extends Human{
		private Indian(){
//			System.out.println("Indian Class Instantiated");
		}
	}

	private class American extends Human{
		private American(){
//			System.out.println("American Class Instantiated");
		}
	}

	private class Worker{
		Human worker;
		
		private Worker(Human worker){
			System.out.println("Human Constructor Called");
			this.worker = worker;
			printClassTypes();
		}
		
		private Worker(Indian worker){
			System.out.println("Indian Constructor Called");
			this.worker = worker;
			printClassTypes();
		}
		
		private Worker(American worker){
			System.out.println("American Constructor Called");
			this.worker = worker;
			printClassTypes();
		}


		public void printClassTypes(){
			System.out.println("Worker is of Origin : " + worker.getClass().getSimpleName());
		}
	}
	
	public static void main(String[] args) {
		
		InheritanceTest test = new InheritanceTest();
		
		Human h = test.new Human();
		Indian  i = test.new Indian();
		American a = test.new American();
		
		Human hi = test.new Human();
		Human ha = test.new American();
		
		Worker workerRegister1 = test.new Worker(h);
		Worker workerRegister2 = test.new Worker(i);
		Worker workerRegister3 = test.new Worker(a);
		Worker workerRegister4 = test.new Worker((Indian)hi);
		Worker workerRegister5 = test.new Worker(ha);
		
	}

}
