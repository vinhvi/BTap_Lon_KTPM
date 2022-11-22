package com.example.productService.vo;

import com.example.productService.entity.Order;
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
