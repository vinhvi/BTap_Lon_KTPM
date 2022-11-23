package com.example.orderService.service;


import com.example.orderService.entity.Order;
import com.example.orderService.entity.OrderDetail;
import com.example.orderService.repo.OrderDetailRepo;
import com.example.orderService.vo.Product;
import com.example.orderService.vo.ResponseTemplateProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private RestTemplate restTemplate;

    public List<OrderDetail> getOrderDetail(Long id){
        return orderDetailRepo.getOrderDetailByOrderId(id);
    }
    public List<ResponseTemplateProductVO> getOrderDetailWithProduct(Long order_id) {
        List<ResponseTemplateProductVO> vos = new ArrayList<>();
        ResponseTemplateProductVO vo = new ResponseTemplateProductVO();
        List<OrderDetail> orderDetails = orderDetailRepo.getOrderDetailByOrderId(order_id);
        for (OrderDetail orderDetail1 : orderDetails) {
            Product product = restTemplate.getForObject("http://localhost:9191/product/" + orderDetail1.getProductId(), Product.class);
            vo.setOrderDetail(orderDetail1);
            vo.setProduct(product);
            vos.add(vo);
        }


        return vos;
    }


    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepo.create(orderDetail.getOrderId(), orderDetail.getProductId(), orderDetail.getCountProduct());
    }


}
