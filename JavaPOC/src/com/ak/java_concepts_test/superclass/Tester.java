package com.thesaka.eg.superclass;

public class Tester {

	/**
	 * @param args
	 */
	
	SuperClassA listObj;
	static Boolean flag;
	A a;
	
	public static void main(String[] args) {
		flag = true;
		Tester t = new Tester();
		t.initializeFunc();
	}
	
	public void initializeFunc(){
		for(int i=0;i<2;i++){
			if(i==0){
				a = new A();
				a.test();
			}else{
				a = new B();
				a.test();
//				a.test1();
			}
		}
		
		
	}
	
	class A{
		void test(){
			System.out.println("TEST SUPER");
		}
	}
	class B extends A{
		void test(){
			System.out.println("TEST SUB");
		}
		void test1()
		{
			System.out.println("TEST 1111111");
		}
	}

}
