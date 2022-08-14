package com.company.microservice3gateway.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createTime;

    public UserDto(Long id, String username, String password, String name, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
