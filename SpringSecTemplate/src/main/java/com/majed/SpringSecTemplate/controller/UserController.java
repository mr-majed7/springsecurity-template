package com.majed.SpringSecTemplate.controller;

import com.majed.SpringSecTemplate.domain.model.Users;
import com.majed.SpringSecTemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.login(user);
    }
}
