package com.example.orderService.service;

import com.example.orderService.entity.Order;
import com.example.orderService.repo.OrderRepo;
import com.example.orderService.vo.ResponseTemplateUserVO;
import com.example.orderService.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order) {
        log.info("Inside saveUser of UserService");
        return orderRepo.save(order);
    }

    public Order findById(Long id){
        return orderRepo.findByOrderId(id);
    }
    @Autowired
    private RestTemplate restTemplate;

//    public User getUserById(Long id){
//        User user =   restTemplate.getForObject("http://localhost:8521/user/" + id
//                , User.class);
//        return user;
//    }
    public ResponseTemplateUserVO getOrderWithUser(Long orderId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateUserVO vo = new ResponseTemplateUserVO();
        Order order = orderRepo.findByOrderId(orderId);

        User user =
                restTemplate.getForObject("http://localhost:9191/user/" + order.getUserId()
                        , User.class);

        vo.setUser(user);
        vo.setOrder(order);

        return  vo;
    }
}
