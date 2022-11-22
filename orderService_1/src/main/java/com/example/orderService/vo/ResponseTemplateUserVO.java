package com.example.orderService.vo;

import com.example.orderService.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateUserVO {
    private User user;
    private Order order;
}
