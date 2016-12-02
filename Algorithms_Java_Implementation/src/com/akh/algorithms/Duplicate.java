package com.akh.algorithms;

public class Duplicate {

    public static void main(String[] arg) {
        int[] array = {1, 3, 5, 6, 2, 3, 6, 4, 3, 2, 1, 6, 3};

        displayDuplicate(array);

    }

    static void displayDuplicate(int[] ar) {
        boolean[] done = new boolean[ar.length];
        for(int i = 0; i < ar.length; i++) {
            if(done[i])
                continue;
            int nb = 0;
            for(int j = i; j < ar.length; j++) {
                if(done[j])
                    continue;
                if(ar[j] == ar[i]) {
                    done[j] = true;
                    nb++;
                }
            }
            System.out.println(ar[i] + " occurs " + nb + " times");
        }
    }
}