package com.kilic.hrproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kilic")
public class HrProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrProjectSpringBootApplication.class, args);
    }

}
