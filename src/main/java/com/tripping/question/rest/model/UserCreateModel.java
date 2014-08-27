package com.tripping.question.rest.model;

import com.tripping.question.core.domain.User;

public class UserCreateModel {
    private String name;
    private String email;
    private String password;

    public UserCreateModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        return new User(name, email, password);
    }
}
