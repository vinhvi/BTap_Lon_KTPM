package com.example.userService.controller;

import com.example.userService.entity.User;
import com.example.userService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        log.info("save " + user);
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody String userName, String passWord) {
        log.info("login" + userName);
        if (!userService.login(userName, passWord)) {
            return "Sai tài khoản hoặc mật khẩu";
        }
        return userName + "login";
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        log.info("search user by " + userId);
        return userService.findUserById(userId);
    }
}
