package com.example.seckilldemo.mapper;

import com.example.seckilldemo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProducts();
    Product getProductById(Long productId);

    void updateProductStock(Product product);
}
