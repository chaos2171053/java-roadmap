package com.example.seckilldemo.service;

import com.example.seckilldemo.excetpion.InsufficientStockException;
import com.example.seckilldemo.mapper.ProductMapper;
import com.example.seckilldemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    // 可以添加其他业务逻辑方法，例如处理订单、更新库存等

    @Transactional
    public void purchaseProduct(Long productId, int quantity) throws InsufficientStockException {
        // 查询商品库存
        Product product = productMapper.getProductById(productId);

        // 检查库存是否充足
        if (product.getStock() < quantity) {
            throw new InsufficientStockException("Insufficient stock for product: " + productId);
        }

        // 更新库存
        int updatedStock = product.getStock() - quantity;
        product.setStock(updatedStock);
        productMapper.updateProductStock(product);

    }

    public Product getProductById(Long productId) {
        return productMapper.getProductById(productId);
    }
}
