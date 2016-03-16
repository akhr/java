package com.thesaka.eg.formatter.test;

import java.text.DecimalFormat;

public class Main {

  public static void main(String args[]) {

    double d = 2342423123456.789234234234234234234;
    DecimalFormat df = new DecimalFormat("###,000.00");
    System.out.println(df.format(d));

  }
}
