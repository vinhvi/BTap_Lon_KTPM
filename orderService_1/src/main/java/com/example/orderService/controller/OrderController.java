package com.example.orderService.controller;


import com.example.orderService.entity.Order;
import com.example.orderService.service.OrderService;
import com.example.orderService.vo.ResponseTemplateUserVO;
import com.example.orderService.vo.User;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        log.info("Inside saveOrder of OrderController");
        return orderService.saveOrder(order);
    }
    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id){
        return orderService.findById(id);
    }

//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable("id") Long id){
//        return orderService.getUserById(id);
//    }
    @GetMapping("/getOrderWithUser/{id}")
    public ResponseTemplateUserVO getOrderWithUser(@PathVariable("id") Long orderId) {
        log.info("Inside getUserWithDepartment of UserController");
        return orderService.getOrderWithUser(orderId);
    }

}
