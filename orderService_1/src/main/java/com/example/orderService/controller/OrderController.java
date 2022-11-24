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
