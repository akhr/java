package com.akh.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


/**
 * @author Akhash Ramamurthy
 * @date 05-17-2022
 */
public class Foo {

    public static final Logger logger = LoggerFactory.getLogger(Foo.class);

    public static void printFoo( int i){
        logger.info(MDC.get("app")+"Inside Foo:"+i);
    }
}
