package com.hankai.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.*;
import java.util.Map;

@RestController
@RefreshScope    // 动态刷新配置
public class ConfigClientController {

    @Value("${hankai.gender}")
    private String profile;
    @Value("${eureka.client.service-url.defaultZone}")
    private String aa;



    @ApiOperation("获取详细配置信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "String")
    @ApiParam(name = "name", value = "mingcheng")
    @GetMapping("/hello")
    public String hello(@RequestParam("id") String id){
        return this.profile + aa;
    }

}
