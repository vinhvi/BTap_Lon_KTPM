package com.example.orderService.controller;


import com.example.orderService.entity.Order;
import com.example.orderService.service.OrderService;
import com.example.orderService.service.TimeLimiterDemo;
import com.example.orderService.vo.ResponseTemplateUserVO;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private final TimeLimiterDemo timeLimiterDemo;


<<<<<<< HEAD
    JedisPool jedisPool = new JedisPool("127.0.0.1");
    Jedis jedis = jedisPool.getResource();
=======

>>>>>>> 0b8917e670225af1e6ebb87cae4d63cb30a00532
    public OrderController(TimeLimiterDemo timeLimiterDemo) {
        this.timeLimiterDemo = timeLimiterDemo;
    }


    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        log.info("Inside saveOrder of OrderController");
        return orderService.saveOrder(order);
    }

    @GetMapping("/get/{id}")
    @TimeLimiter(name = "orderDetail")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/get-demoTimeLimiter/{id}")
    @TimeLimiter(name = "orderDetail")
    public  CompletableFuture<String> getById(@PathVariable("id") Long id) {
        return CompletableFuture.supplyAsync(timeLimiterDemo::slowMethod);
    }

<<<<<<< HEAD
    @PostMapping("/addOrderToRedis")
    public String addToCart(@RequestBody Order order){
        jedis.sadd("order", String.valueOf(order.getOrderId()));
        return "save order id to redis";
    }

    @GetMapping("/getOrderFromRedis")
    public List<Order> getOrderFromRedis(){
        List<Order> orders = new ArrayList<>();
        Set<String> order_id = jedis.smembers("order");
        for(String id : order_id){
            Long id_order = Long.valueOf(id);
            orders.add(orderService.findById(id_order));
        }
        return orders;
    }

    @DeleteMapping("/removerRedis")
    public String removerAllFromCart(){
        jedis.del("order");
        return "Done";
    }
=======



>>>>>>> 0b8917e670225af1e6ebb87cae4d63cb30a00532

    @GetMapping("/getOrderWithUser/{id}")
    @Retry(name = "order")
    public ResponseTemplateUserVO getOrderWithUser(@PathVariable("id") Long orderId) {
        log.info("Inside getUserWithDepartment of UserController");
        return orderService.getOrderWithUser(orderId);
    }

    @ExceptionHandler({TimeoutException.class})
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public String handleTimeoutException() {
        return "User service is full and does not permit further calls";
    }

}
