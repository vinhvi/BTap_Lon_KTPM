package com.example.productService.service;

import com.example.productService.entity.OrderDetail;
import com.example.productService.repo.OrderDetailRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepo.save(orderDetail);
    }



}
