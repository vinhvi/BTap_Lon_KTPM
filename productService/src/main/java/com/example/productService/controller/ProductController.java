package com.example.productService.controller;

import com.example.productService.entity.Product;
import com.example.productService.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
//    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 10000))
    public Product findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }
//    @Recover
//    public ResponseEntity<String> orderFallback(Exception e){
//        int attempts = 0;
//        return new ResponseEntity<String>("Item service is down", HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
    @GetMapping("/name")
    public Product findProductByName( @RequestBody String productName) {
        return productService.findProductByName(productName);
    }

    @PostMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }

    @PostMapping("/update/{id}")
    public Boolean updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
}
