package com.example.productService.service;

import com.example.productService.entity.Product;
import com.example.productService.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product) {
        log.info("save product: " + product);
        return productRepo.save(product);
    }

    public Product findProductById(Long id) {
        return productRepo.findProductById(id);
    }

    public Boolean update(Long id, Product product) {
        Product product1 = productRepo.findProductById(id);
        product1.setProductName(product.getProductName());
        product1.setCount(product.getCount());
        product1.setPrice(product.getPrice());
        productRepo.save(product1);
        return true;
    }

    public Product findProductByName(String productName) {
        List<Product> products = productRepo.findAll();
        for (Product product : products) {
            if (Objects.equals(product.getProductName(), productName)) {
                log.info("product: " + product);
                return product;
            }
        }
        return null;
    }

    public Boolean deleteProduct(Long id) {
        productRepo.deleteById(id);
        return true;
    }
}
