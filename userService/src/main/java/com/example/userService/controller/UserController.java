package com.example.userService.controller;

import com.example.userService.entity.User;
import com.example.userService.service.UserService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
    public String login(@RequestBody User user) {
        if (!userService.login(user.getEmail(), user.getPassWord())){
            return "Sai tài khoản hoặc mật khẩu";
        }

        return  user.getEmail() + " Login";
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        log.info("search user by " + userId);
        return userService.findUserById(userId);
    }
}
