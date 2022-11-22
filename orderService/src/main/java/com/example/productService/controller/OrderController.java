package com.example.productService.controller;

import com.example.productService.entity.Order;
import com.example.productService.service.OrderService;
import com.example.productService.vo.ResponseTemplateUserVO;
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
        return orderService.saveUser(order);
    }

    @GetMapping("/{id}")
    public ResponseTemplateUserVO getOrderWithUser(@PathVariable("id") Long orderId) {
        log.info("Inside getUserWithDepartment of UserController");
        return orderService.getOrderWithUser(orderId);
    }
}
