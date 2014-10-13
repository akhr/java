package com.thesaka.eg.StringTest;

public class MyString {
	char[] value;

	public MyString(String value){
		this.value = value.toCharArray();
	}
	
    public int hashCode() {
    	int h=0;
        if (value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
            	System.out.println("Char Val - "+val[i]);
            	System.out.println("Char Val INT- "+(int)val[i]);
                h = 31 * h + val[i];
            }
        }
        return h;
    }
    
    public static void main(String[] args){
    	MyString mys = new MyString("sS");
    	System.out.println("Hash - "+mys.hashCode());
    }

}
