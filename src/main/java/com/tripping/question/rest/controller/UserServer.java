package com.tripping.question.rest.controller;

import static com.google.common.collect.Lists.transform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tripping.question.core.domain.User;
import com.tripping.question.core.repository.UserRepository;
import com.tripping.question.rest.model.MyUserModel;
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

    @RequestMapping(value="/current", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    public MyUserModel getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = repository.findByName(auth.getName()).get(0);
        return new MyUserModel(user.getName(), user.getEmail(), user.getPoints(), user.getRoles());
    }

}
