package com.tripping.question.rest.model;

import com.google.common.base.Function;
import com.tripping.question.core.domain.User;

/**
 * Created by piotrok on 8/27/14.
 */
public class UserModel {

    public static final Function<User, UserModel> FROM_USER = new Function<User, UserModel>() {
        @Override
        public UserModel apply(User input) {
            return fromUser(input);
        }
    };

    private String name;
    private String email;
    private long points;

    public UserModel() {
    }

    public UserModel(String name, String email, long points) {
        this.name = name;
        this.email = email;
        this.points = points;
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

    public static UserModel fromUser(User user) {
        return new UserModel(user.getName(), user.getEmail(), user.getPoints());
    }
}
