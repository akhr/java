package com.akh.java8;

import java.time.*;

public class DateTimeDemo {

    public static void main(String[] args){
        LocalDate localDate = LocalDate.of(2902, Month.MARCH, 31);
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Calcutta"));
        System.out.println(localTime);

//        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);

        System.out.println("Instance is always UTC : "+ Instant.now());

        //needs exploration.
        System.out.println("Instance is always IST : "+ Instant.now(Clock.system(ZoneId.of("Asia/Calcutta"))));

    }
}
