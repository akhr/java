/**
 * 
 */
package com.ak.codewhizMar16;

/**
 * @author Akhash Ramamurthy
 *
 * Mar 9, 2016 10:39:20 AM
 * Singleton.java
 */
class Singleton{
    
    private static Singleton INSTANCE;
    public String str;
    
    private Singleton(){
        
    }
    
    public Singleton getInstance(){
        if(INSTANCE == null){
        	INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}
