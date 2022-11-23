package com.example.orderService.controller;


import com.example.orderService.entity.Order;
import com.example.orderService.entity.OrderDetail;
import com.example.orderService.service.OrderDetailService;
import com.example.orderService.vo.ResponseTemplateProductVO;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/orderDetail")
@Slf4j
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/save")
    public OrderDetail savOrderDetail1(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    @GetMapping("/getByOrderId/{id}")
    public List<ResponseTemplateProductVO> getOrderDetailWithOrderId(@PathVariable(name = "id") Long order_id) {
        return orderDetailService.getOrderDetailWithProduct(order_id);
    }

    @GetMapping("/{id}")
    public List<OrderDetail> getByOrderId(@PathVariable(name = "id") Long id){
        return orderDetailService.getOrderDetail(id);
    }


}
