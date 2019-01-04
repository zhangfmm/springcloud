package com.ym.order_service.hystrix;

import com.ym.order_service.feign.ProductClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProductHystrix implements ProductClient {
    @Override
    public String findAllProduct(@RequestParam(value = "pageNo") int pageNo, @RequestParam(value = "pageSize") int pageSize) {
        return "错误";
    }
}
