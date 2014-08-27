package com.tripping.question.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tripping.question.core.domain.User;
import com.tripping.question.core.repository.UserRepository;

@Controller
@RequestMapping("/users/")
public class UserServer {

    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
