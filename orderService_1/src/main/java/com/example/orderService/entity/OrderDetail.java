package com.example.orderService.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_orderDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    private Long productId;
    private int countProduct;
}
