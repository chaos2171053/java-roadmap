package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProducts();
    Product getProductById(Long productId);

    void updateProductStock(Product product);
}
