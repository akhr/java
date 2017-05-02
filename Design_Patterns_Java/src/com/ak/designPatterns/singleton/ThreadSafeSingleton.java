package com.ak.designPatterns.singleton;

public class ThreadSafeSingleton {
    private ThreadSafeSingleton(){
    	System.out.println("Inside Constructor");
    }
    
    //The static class inside which the INSTANCE needs to be initialized
    private static class SingletonHelper{
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }
    
    public static ThreadSafeSingleton getInstance(){
    	System.out.println("Inside getInstance");
        return SingletonHelper.INSTANCE;
    }
	public static void main(String[] args) {
		System.out.println("Inside  main");
		ThreadSafeSingleton.getInstance();
	}
}
