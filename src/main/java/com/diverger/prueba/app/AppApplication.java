package com.diverger.prueba.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class AppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
