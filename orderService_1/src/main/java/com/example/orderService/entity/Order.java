package com.example.orderService.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;
    private Date invoiceDate;
    private Long userId;


}
