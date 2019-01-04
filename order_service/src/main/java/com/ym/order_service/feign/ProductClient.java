package com.ym.order_service.feign;

import com.ym.order_service.hystrix.ProductHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品服务客户端
 */
@FeignClient(name = "product-service",path = "/product",fallback = ProductHystrix.class)
public interface ProductClient {


    @GetMapping("/getAllProduct")
    String findAllProduct(@RequestParam(value = "pageNo") int pageNo, @RequestParam(value = "pageSize") int pageSize);


}
