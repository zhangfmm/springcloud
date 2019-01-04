package com.ym.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.ym.order_service.domain.ProductOrder;
import com.ym.order_service.feign.ProductClient;
import com.ym.order_service.service.ProductOrderService;
import com.ym.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    private ProductClient productClient;


    @Override
    public ProductOrder save(int userId, int productId) {

        String response = productClient.findAllProduct(1,3);

        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }




}
