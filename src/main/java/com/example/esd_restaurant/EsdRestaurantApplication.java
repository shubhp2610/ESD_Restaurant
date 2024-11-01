package com.example.esd_restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EsdRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdRestaurantApplication.class, args);
    }

}
