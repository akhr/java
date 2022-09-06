package com.akh.hellospbat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HelloSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBatchApplication.class, args);
    }

}
