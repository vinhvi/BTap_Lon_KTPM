package com.example.productService.service;

import com.example.productService.entity.Order;
import com.example.productService.repo.OrderRepo;
import com.example.productService.vo.ResponseTemplateUserVO;
import com.example.productService.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order saveUser(Order order) {
        log.info("Inside saveUser of UserService");
        return orderRepo.save(order);
    }
    @Autowired
    private RestTemplate restTemplate;

    public ResponseTemplateUserVO getOrderWithUser(Long orderId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateUserVO vo = new ResponseTemplateUserVO();
        Order order = orderRepo.findByOrderId(orderId);

        User user =
                restTemplate.getForObject("http://USER-SERVICE/user/" + order.getUserId()
                        ,User.class);

        vo.setUser(user);
        vo.setOrder(order);

        return  vo;
    }
}
