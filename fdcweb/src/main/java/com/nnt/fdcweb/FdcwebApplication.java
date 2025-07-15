package com.nnt.fdcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.nnt.fdcweb.controllers",
    "com.nnt.fdcweb.repository",
    "com.nnt.fdcweb.services",
    "com.nnt.fdcweb.config"
})

public class FdcwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdcwebApplication.class, args);
    }

}
