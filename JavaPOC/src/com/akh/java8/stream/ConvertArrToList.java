package com.akh.java8.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertArrToList {

    public List<Integer> convertIntArrToList(int[] input) {
        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }

    @Test
    public void test01() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Assert.assertEquals(expected, convertIntArrToList(input));
    }

    public List<Character> convertStringToCharList(String input) {
        return input.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    @Test
    public void test02() {
        String input = "something foo";
        List<Character> expected = Arrays.asList('s', 'o', 'm', 'e', 't', 'h', 'i', 'n', 'g', ' ', 'f', 'o', 'o');
        Assert.assertEquals(expected, convertStringToCharList(input));
    }

    public List<Integer> convertStrToIntList(String input) {
        return input.chars().boxed().collect(Collectors.toList());
    }

}
