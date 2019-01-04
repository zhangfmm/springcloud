package com.ym.order_service.controller;


import com.ym.order_service.feign.ProductClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@Api(value = "product",description = "产品接口")
public class OrderController {

    @Autowired
    private ProductClient productClient;


    @GetMapping(value = "/getOrder")
    @ApiOperation(value = "查询所有商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer token", required = false, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "currentUser", value = "当前用户（可不传）", required = false, dataType = "user", paramType = "body"),
            @ApiImplicitParam(name = "pageNo", value = "分页页码", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页条数", required = true, dataType = "Integer", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    public String findAllUser(int pageNo, int pageSize){
        String allProduct = productClient.findAllProduct(pageNo, pageSize);
        return allProduct;
    }
}
