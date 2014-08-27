package com.tripping.question.rest.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripping.question.core.repository.UserRepository;
import com.tripping.question.rest.model.UserCreateModel;

@Controller
@RequestMapping("/users")
public class UserCommands {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BigInteger addUser(@RequestBody UserCreateModel userModel) {
        return userRepository.save(userModel.toUser()).getId();
    }
}
