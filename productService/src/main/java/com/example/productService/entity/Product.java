package com.example.productService.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private int count;
    private double price;
}
