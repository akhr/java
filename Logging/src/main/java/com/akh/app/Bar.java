package com.akh.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


/**
 * @author Akhash Ramamurthy
 * @date 05-17-2022
 */
public class Bar {

    public static final Logger logger = LoggerFactory.getLogger(Bar.class);

    public static void printBar( int i){
        logger.info(MDC.get("app")+"Inside Bar:"+i);
    }
}
