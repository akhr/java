package com.akh.aa.mudField;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberOf1Bits {
    
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    
    @Test
    public void test_01() {
    	int a = -3;
    	int c = hammingWeight(a);
    	assertEquals(31, c);
    }
}
