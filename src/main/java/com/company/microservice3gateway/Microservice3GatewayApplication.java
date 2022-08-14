package com.company.microservice3gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
@OpenAPIDefinition(
        info = @Info(
                title = "Gateway Rest API",
                description = "MicroService",
                version = "v1"
        )
)
public class Microservice3GatewayApplication {



    public static void main(String[] args) {
        SpringApplication.run(Microservice3GatewayApplication.class, args);
    }


}
