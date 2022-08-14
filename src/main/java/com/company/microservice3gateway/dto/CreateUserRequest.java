package com.company.microservice3gateway.dto;

public class CreateUserRequest {
    private String username;
    private String password;
    private String name;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
