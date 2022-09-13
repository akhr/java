package com.akh.java8;

interface A {
    void show(String name, String salutation);
}

public class LambdaDemo {
    public static void main(String[] args){
        A a = (name, salutation) -> System.out.println(salutation + " " + name);
        a.show("foo", "hello");
    }
}
