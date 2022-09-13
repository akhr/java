package com.akh.java8;

interface Converter {
    String convert(String a, String b);
}

class ConverterUtil {
    public static String convertHelper(String s, String b) {
        if (s.length() < 4)
            return s.toUpperCase() + "_" + b.toLowerCase();
        return s.toLowerCase() + "_" + b.toUpperCase();
    }
}

public class MethodReferenceDemo {

    public static void main(String[] args) {
        String a = "hELlo";
        String b = "WorLd";

        System.out.println("converter_anomyous");
        Converter converter_anomyous = new Converter() {
            @Override
            public String convert(String a, String b) {
                return ConverterUtil.convertHelper(a, b);
            }
        };
        System.out.println(converter_anomyous.convert(a, b));


        System.out.println("converter_lambda");
        Converter converter_lambda = (a1, b1) -> (ConverterUtil.convertHelper(a1, b1));
        System.out.println(converter_lambda.convert(a, b));


        System.out.println("converter_meth_ref");
        Converter converter_meth_ref = (ConverterUtil::convertHelper);
        System.out.println(converter_meth_ref.convert(a, b));
    }
}
