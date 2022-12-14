package com.company.microservice3gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;



@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class Microservice3GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Microservice3GatewayApplication.class, args);
    }


}
