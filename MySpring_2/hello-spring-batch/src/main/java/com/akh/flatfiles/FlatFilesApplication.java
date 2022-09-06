package com.akh.flatfiles;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Akhash Ramamurthy
 * @date 05-09-2022
 */

@SpringBootApplication
@EnableBatchProcessing
public class FlatFilesApplication {

    public static void main(String[] args){
        SpringApplication.run(FlatFilesApplication.class, args);
    }
}
