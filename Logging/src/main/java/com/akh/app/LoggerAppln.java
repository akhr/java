package com.akh.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.invoke.MethodHandles;
import java.util.stream.IntStream;

/**
 * @author Akhash Ramamurthy
 * @date 05-17-2022
 */
public class LoggerAppln {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAppln.class.getSimpleName());

    public static void main(String... args) {
        MDC.put("app", LoggerAppln.class.getSimpleName());
        IntStream.rangeClosed(1, 10).forEach(counter -> {
            logger.error(MDC.get("app")+" Counter:" + counter);
            Foo.printFoo(counter);
            Bar.printBar(counter);
        });
    }
}
