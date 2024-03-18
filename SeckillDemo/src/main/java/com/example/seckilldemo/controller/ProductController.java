package com.example.seckilldemo.controller;

import com.example.seckilldemo.excetpion.InsufficientStockException;
import com.example.seckilldemo.model.Product;
import com.example.seckilldemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public ResponseEntity<String> purchaseProduct(@RequestParam Long productId, @RequestParam int quantity) {
        try {
            productService.purchaseProduct(productId, quantity);
            return ResponseEntity.ok("Purchase successful!");
        } catch (InsufficientStockException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
