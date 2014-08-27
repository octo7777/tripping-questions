package com.tripping.question.rest.controller;

import static com.google.common.collect.Lists.transform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripping.question.core.repository.UserRepository;
import com.tripping.question.rest.model.UserModel;

@Controller
@RequestMapping("/users")
public class UserServer {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> getAllUsers() {
        return transform(repository.findAll(), UserModel.FROM_USER);
    }
}
