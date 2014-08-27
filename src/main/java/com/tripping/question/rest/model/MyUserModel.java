package com.tripping.question.rest.model;

import java.util.List;

public class MyUserModel {
    private String name;
    private String email;
    private long points;
    private List<String> roles;

    public MyUserModel(String name, String email, long points, List<String> roles) {
        this.name = name;
        this.email = email;
        this.points = points;
        this.roles = roles;
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

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
