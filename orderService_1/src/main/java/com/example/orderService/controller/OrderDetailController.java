package com.example.orderService.controller;

import com.example.orderService.entity.OrderDetail;
import com.example.orderService.service.OrderDetailService;
import com.example.orderService.vo.ResponseTemplateProductVO;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeoutException;

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
    @Retry(name = "order")
    public List<ResponseTemplateProductVO> getOrderDetailWithOrderId(@PathVariable(name = "id") Long order_id) {
        return orderDetailService.getOrderDetailWithProduct(order_id);
    }




    @GetMapping("/{id}")
    public List<OrderDetail> getByOrderId(@PathVariable(name = "id") Long id){
        return orderDetailService.getOrderDetail(id);
    }


}
