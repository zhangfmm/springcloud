package com.ym.product_service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.ym.product_service.service.ProductService;
import com.ym.product_service.entity.Product;
import com.ym.product_service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public List<Product> findAllProduct(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectAllProduct();
    }
}
