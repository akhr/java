package com.akh.java8.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class SteamAPI_PrimeNumbers {

    public static int printFirstPrimeAfter(int a){
        return IntStream.iterate(a+1, b -> b+1)
                .filter(SteamAPI_PrimeNumbers::isPrime)
                .findAny()
                .orElse(0);
    }

    public static void printAllPrimes(){
        IntStream.range(20, 100)
                .filter(SteamAPI_PrimeNumbers::isPrime)
                .findAny()
                .ifPresent(System.out::println);
    }

    public static boolean isPrime(int a) {
        System.out.println("isPrime called for - "+a);
        // if condition is not i <= a/2 then 4 will escape this for loop and will be marked as prime.
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    @Test
    public void test01() {
        Assert.assertFalse(isPrime(4));
    }

    @Test
    public void test02() {
        printAllPrimes();
    }

    @Test
    public void test03() {
        Assert.assertEquals(19, printFirstPrimeAfter(17));
        Assert.assertEquals(875491, printFirstPrimeAfter(875484));
    }
}
