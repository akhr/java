package com.akh.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamAPIDemo_PrimitiveData {

    //get a integer array, square it, filter divisble by 3, find the sum.

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //non-lambda
        nonLambdaMethod(values);

        //lambda
        lambdaMethod(values);
    }

    public static void lambdaMethod(List<Integer> values){
        System.out.println("Lambda Method");
        values.stream()
                .map(i -> i*i)
                .filter(i -> i%3 == 0)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }


    public static void nonLambdaMethod(List<Integer> values){
        System.out.println("Non-Lambda Method");

        Function<Integer, Integer> sqFunc = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i * i;
            }
        };

        Predicate<Integer> filterPred = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i%3 == 0;
            }
        };

        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i, Integer j) {
                return i + j;
            }
        };

        values.stream().map(sqFunc).filter(filterPred).reduce(binaryOperator).ifPresent(System.out::println);
        System.out.println(values.stream().map(sqFunc).filter(filterPred).reduce(0,(i,j) -> Integer.sum(i,j)));

    }
}
