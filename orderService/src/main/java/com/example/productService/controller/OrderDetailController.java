package com.example.productService.controller;

import com.example.productService.entity.OrderDetail;
import com.example.productService.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetail")
@Slf4j
public class OrderDetailController  {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/save")
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.saveOrderDetail(orderDetail);
    }
}
