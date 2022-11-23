package com.example.orderService.vo;

import com.example.orderService.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateProductVO {
    private OrderDetail orderDetail;
    private  Product product;
}
