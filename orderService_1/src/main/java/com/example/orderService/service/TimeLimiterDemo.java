package com.example.orderService.service;

import org.springframework.stereotype.Service;

@Service
public class TimeLimiterDemo {
    public String slowMethod(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Slow service invoked successfully";
    }
}
