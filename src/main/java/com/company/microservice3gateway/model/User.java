package com.company.microservice3gateway.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;

    private LocalDateTime createTime;

    public User() {
    }

    public User(Long id, String username, String password, String name, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.createTime = createTime;
    }

    public User(String username, String password, String name, LocalDateTime createTime) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(createTime, user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, createTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
