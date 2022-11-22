package com.example.userService.service;

import com.example.userService.entity.User;
import com.example.userService.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        System.out.println("save " + user);
        return userRepo.save(user);
    }

    public User findUserById(Long userId) {
        log.info("search user by " + userId);
        return userRepo.findUserById(userId);
    }

    public Boolean login(String userName, String passWord) {
        log.info(userName + "login");
        List<User> user = userRepo.findAll();

        for (User user1 : user) {
            if (user1.getPassWord() == passWord && user1.getUserName() == userName) {
                return true;
            }
        }
        return false;
    }
}
