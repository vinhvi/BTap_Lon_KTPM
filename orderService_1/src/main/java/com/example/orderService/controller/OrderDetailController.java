package com.example.orderService.controller;


import com.example.orderService.entity.OrderDetail;
import com.example.orderService.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/orderDetail")
@Slf4j
public class OrderDetailController  {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/save")
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderDetail){
        return orderDetailService.saveOrderDetail(orderDetail);
    }
}
