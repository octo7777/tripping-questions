package com.tripping.question.rest.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripping.question.core.domain.User;
import com.tripping.question.core.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserCommands {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BigInteger addUser(@RequestBody User user) {
        return userRepository.save(user).getId();
    }
}
