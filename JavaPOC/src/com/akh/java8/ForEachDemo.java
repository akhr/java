package com.akh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerImpl implements Consumer<Integer>{

    @Override
    public void accept(Integer i) {
        System.out.println(i);
    }
}

public class ForEachDemo {

    public static void main(String[] args) {
        demo1();
        System.out.println();
        demo2();
        System.out.println();
        demo3();
        System.out.println();
        demo4();
        System.out.println();
    }

    public static void demo1(){
        System.out.println("Demo1");
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Consumer<Integer> consumer = new ConsumerImpl();
        myList.forEach(consumer);
    }

    public static void demo2(){
        System.out.println("Demo2");
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Consumer<Integer> consumerImpl = i -> System.out.println(i);
        myList.forEach(consumerImpl);
    }

    //lambda expr
    public static void demo3(){
        System.out.println("Demo3");
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        myList.forEach(i -> System.out.println(i));
    }

    public static void demo4(){
        System.out.println("Demo3");
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        myList.forEach(System.out::println);
    }
}
