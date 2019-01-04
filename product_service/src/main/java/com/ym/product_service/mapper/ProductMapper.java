package com.ym.product_service.mapper;

import com.ym.product_service.entity.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //这个方式我自己加的
    List<Product> selectAllProduct();
}