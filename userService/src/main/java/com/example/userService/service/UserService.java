package com.example.userService.service;

import com.example.userService.entity.User;
import com.example.userService.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


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

    public Boolean login(String email, String passWord) {

        List<User> user = userRepo.login(email);

        if (user.isEmpty()){
            return false;
        }
        for (User user1 : user) {
            if (user1.getUserName().equals(email) && user1.getPassWord().equals(passWord)) {
                log.info(email + " login");
                return true;
            }
        }
        return true;
    }
}
