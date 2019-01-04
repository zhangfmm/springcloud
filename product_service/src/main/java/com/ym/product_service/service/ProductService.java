package com.ym.product_service.service;

import com.ym.product_service.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);

    List<Product> findAllProduct(int pageNum, int pageSize);
}